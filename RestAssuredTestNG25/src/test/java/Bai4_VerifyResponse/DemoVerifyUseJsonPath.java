package Bai4_VerifyResponse;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.impl.execchain.RequestAbortedException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoVerifyUseJsonPath {
    @Test
    public void testVerifyResponseUseAssertTestNG(){
        RequestSpecification request = given();
        request.baseUri("https://api.anhtester.com/api")
                .accept("application/json");
        int id = 363; // ID của book. Gắn vào sau path url luôn

        Response response = request.when().get("/book/" + id);
        response.prettyPrint();

        //Verify kết quả từ response với Assert trong testNG
        //Dùng class Assert chấm gọi 2 hàm chính là assertEquals và assertTrue
        Assert.assertEquals(response.getStatusCode(),200,"Status Code chưa đúng.");
        Assert.assertEquals(response.getContentType(),"application/json","Content type chưa đúng.");

        //Muốn lấy giá trị từng key trong JSON body để compare chính xác thì dùng JsonPath
        JsonPath jsonPath = response.jsonPath(); // Lưu hêết body vào đối tượng jsonPath

        //Truy xuất giá trị theo key hoặc đường dẫn path theo cấp bậc
        String name = jsonPath.get("response.name");
        System.out.println("Name: " +name);
        Assert.assertTrue(name.contains("validname65496"),"Name không tồn tại.");

        //Khi lấy trực tiếp giá trị từ jsonPath thì cần toString
        //và phải chuyển số về dạng chuỗi để so sánh
        Assert.assertEquals(jsonPath.get("response.price").toString(),"3000","Price không đuúng.");

        //Lấy đường dẫn path thứ 2 trong mảng của object "image"
        //Index bắt đầu từ 0
        String imagePath2 = jsonPath.get("response.image[0].path");
        System.out.println(imagePath2);
        Assert.assertTrue(imagePath2.contains("public/images/"), "Không đúng hình ảnh thứ 2.");

    }

}
