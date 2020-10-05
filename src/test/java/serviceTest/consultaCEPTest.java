package serviceTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class consultaCEPTest {
    //http://viacep.com.br/ws/{{cep}}/json/
    String url = "http://viacep.com.br/ws/";

    @Test
    public void validaStatusCode() {
        String cep = "13087500";
        String endpoint = cep.concat("/json/"); // ou pode usar endpoint = cep+"/json/";

        RestAssured.baseURI = url;

        Response response = get(endpoint);
        assertEquals(200, response.statusCode());
    }

    @Test
    public void validaDadosCEPHeaders(){
        String cep = "13087500";
        String endpoint = cep.concat("/json/");
        LinkedHashMap<String, String> header = new LinkedHashMap<>();
        header.put("clientId", "curso");
        header.put("Authorization", "Basic Y2Fyb2w6dGVzdGU=");

        RestAssured.baseURI = url;

        Response response = initRequest(ContentType.JSON)
                .headers(header)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.getBody().jsonPath();

        assertEquals("Mansões Santo Antônio", json.get("bairro"));
        assertEquals("Rua Hermantino Coelho", json.get("logradouro"));
        assertEquals("Campinas", json.get("localidade"));
    }


    @Test
    public void validaDadosCEPParam(){
        String cep = "13087500";
        String endpoint = cep.concat("/json/"); // ou pode usar endpoint = cep+"/json/";
        LinkedHashMap<String, String> param = new LinkedHashMap<>();
        param.put("clientId", "curso");
        param.put("nome", "Carol");

        RestAssured.baseURI = url;

        Response response = initRequest(ContentType.JSON)
//                .param(parameterName, parameterValue)
//                .param("clientId", "curso")
//                .param("nome", "Carol")
                .params(param)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath json = response.getBody().jsonPath();

        assertEquals("Mansões Santo Antônio", json.get("bairro"));
        assertEquals("Rua Hermantino Coelho", json.get("logradouro"));
        assertEquals("Campinas", json.get("localidade"));
    }

    public RequestSpecification initRequest(ContentType contentType){
        return RestAssured.given()
                .relaxedHTTPSValidation() //SSL para sites com certificado não válido
                .contentType(contentType);
                //.proxy(host, port) - caso a empresa trabalhe com proxy, ele seria colocado aqui
    }

    public Response get(String endpoint){
       return initRequest(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

}

