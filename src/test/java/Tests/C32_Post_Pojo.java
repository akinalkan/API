package Tests;

import Pojos.PojoHerokuappBookingdates;
import Pojos.PojoHerokuappRequestBody;
import Pojos.PojoHerokuappResponseBody;
import Pojos.PojoJsonPlaceholder;
import TestData.TestDataHerokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C32_Post_Pojo extends BaseUrlHerokuapp {
    /*
         https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir
          POST request  gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
     Response Body // expected data
   {
         bookingid": 24,
         booking": {
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
        PojoHerokuappBookingdates bookingdatesPojo = new PojoHerokuappBookingdates("2021-06-01", "2021-06-10");
        PojoHerokuappRequestBody requestBodyPojo = new PojoHerokuappRequestBody("Ahmet",
                "Bulut", 500, false, bookingdatesPojo, "wi-fi");

        //2- Expected data olustur
        bookingdatesPojo = new PojoHerokuappBookingdates("2021-06-01", "2021-06-10");

        PojoHerokuappRequestBody bookingPojo = new PojoHerokuappRequestBody("Ahmet",
                "Bulut", 500, false, bookingdatesPojo, "wi-fi");
        PojoHerokuappResponseBody expectedResponseBody = new PojoHerokuappResponseBody(24, bookingPojo);

        //3- Request gonder ve donen response'i kaydet
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .post("{pp1}");

        PojoHerokuappResponseBody responsePojo = response.as(PojoHerokuappResponseBody.class);

        //4-Assertion
        assertEquals(expectedResponseBody.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());
        assertEquals(expectedResponseBody.getBooking().getLastname(),responsePojo.getBooking().getLastname());
        assertEquals(expectedResponseBody.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());
        assertEquals(expectedResponseBody.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());
        assertEquals(expectedResponseBody.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());
        assertEquals(expectedResponseBody.getBooking().getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedResponseBody.getBooking().getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());



    }
}
