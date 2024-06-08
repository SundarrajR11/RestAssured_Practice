import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetReq {

    @Test
    public void getSample(){
        Response response = given().get("http://localhost:3000/students");
        response.prettyPrint();
        System.out.println("response = " + response.asPrettyString());
    }
}
