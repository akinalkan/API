package Tests;

import Pojos.PojoJsonPlaceholder;
import TestData.TestDataHerokuapp;
import TestData.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C31_Put_PojoClass extends BaseUrlJsonPlaceholder {
    /*
   https://jsonplaceholder.typicode.com/posts/70 url'ine
   asagidaki body’e sahip bir PUT request yolladigimizda donen response’in
     status kodunun 200,
     content type’inin “application/json; charset=utf-8”,
      Connection header degerinin “keep-alive”
       response body’sinin asagida verilen ile ayni oldugunu test ediniz
   POJO CLASS ILE EXPECTED DATA TESTI
   Expected Data :
             {
             "title": "Ahmet",
             "body": "Merhaba",
             "userId": 10,
             "id": 70
             }
   Request Body
          {
          "title": "Ahmet",
          "body": "Merhaba",
          "userId": 10,
          "id": 70
          }
        */
    @Test
    public void test01() {
        //1- End point ve request body olustur
        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", "70");
        PojoJsonPlaceholder requestBodyPojo = new PojoJsonPlaceholder("Ahmet", "Merhaba", 10, 70);
        //2- Expected data olustur
        PojoJsonPlaceholder expectedData = new PojoJsonPlaceholder("Ahmet", "Merhaba", 10, 70);
        //3- Request gonder ve donen response'i kaydet
        Response response = given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .put("{pp1}/{pp2}");
         PojoJsonPlaceholder responsePojo=response.as(PojoJsonPlaceholder.class);
        //4-Assertion
        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceholder.headerConnection,response.header("Connection"));

        assertEquals(expectedData.getTitle(),responsePojo.getTitle());
        assertEquals(expectedData.getUserId(),requestBodyPojo.getUserId());
        assertEquals(expectedData.getBody(),requestBodyPojo.getBody());
        assertEquals(expectedData.getId(),requestBodyPojo.getId());



    }


}
