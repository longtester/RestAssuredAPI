package Bai3_SendRequest_GETmethod;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoSendRequestGET {
    @Test
    public void testGivenWhenThen(){
        given().baseUri("https://api.anhtester.com/api")
                .accept("application/json")
                .when().get("users")
                .then().statusCode(200);
    }
}
