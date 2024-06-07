
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import requestBodies.Addresses;
import requestBodies.Students;

import java.util.Arrays;

import static io.restassured.RestAssured.*;
public class PostRequestPojo {

    /*
    * POJO - Plain Old Java Object*/
    @Test
    public void postRequestPojo(){

        Addresses a1 = new Addresses();
        Addresses a2 = new Addresses();

        Students reqBody = new Students();


        Response response = given()
                .header("Content-Type", ContentType.JSON)
                .log()
                .all()
                .body(reqBody)
                .post("http://localhost:3000/students");

        response.prettyPrint();

    }
}
