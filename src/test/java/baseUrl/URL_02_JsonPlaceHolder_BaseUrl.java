package baseUrl;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class URL_02_JsonPlaceHolder_BaseUrl {

    public static RequestSpecification spec2;

    @Before
    public static void setup_Url02_Json(){

        spec2=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("https://jsonplaceholder.typicode.com/").build();

    }
}
