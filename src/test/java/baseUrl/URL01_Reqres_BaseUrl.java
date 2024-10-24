package baseUrl;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class URL01_Reqres_BaseUrl {

    public static RequestSpecification spec1;

    @Before
    public static void setup_Url01_Reqres(){

        spec1=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("https://reqres.in/api").build();




    }
}
