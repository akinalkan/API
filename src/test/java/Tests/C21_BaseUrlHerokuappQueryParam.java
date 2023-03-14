package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {
    @Test
    public void test01() {
        /*
        https://restful-booker.herokuapp.com/booking endpointine
        gerekli Query parametrelerini yazarak
          “firstname” degeri “Eric” olan rezervasyon oldugunu
           test edecek bir GET request gonderdigimizde,
            donen response’un
            status code’unun 200 oldugunu
             ve “Mark” ismine sahip  3 booking oldugunu test edin
         */

        //1- end point ve request body olustur
        specHerokuapp.pathParam("pp1", "booking").queryParam("firstname", "Mark");
        //2- expected data olustur
        //3- request gonder ve donen response'i kaydet

        Response response = given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");
        response.prettyPrint();
        //4-Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", hasSize(1));
    }
}
