package com.example.jobagapi.cucumber;

import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.Interview;
import com.example.jobagapi.domain.model.JobOffer;
import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.exception.ResourceNotFoundException;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PostulantEmailSteps {

    @LocalServerPort
    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl="http://localhost:8080";

    private String error=null;

    @Given("I am in the register seccion")
    public void iAmInTheRegisterSection() {

        String url=postUrl + "/api" + "/postulants/";
        String allPostulants=restTemplate.getForObject(url, String.class);
        log.info(allPostulants);
        assertTrue(!allPostulants.isEmpty());
    }

    public String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }

    @Given("register with id {long} and email")
    public void I_register_with_email(Long Id){

        Postulant newpostulant = new Postulant(Id, "firstname", "lastname", randomString(), 123L, "password","document","civil");
        String url=postUrl + "/api" + "/postulants/";
        Postulant postulant=restTemplate.postForObject(url,newpostulant,Postulant.class);

        log.info(postulant);

        assertNotNull(postulant);
    }


    @Then("I should be able to register")
    public void i_want_to_see_my_register() {
        String url=postUrl+"/api" +"/postulants";
        Postulant postulant=restTemplate.getForObject(url,Postulant.class);
        assertNotNull(postulant);
    }



    @Given("register a repeat email")
    public void register_a_repeat_email() {
        Postulant newpostulant = new Postulant(1L, "firstname", "lastname", "a", 123L, "password","document","civil");
        String url=postUrl + "/api" + "/postulants/";

        try
        {
            Postulant post=restTemplate.postForObject(url,newpostulant,Postulant.class);
            log.info(post);
        }catch(RestClientException e){
            error="El email ya esta en uso";
        }
        assertEquals(error,"El email ya esta en uso");
    }


    @Then("I should see a message {string}")
    public void i_Should_See_A_MessageError(String string) {

        assertEquals(string,error);
    }
}




