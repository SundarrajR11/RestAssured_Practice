
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import requestBodies.Addresses;
import requestBodies.Students;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
public class PostRequestPojo {
    /*
    * POJO - Plain Old Java Object*/

    // When we need use All args constructor and setter methods?
    /*
    * When the requirement is set values needs to immutable or unchangeable once set.-->All args constructor
    * unchangeable/changeable is not possible in  ->All args constructor
    * When the requirement is set values needs to immutable/immutable or
    * unchangeable/changeable for both cases.-->Setter Methods
    * */
    @Test
    // Approach 1 - POJO With All args constructor
    public void postRequestPojoUsingAllArgsConstructors(){
        /*
        * Different between List and Arrays.asList, List.of
        * List -> Add and removal possible
        * Arrays.asList()/List.of() ->size fixed and addition and removal not possible
        * Refer ArraysListDemo class*/

       Students reqBody=new Students(12,
               "sun",
               "leo",
               "de@c.o",
               false,
               List.of(12,3,2,3,2),
               Arrays.asList(
                       new Addresses(12,"app"),
                       new Addresses(23,"ammo")
               ));


        Response response = given()
                .header("Content-Type", ContentType.JSON)
                .log()
                .all()
                .body(reqBody)
                .post("http://localhost:3000/students");
        response.prettyPrint();

    }
    @Test
    //Approach -2 : POJO With setter methods
    public void postRequestPojoUsingSetMethods(){

        Addresses a1 = new Addresses();
        a1.setBlock(198);
        a1.setStreet("appa");
        Addresses a2 = new Addresses();
        a2.setBlock(198);
        a2.setStreet("amma");

        Students reqBody = new Students();
        reqBody.setId(122);
        reqBody.setFirstName("sun");
        reqBody.setLastName("raj");
        reqBody.setEmail("sun@co.ref");
        reqBody.setPassed(true);
        reqBody.setMarks(Arrays.asList(1,2,3,4,6));
        reqBody.setAddresses(List.of(a1,a2));

        Response response = given()
                .header("Content-Type", ContentType.JSON)
                .log()
                .all()
                .body(reqBody)
                .post("http://localhost:3000/students");

        response.prettyPrint();

    }
}
