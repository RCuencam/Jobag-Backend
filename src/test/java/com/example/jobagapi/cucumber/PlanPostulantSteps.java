package com.example.jobagapi.cucumber;


import com.example.jobagapi.domain.model.PlanPostulant;
import com.example.jobagapi.domain.model.Postulant;
import com.example.jobagapi.exception.ResourceNotFoundException;
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
public class PlanPostulantSteps {

    @LocalServerPort

    private RestTemplate restTemplate = new RestTemplate();
    private String getUrl="http://localhost:8080";
    private String error=null;

    Long postulantId = randomLong();


    @Given("I am in the plan section")
    public void i_am_in_the_plan_section() {
        String url=getUrl + "/api" + "/postulants/" + 1 + "/planpostulants";
        String allPlans=restTemplate.getForObject(url, String.class);
        log.info(allPlans);
        assertTrue(!allPlans.isEmpty());
    }

    public String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }
    public Long randomLong() {
        Long generatedLong = new Random().nextLong();
        return generatedLong;
    }
    public Integer randomInt() {
        int generatedInt = new Random().nextInt();
        return generatedInt;
    }

    @Given("I want to access to the plan with plan")
    public void i_want_to_access_to_the_plan_with_plan() {
        String postulanturl=getUrl + "/api" + "/postulants/";
        Postulant newpostulant = new Postulant(postulantId, "firstname", "lastname", randomString(), 123L, "password","document","married");
        Postulant postulant=restTemplate.postForObject(postulanturl,newpostulant,Postulant.class);

        String plansurl=getUrl + "/api" + "/postulants/" + postulant.getId() + "/planpostulants";
        PlanPostulant newplan = new PlanPostulant(randomLong(),randomString(),randomInt(),randomInt(),true,randomInt(),newpostulant);
        PlanPostulant planPostulant=restTemplate.postForObject(plansurl,newplan,PlanPostulant.class);

        log.info(planPostulant);
        log.info(postulant);

        assertNotNull(postulant);
        assertNotNull(planPostulant);
    }
    @Then("I want to see the plan with plan description {string},posts {int}, video {int} and duration {int}")
    public void i_want_to_see_the_plan(String description, Integer postulations, Integer video_duration, Integer duration) {
        String url=getUrl + "/api" + "/postulants/" + postulantId + "/planpostulants";
        PlanPostulant planPostulant=restTemplate.getForObject(url,PlanPostulant.class);
        assertNotNull(planPostulant);
    }

    @Given("I want to have more than one active payment plan")
    public void i_want_to_have_more_than_one_active_payment_plan() {
        String postulanturl=getUrl + "/api" + "/postulants/";
        Postulant newpostulant = new Postulant(postulantId, "firstname", "lastname", randomString(), 123L, "password","document","married");
        Postulant postulant=restTemplate.postForObject(postulanturl,newpostulant,Postulant.class);
        log.info(newpostulant);

        String plansurl=getUrl + "/api" + "/postulants/" + newpostulant.getId() + "/planpostulants";
        PlanPostulant newplan = new PlanPostulant(randomLong(),randomString(),randomInt(),randomInt(),true,randomInt(),newpostulant);
        try
        {
            PlanPostulant planPostulant=restTemplate.postForObject(plansurl,newplan,PlanPostulant.class);
            log.info(planPostulant);
        }catch(RestClientException e){
            error="Solo puedes tener un plan activo";
        }
        assertEquals(error,"Solo puedes tener un plan activo");
    }
    @Then("I should see a plan error message {string}")
    public void i_should_see_a_plan_error_message(String string) {
        assertEquals(string,error);
    }




}
