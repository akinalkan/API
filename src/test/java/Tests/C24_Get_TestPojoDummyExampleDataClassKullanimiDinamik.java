package Tests;

import TestData.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Get_TestPojoDummyExampleDataClassKullanimiDinamik extends BaseUrlJsonPlaceholder {
    @Test
    public void test01() {
        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen
        response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
        ediniz
        Response body :
        {
        "userId": 4,
        "id": 40,
        "title": "enim quo cumque",
        "body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia
        quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
      }
         */

        //1- end point ve request body olustur

        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", "40");
        //2- expected data olustur
        JSONObject expectedData=TestDataJsonPlaceholder.JsonBodyOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\n" +
                "ipsum rem optio mollitia quas\n" +
                "voluptatem eum voluptas qui\n" +
                "unde omnis voluptatem iure quasi maxime voluptas nam");


        //3- request gonder ve donen response'i kaydet
        Response response=given().spec(specJsonPlaceholder)
                             .when()
                             .get("/{pp1}/{pp2}");

        //4-Assertion
        JsonPath responseJsonPath=response.jsonPath();


        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        assertEquals(expectedData.get("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));





    }
}
