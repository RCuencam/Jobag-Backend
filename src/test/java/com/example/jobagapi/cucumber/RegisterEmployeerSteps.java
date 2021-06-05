package com.example.jobagapi.cucumber;

import com.example.jobagapi.domain.model.Employeer;
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
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RegisterEmployeerSteps {
    @LocalServerPort
    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl="http://localhost:8080";
    private String error=null;
    Long cont = 1L;
    Long employeerId = 1L + cont;


    String email = randomString();

    Long number = randomLong();

    @Given("I can sign up as a employeer")
    public void i_can_sign_up_as_a_employeer() {
        String url=postUrl + "/api" + "/employeers/";
        String allEmployeers=restTemplate.getForObject(url, String.class);
        log.info(allEmployeers);
        assertTrue(!allEmployeers.isEmpty());
    }

    public String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }

    public Long randomLong() {
        long generatedLong = new Random().nextLong();
        return generatedLong;
    }

    @Given("I sending employeer to be created with employeer {long}")
    public void i_sending_employer(Long id) {
        String url=postUrl + "/api" + "/employeers/";
        Employeer newEmployeer = new Employeer(employeerId,"firstname","lastname",email,randomLong(),"password","document","posicion");
        Employeer employeer=restTemplate.postForObject(url,newEmployeer,Employeer.class);
        log.info(employeer);
        assertNotNull(employeer);
    }

    @Then("I should be able to see my newly created employeer")
    public void i_should_be_able_to_see_my_newly_created_employeer() {
        String url=postUrl+"/api" +"/employeers";
        Employeer employeer=restTemplate.getForObject(url,Employeer.class);
        assertNotNull(employeer);
    }


    @Given("register a repeated number")
    public void registerARepeatedNumber() {
        String url=postUrl + "/api" + "/employeers/";
        Employeer newEmployeer = new Employeer(employeerId,"firstname","lastname",email,1L,"password","document","posicion");

        try
        {
            Employeer employeer=restTemplate.postForObject(url,newEmployeer,Employeer.class);
            log.info(employeer);
        }catch(RestClientException e){
            error="El numero ya esta en uso";
        }
        assertEquals(error,"El numero ya esta en uso");
    }

    @Then("I should see a error message {string}")
    public void iShouldSeeAErrorMessageError(String string) {
        assertEquals(string,error);
    }
}
