package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {
    @Test
    public void test01() {
        /*
        https://restful-booker.herokuapp.com/booking endpointine
        gerekli Query parametrelerini yazarak
         “firstname” degeri “Sally”
         ve “lastname” degeri “Ericsson” olan
         rezervasyon oldugunu test edecek bir
          GET request gonderdigimizde, donen response’un status
        code’unun 200 oldugunu
        ve “Jim Jackson” ismine sahip en az bir booking oldugunu test
        edin
         */

        //1- end point ve request body olustur
        specHerokuapp.pathParam("pp1", "booking")
                .queryParams("firstname", "Sally", "lastname", "Ericsson");
        //2- expected data olustur
        //3- request gonder ve donen response'i kaydet
        Response response = given().spec(specHerokuapp)
                .when()
                .get("/{pp1}");
        response.prettyPrint();
        //4-Assertion

        response.then().assertThat().statusCode(200).body("booking", Matchers.hasSize(1));
    }
}
