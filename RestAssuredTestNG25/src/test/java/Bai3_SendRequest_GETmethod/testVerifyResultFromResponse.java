package Bai3_SendRequest_GETmethod;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class testVerifyResultFromResponse {
    @Test
    public void testVerifyResultFromResponse() {
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json");

        request.queryParam("username", "anhtester");

        Response response = request.when().get("/user");
        response.prettyPrint();

        //Verify kết quả từ response với hàm then()
        response.then().statusCode(200);
        response.then().contentType("application/json");
        //Đối với body thì cần điền cấu trúc theo xpath từ json
        //Hàm equalTo thuộc thư viện org.hamcrest.Matchers
        response.then().body("response.username", equalTo("anhtester"));
        response.then().body("response.id", equalTo(1315));
    }
}
