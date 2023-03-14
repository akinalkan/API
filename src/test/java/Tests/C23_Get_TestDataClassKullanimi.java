package Tests;

import TestData.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholder {
    @Test
    public void test01() {
        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda donen
        response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunu test
        ediniz
        Response body :
     {
        "userId": 3,
        "id": 22,
        "title": "dolor sint quo a velit explicabo quia nam",
        "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
        um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
         */

        //1- end point ve request body olustur
        specJsonPlaceholder.pathParams("pp1", "posts", "pp2", "22");

        //2- expected data olustur
        JSONObject expectedData = TestDataJsonPlaceholder.responseBodyOlustur22();


        //3- request gonder ve donen response'i kaydet
        Response response = given().spec(specJsonPlaceholder)
                .when()
                .get("/{pp1}/{pp2}");

        JsonPath responseJsonPath=response.jsonPath();

        //4-Assertion
        Assert.assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));







    }
}
