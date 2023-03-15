package Tests;

import TestData.TestDataHerokuapp;
import TestData.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Put_DeSerialization extends BaseUrlJsonPlaceholder {
    /*
       https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip
       bir PUT request yolladigimizda donen response’in response body’sinin asagida verilen ile ayni
       oldugunu test ediniz
       DE-SERIALIZATION ILE EXPECTED DATA TESTI
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

        //1- endpoint ve request body olustur
        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", 70);

        Map<String,Object> requestBodyMap= TestDataJsonPlaceholder.bodyOlusturMap();

        //2- Expected data olustur
        Map<String,Object> expectedDataMap=TestDataJsonPlaceholder.bodyOlusturMap();

        //3-request gonder ve donen response'i kaydet
        Response response=given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                             .when().body(requestBodyMap)
                             .put("/{pp1}/{pp2}");

        //4- Assertion
        Map<String,Object> responseMap=response.as(HashMap.class);

        assertEquals(expectedDataMap.get("title"),responseMap.get("title"));
        assertEquals(expectedDataMap.get("body"),responseMap.get("body"));
        assertEquals(expectedDataMap.get("userId"),responseMap.get("userId"));
        assertEquals(expectedDataMap.get("id"),responseMap.get("id"));

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());






    }


}
