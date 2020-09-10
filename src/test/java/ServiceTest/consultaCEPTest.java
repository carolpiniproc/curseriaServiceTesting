package ServiceTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class consultaCEPTest {
    String url = "http://viacep.com.br/ws/";

    @Test
    public void consultaCEPParams(){
       //http://viacep.com.br/ws/{{cep}}/json/
        String cep = "13087500";
        String endpoint = cep.concat("/json/");
        LinkedHashMap<String, String> param = new LinkedHashMap<>();

        RestAssured.baseURI = url;

        Response response = (Response) RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .params(param)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.getBody().jsonPath();

        assertEquals("Rua Hermantino Coelho", json.get("logradouro"));
    }

    @Test
    public void consultaCEPHeaders(){
        //http://viacep.com.br/ws/{{cep}}/json/
        String cep = "13087500";
        String endpoint = cep.concat("/json/");
        LinkedHashMap<String, String> header = new LinkedHashMap<>();
        header.put("clientId", "curso");
        header.put("Authorization", "Basic");

        RestAssured.baseURI = url;

        Response response = (Response) RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .headers(header)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.getBody().jsonPath();

        assertEquals("Rua Hermantino Coelho", json.get("logradouro"));
    }





}

