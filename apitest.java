package com.jcg.StepDefinitions;

import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void verifyThatR2D2skinColorIsWhiteAndBlue(){
        RestAssured.
                when().get("https://swapi.dev/api/people/").
                then().assertThat().body("results.name[2]", equalTo("R2-D2"),
                "results.skin_color[2]", equalTo("white, blue"));

    }
}
