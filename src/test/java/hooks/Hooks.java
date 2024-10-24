package hooks;

import io.cucumber.java.Before;

import static baseUrl.URL01_Reqres_BaseUrl.setup_Url01_Reqres;
import static baseUrl.URL_02_JsonPlaceHolder_BaseUrl.setup_Url02_Json;

public class Hooks {

    @Before
    public void before() {
        //setup_Url01_Reqres();
        setup_Url02_Json();
        // setupHerokuapp();
        // setUpFaker();
        // setupGorest();
        // setupPetStore();
        // setupHerokuapp_Authentication();
        // setupHerokuapp_XML();
        // setupPetStore_XML();
        // setupPetStore_XML_Post_Jsoup();

    }
}
