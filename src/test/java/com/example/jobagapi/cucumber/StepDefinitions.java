package com.example.jobagapi.cucumber;

import com.example.jobagapi.domain.model.Skill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions {

    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    private String postUrl="http://localhost:8080";

    private Long skillId=1L;

    @Given("I can a new skill")
    public void i_can_create_a_new_skill() {
        String url=postUrl + "/api" + "/skills";
        String allSkill=restTemplate.getForObject(url, String.class);
        log.info(allSkill);
        assertTrue(!allSkill.isEmpty());
    }
    @Given("^I sending post to be created with post id (.*),name (.*) and description (.*)")
    public void i_sending_skill(Long id, String name, String description) {
        String url=postUrl + "/api" + "/skills";
        Skill newSkill = new Skill();
        newSkill.setId(id);
        newSkill.setName(name);
        newSkill.setDescription(description);

        Skill skill = restTemplate.postForObject(url,newSkill,Skill.class);
        skillId=skill.getId();
        log.info(skill);
        assertNotNull(skill);
    }
    @Then("I should be able to see my newly created skill")
    public void i_should_see_my_newly_created_skill() {
        String url=postUrl + "/api" + "/skill/" + skillId + "}";

        Skill skill = restTemplate.getForObject(url,Skill.class);
        log.info(skill);
        assertNotNull(skill);
    }
}
