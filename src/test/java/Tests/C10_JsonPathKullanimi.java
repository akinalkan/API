package Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {
    /*
    {
    "firstName":"John",
    "lastName":"Doe",
    "address":{
        "streetAddress":"naist street",
        "city":"Nara",
        "postalCode":"630-0192"
              },
    "age":26,
    "phoneNumbers":[
            {"number":"0123-4567-8888",
            "type":"iphone"  },
             {"number":"0123-4567-8910",
              "type":"home" }
                ]
     }
     */
    @Test
    public  void method01(){
        JSONObject kisiBilgileriJsonObj= new JSONObject();

        JSONObject adresBilgileriJsonObj= new JSONObject();

        JSONArray telefonBilgileriArr=new JSONArray();
        JSONObject cepTelefonuJsonObj=new JSONObject();
        JSONObject evTelefonuJsonObj=new JSONObject();

        adresBilgileriJsonObj.put("streetAddress","naist street");
        adresBilgileriJsonObj.put("city","Nara");
        adresBilgileriJsonObj.put("postalCode","630-0192");

        cepTelefonuJsonObj.put("type","iphone");
        cepTelefonuJsonObj.put("number","0123-4567-8888");
        evTelefonuJsonObj.put("type","home");
        evTelefonuJsonObj.put("number","0123-4567-8910");
        telefonBilgileriArr.put(cepTelefonuJsonObj);
        telefonBilgileriArr.put(evTelefonuJsonObj);

        kisiBilgileriJsonObj.put("firstName","John");
        kisiBilgileriJsonObj.put("lastName","Doe");
        kisiBilgileriJsonObj.put("age",26);
        kisiBilgileriJsonObj.put("address",adresBilgileriJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriArr);

        System.out.println("kisiBilgileri = " + kisiBilgileriJsonObj);

        System.out.println("firstName : " + kisiBilgileriJsonObj.get("firstName"));
        System.out.println("lastName : " + kisiBilgileriJsonObj.get("lastName"));

        System.out.println("cadde : "+kisiBilgileriJsonObj.getJSONObject("address")
                                      .get("streetAddress"));

        System.out.println("city : "+kisiBilgileriJsonObj.getJSONObject("address").get("city"));

        System.out.println("cep tel no : "+kisiBilgileriJsonObj
                .getJSONArray("phoneNumbers")
                .getJSONObject(0).get("number"));
    }
}
