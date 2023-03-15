package TestData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
        requestBody.put("totalprice", 500.0);
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
    public static Map<String, Object> requestBodyMapOlustur() {
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
        Map<String, Object> requestBodyMapOlustur = new HashMap<>();


        requestBodyMapOlustur.put("firstname", "Ahmet");
        requestBodyMapOlustur.put("lastname", "Bulut");
        requestBodyMapOlustur.put("totalprice", 500.0);
        requestBodyMapOlustur.put("depositpaid", false);
        requestBodyMapOlustur.put("bookingdates",bookingDatesMapOlustur());
        requestBodyMapOlustur.put("additionalneeds", "wi-fi");

        return requestBodyMapOlustur;

    }
    public static Map<String,String> bookingDatesMapOlustur(){
        Map<String, String> bookingdatesMap = new HashMap<>();

        bookingdatesMap.put("checkin", "2021-06-01");
        bookingdatesMap.put("checkout", "2021-06-10");
        return bookingdatesMap;
    }
    /*
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
     */
    public static Map<String,Object> responseBodyMapOlustur(){
        Map<String,Object> responseBodyMap=new HashMap<>();
        responseBodyMap.put("bookingid",24);
        responseBodyMap.put("booking",requestBodyMapOlustur());
      return responseBodyMap;

    }


}
