import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import requestBodies.Students;

import static io.restassured.RestAssured.*;



public class UpdateReq {
    @Test
    public void putReq(){

        JSONObject jo=new JSONObject();
        jo.put("firstName","Sun");
        jo.put("lastName","Raj");

        Response response = given()
                .header("Content-Type", ContentType.JSON)
                .log()
                .all()
                .body(jo.toString())
                .put("http://localhost:3000/students/123");

        Students students = response.as(Students.class);
        Assert.assertEquals(response.as(Students.class).getId(),123);
        response.then().body(JsonSchemaValidator.);
        Assertions.assertThat(response.as(Students.class).getId()).isEqualTo(12);

    }

}
