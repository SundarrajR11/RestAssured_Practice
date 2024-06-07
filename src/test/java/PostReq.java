
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static io.restassured.RestAssured.*;

public class PostReq {
    @Test
    public void postReq1(){
        // 1. Approach Passing json body as String --Not Recommended

        String reqBody="{\n" +
                "    \"id\": \"e816\",\n" +
                "    \"first_name\": \"sundar\",\n" +
                "    \"last_name\": \"rat\",\n" +
                "    \"email\": \"sdsa@s.com\",\n" +
                "    \"isPassed\": false,\n" +
                "    \"marks\": [\n" +
                "        93,\n" +
                "        94,\n" +
                "        98,\n" +
                "        99,\n" +
                "        87\n" +
                "    ]\n" +
                "}";
        String replacedBody = reqBody.replace("e816", "123");
        Response response=given()
                .body(replacedBody)
                .log()
                .all()
                .post("http://localhost:3000/students");

        System.out.println("response = " + response.statusCode());
        System.out.println("response.asPrettyString() = " + response.asPrettyString());
    }


    @Test
    public void postReq2(){

        //Approach-2 : Passing Data from an external file
        //1.Can't get the request content from the file and print it on the console.
        //2.Use only for static data.

        File f=new File("C:\\Users\\ragus\\IdeaProjects\\RestAssured_Practice\\src\\main\\resources\\sampleReqBody.json");

        Response response=given()
                .header("Content-Type",ContentType.JSON)
                .body(f)
                .log()
                .all()
                .post("http://localhost:3000/students");

        System.out.println("response = " + response.statusCode());
        response.prettyPrint();
    }

    @Test
    public void postReq3() throws IOException {
        /*
        * Pass data from an external file and convert into String and the use it.
        * i)   So, we can now print the request data on the console.
        * ii)  Change few parameters in the request
        * iii) Not suitable for request having lost of dynamic parameters.
        * */

        byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\ragus\\IdeaProjects\\RestAssured_Practice\\src\\main\\resources\\sampleReqBody.json"));
        String reqBody = new String(bytes);
        Faker fakerInstance= new Faker();
        String replaceReqBody = reqBody.replace("fname", fakerInstance.name().firstName())
                .replace("lname",fakerInstance.name().firstName())
                .replace("emailAdd",fakerInstance.internet().emailAddress())
                .replace("un",String.valueOf(fakerInstance.random().nextInt(10 ,1000)))
                .replace(String
                        .valueOf(true), String.valueOf(new Faker().bool().bool()));

        Response response=given()
                                .body(replaceReqBody)
                                .log()
                                .all()
                                .post("http://localhost:3000/students");

        System.out.println("response = " + response.statusCode());
        System.out.println("response.asPrettyString() = " + response.asPrettyString());
    }


    @Test
    public void postReq4() throws JsonProcessingException {
        /*
        * Using Map and List from Java
        * {} -> Map
        * []-> List
        *
        {
        "id": "un",
        "first_name": "fname",
        "last_name": "lname",
        "email": "emailAdd",
        "isPassed": true,
        *"marks":[95,87,98,99,100]
         }
        * */
        Map<String, Object> lm = new LinkedHashMap<>();
        lm.put("id", new Faker().number().numberBetween(100,1000));
        lm.put("first_name",new Faker().name().firstName());
        lm.put("last_name",new Faker().name().lastName());
        lm.put("email",new Faker().internet().emailAddress());
        lm.put("isPassed",true);
        List<Integer> listOfMarks = Arrays.asList(95, 87, 98, 99, 100);
        lm.put("marks",listOfMarks);

        /*Serialization -Converts Code language into bye streams-->json
         * De-Serialization - json -> byte streams to coded language back
         * Add Jackson databind library or gson
         * */
        Response response=given()
                .header("Content-Type",ContentType.JSON)
                .body(lm)
                .log()
                .all()
                .post("http://localhost:3000/students");

        System.out.println("response = " + response.statusCode());
        response.prettyPrint();
    }
    @Test
    public void postReq5(){
        /*
        * {
        "id": "un",
        "first_name": "fname",
        "last_name": "lname",
        "email": "emailAdd",
        "isPassed": true,
        *"marks":[95,87,98,99,100]
         }*/
        JSONObject jo = new JSONObject();
        jo.put("id",new Faker().number().numberBetween(100,1000));
        jo.put("first_name",new Faker().name().firstName());
        jo.put("last_name",new Faker().name().lastName());
        jo.put("email",new Faker().internet().emailAddress());
        jo.put("isPassed",new Faker().bool().bool());
        JSONArray ja = new JSONArray();
        ja.put(new Faker().number().numberBetween(50,100));
        ja.put(new Faker().number().numberBetween(50,100));
        ja.put(new Faker().number().numberBetween(50,100));
        ja.put(new Faker().number().numberBetween(50,100));
        ja.put(new Faker().number().numberBetween(50,100));
        jo.put("marks",ja);

        Response response=given()
                .header("Content-Type",ContentType.JSON)
                .body(jo.toString()) // use toString() or toMap()
                .log()
                .all()
                .post("http://localhost:3000/students");

        System.out.println("response = " + response.statusCode());
        response.prettyPrint();
    }
}
