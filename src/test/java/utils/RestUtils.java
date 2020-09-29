package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtils {
    public static String url;
    public static Response response;

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        RestUtils.url = url;
        RestAssured.baseURI = url;
    }
//
//    public static ResquestSpecification(){
//        return ;
//    }
//
//    public static void get(String endpoint) {
//        Response response = initRequest(ContentType.JSON)
//            .when().get(endpoint)
//            .then()
//            .extract().response();
//            setResponse(response);
  //  }
//
//    public static void getParams(String endpoint, LinkedHashMap<String, String> param){
//        Response response = RestUtils.initRequest(ContentType.JSON)
//            .params(param)
//            .when()
//            .get(endpoint)
//            .then()
//            .extract().response();
//        setResponse(response);
//    }
//
//    public  static Object getValue(String key){
//        JsonPath json = getResponse().getBody.jsonPath();
//        return json.get();
//    }


}
