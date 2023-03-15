package Tests;

import TestData.TestDataHerokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Post_Deserialization extends BaseUrlHerokuapp {
    /*
            https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
        gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
        Response Body // expected data
        {
        "bookingid": 24,
        "booking": {
             "firstname": "Ahmet",
             "lastname": "Bulut",
             "totalprice": 500,
             "depositpaid": false,
              "bookingdates": {
                 "checkin": "2021-06-01",
                 "checkout": "2021-06-10"
              },
        "additionalneeds": "wi-fi"
          }
        }
        Request body
        {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
         },
        "additionalneeds" : "wi-fi"
        }
     */
    @Test
    public void test01() {

        //1- End point ve request body olustur
        specHerokuapp.pathParam("pp1", "booking");
        Map<String, Object> requestBodyMap = TestDataHerokuapp.requestBodyMapOlustur();
        //2- Expected data olustur
        Map<String, Object> expectedData = TestDataHerokuapp.responseBodyMapOlustur();

        //3- Request gonder ve donen response'i kaydet
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBodyMap)
                .post("/{pp1}");


        //4-Assertion
        Map<String, Object> responseMap = response.as(HashMap.class);

        assertEquals(((Map) expectedData.get("booking")).get("firstname"), ((Map) responseMap.get("booking")).get("firstname"));
        assertEquals(((Map) expectedData.get("booking")).get("lastname"), ((Map) responseMap.get("booking")).get("lastname"));
        assertEquals(((Map) expectedData.get("booking")).get("totalprice"), ((Map) responseMap.get("booking")).get("totalprice"));
        assertEquals(((Map) expectedData.get("booking")).get("depositpaid"), ((Map) responseMap.get("booking")).get("depositpaid"));
        assertEquals(((Map) expectedData.get("booking")).get("additionalneeds"), ((Map) responseMap.get("booking")).get("additionalneeds"));
        assertEquals(((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkin"),
                ((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkout"),
                ((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkout"));


    }
}
