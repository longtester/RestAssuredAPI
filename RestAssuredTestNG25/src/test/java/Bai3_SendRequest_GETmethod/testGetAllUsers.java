package Bai3_SendRequest_GETmethod;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testGetAllUsers {
    @Test
    public void testGetAllUsers() {
        //Khai báo đối tượng request để thiết lập điều kiện đầu vào
        //Dùng given() chỉ thị sự thiết lập sẵn điều kiện
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .basePath("/users")
                //.header("accept", "application/json")
                .accept("application/json");

        //Khai báo đối tượng response để nhận giá trị trả về từ hàm when() làm gì đó
        //Cụ thể thì chúng ta dùng phương thức GET với hàm get() một endpoint
        Response response = request.when().get();

        //In ra giá trị của response nhận về
        //prettyPrint() là in với nội dung body đã format đẹp mắt
        response.prettyPrint();

    }
}
