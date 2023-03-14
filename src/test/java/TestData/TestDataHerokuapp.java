package TestData;

import org.json.JSONObject;

public class TestDataHerokuapp {

    public static JSONObject jsonRequestBodyOlustur() {
        /*
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

        JSONObject requestBody = new JSONObject();
        JSONObject bookingdatesBody = new JSONObject();

        bookingdatesBody.put("checkin", "2021-06-01");
        bookingdatesBody.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", bookingdatesBody);
        requestBody.put("additionalneeds", "wi-fi");

        return requestBody;


    }

    public static JSONObject jsonResponseBodyOlustur() {

        JSONObject responseBody = new JSONObject();
        JSONObject bookingBody = jsonRequestBodyOlustur();

        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);
        return responseBody;

    }


}
