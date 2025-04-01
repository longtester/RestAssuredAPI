package Bai3_SendRequest_GETmethod;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import org.testng.annotations.Test;

public class testUserByUserName {
    @Test
    public void testGetUserByUserName() {
        //Khai báo đối tượng request để thiết lập điều kiện đầu vào
        //Dùng given() chỉ thị sự thiết lập sẵn điều kiện
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .basePath("/user")
                .accept("application/json");

        //Khai báo tham số đầu vào với hàm queryParam
        request.queryParam("username", "anhtester");

        //Khai báo đối tượng response để nhận giá trị trả về từ hàm when() làm gì đó
        //Cụ thể thì chúng ta dùng phương thức GET với hàm get() một endpoint
        Response response = request.when().get();

        //In ra giá trị của response nhận về
        //prettyPrint() là in với nội dung body đã format đẹp mắt
        response.prettyPrint();
    }
}
