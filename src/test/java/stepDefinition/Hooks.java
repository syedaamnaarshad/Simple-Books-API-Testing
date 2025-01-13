package stepDefinition;

import baseService.BaseService;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import utils.ConfigUtil;

import java.util.Properties;

public class Hooks {

    public static Properties myProp = ConfigUtil.getConfig("config");


    @Before
    public void setup() {
        //Test Setup
        RestAssured.baseURI= myProp.getProperty("baseURI"); //Setup Base URI
         BaseService.setContentType(ContentType.JSON);//Setup Content Type
    }
}
