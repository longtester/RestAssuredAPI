package Bai2_RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {
    @Test
    public void testApi01(){
        // Thiết lập cơ sở URL của API
        RestAssured.baseURI = "https://api.anhtester.com/api";

        // Thiết lập câấu trúc đầu vào: EndPoint, Params, Header, Body
        RequestSpecification request = given();
        request.basePath("/books"); // EndPoint
        request.header("Accept", "application/json");

        // Gửi GET request và lưu kết quả vào response
        Response response = request.get();

        // In kết quả từ response dưới dạng JSON đã format
        response.prettyPrint();

        // Verify từng giá trị trong response
        response.then().statusCode(200);
        response.then().statusLine("HTTP/1.1 200 OK");
        response.then().contentType(ContentType.JSON);
        //Verify data từ body dạng JSON
        response.then().body("response[0].name", equalTo("To Sail Beyond the Sunset"));
        response.then().body("response[0].price", equalTo(10000));
    }
}
