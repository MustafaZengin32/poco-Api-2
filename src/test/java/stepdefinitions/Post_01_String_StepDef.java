package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import static baseUrl.URL01_Reqres_BaseUrl.spec1;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post_01_String_StepDef {

    Response response;

    @Given("kullanici {string} sitesine gider")
    public void kullaniciHttpsReqresInApiUsersSitesineGider(String url) {

        spec1.pathParam("a","users");
    }


    @And("post islemi yapar")
    public void postIslemiYapar() {

        String payLoad= "{\n" +
                "    \"name\": \"Ali Mustafa Zengin\",\n" +
                "    \"job\": \"Pilot\"\n" +
                "}";

        response = given(spec1).body(payLoad).post("{a}");

        response.prettyPrint();

    }

    @Then("response dogrulanir")
    public void responseDogrulanir() {

        String name=response.jsonPath().getString("name");
        String job=response.jsonPath().getString("job");


        response.then()
                .statusCode(201);

        Assert.assertEquals(name,"Ali Mustafa Zengin");
        Assert.assertEquals(job,"Pilot");



    }

}
