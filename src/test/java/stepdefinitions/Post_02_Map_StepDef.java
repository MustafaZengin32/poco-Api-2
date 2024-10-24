package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.URL_02_JsonPlaceHolder_BaseUrl.spec2;
import static io.restassured.RestAssured.given;

public class Post_02_Map_StepDef {

    Response response;

    Map<String,Object> expectedData;

    @Given("kullanici jsonplaceholder.typicode.com {string} sitesine gider")
    public void kullaniciJsonplaceholderTypicodeComSitesineGider(String arg0) {

        spec2.pathParam("a","todos");
    }

    @And("jsonplaceholder sitesinde post islemi yapar")
    public void jsonplaceholderSitesindePostIslemiYapar() {

        /*
         {
    "userId": 1,
    "id": 1,
    "title": "pilot",
    "completed": true
  }
         */

        //serialization
        expectedData=new HashMap<>();

        expectedData.put("userId",75);
        expectedData.put("title","pilot");
        expectedData.put("completed",true);

        response = given(spec2).body(expectedData).post("{a}");

        response.prettyPrint();
    }

    @Then("jsonplaceholder sitesinden gelen response dogrulanir")
    public void jsonplaceholderSitesindenGelenResponseDogrulanir() {

        //deserialization

        Map<String,Object>actualData=response.as(HashMap.class);

        response.then()
                .statusCode(201);

        Assert.assertEquals("pilot",actualData.get("title").toString());


    }
}
