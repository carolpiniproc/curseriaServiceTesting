package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.LinkedHashMap;

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

    public static Response getResponse() {
        return response;
    }

    public static void setResponse(Response response) {
        RestUtils.response = response;
    }

    public static RequestSpecification initRequest(ContentType contentType){
        return RestAssured.given()
                .relaxedHTTPSValidation() //SSL para sites com certificado não válido
                .contentType(contentType);
        //.proxy(host, port) - caso a empresa trabalhe com proxy, ele seria colocado aqui
    }

    public static void get(String endpoint){
        Response response = initRequest(ContentType.JSON)
                .when().get(endpoint)
                .then()
                .extract().response();
        setResponse(response);
    }

    public static int getStatusCode(){
        return getResponse().statusCode();
    }

    public static void get(String endpoint, LinkedHashMap<String,String> header){
        Response response = RestUtils.initRequest(ContentType.JSON)
                .headers(header)
                .when().get(endpoint)
                .then()
                .extract().response();
        setResponse(response);
    }

    public static void getParams(String endpoint, LinkedHashMap<String, String> param){
        Response response = RestUtils.initRequest(ContentType.JSON)
//                .param("clientId", "curso") --- pode usar assim ou o map
//                .param("nome", "Carol") --- pode usar assim ou o map
                .params(param)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
        setResponse(response);
    }

    public static Object getValue(String key){
        JsonPath json = getResponse().getBody().jsonPath();
        return json.get(key);
    }

    public static RequestSpecification initRequest(ContentType contentType, LinkedHashMap<String, String> header){
        return RestAssured.given()
                .relaxedHTTPSValidation() //SSL para sites com certificado não válido
                .contentType(contentType)
                .headers(header);
    }

}
