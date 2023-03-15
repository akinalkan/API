package Tests;

import Pojos.PojoDummyExampleData;
import Pojos.PojoDummyExampleResponse;
import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C33_Get_Pojo extends BaseUrlDummyExample {
    /*
       http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
   gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
   Response Body
   expected data
   {
   "status": "success",
   "data": {
           "id": 3,
           "employee_name": "Ashton Cox",
           "employee_salary": 86000,
           "employee_age": 66,
           "profile_image": ""
          },
   "message": "Successfully! Record has been fetched."
   }
        */
    @Test
    public void test01() {
        //1-End point ve request body olustur
        specDummyExample.pathParams("pp1", "employee", "pp2", 3);

        //2-Expected body olustur
        PojoDummyExampleData dataPojo = new PojoDummyExampleData(3,
                "Ashton Cox", 86000, 66, "");
        PojoDummyExampleResponse expectedResponseBody = new PojoDummyExampleResponse("success",
                dataPojo, "Successfully! Record has been fetched.");

        //3- Request gonder, donen response'i kaydet
        Response response = given().spec(specDummyExample)
                .when()
                .get("{pp1}/{pp2}");


        /*
        Pojos.PojoDummyExampleResponse@5c9ac4cc[
                 status=success,
                 data=Pojos.PojoDummyExampleData@4df39a88[
                            id=3,
                            employeeName=Ashton Cox,
                            employeeSalary=86000,
                            employeeAge=66,
                            profileImage=],
                 message=Successfully! Record has been fetched.]
         */

        //4-Assertion
        JsonPath responseJsonPath=response.jsonPath();
        assertEquals(expectedResponseBody.getMessage(),responseJsonPath.getString("message"));
        assertEquals(expectedResponseBody.getStatus(),responseJsonPath.getString("status"));
        assertEquals(expectedResponseBody.getData().getId(),responseJsonPath.get("data.id"));
        assertEquals(expectedResponseBody.getData().getEmployeeName(),responseJsonPath.getString("data.employee_name"));
       // assertEquals(expectedResponseBody.getData().getEmployeeAge(),responseJsonPath.getString("data.employee_age"));
        //assertEquals(expectedResponseBody.getData().getEmployeeSalary(),responseJsonPath.getString("data.employee_salary"));
        assertEquals(expectedResponseBody.getData().getProfileImage(),responseJsonPath.getString("data.profile_image"));




    }
}
