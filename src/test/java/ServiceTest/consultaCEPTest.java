package ServiceTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class consultaCEPTest {

    String url = "http://viacep.com.br/ws/";

    @Test
    public void consultaCEP(){
       //http://viacep.com.br/ws/{{cep}}/json/
        String cep = "13087500";
        String endpoint = cep.concat("/json/");

        RestAssured.baseURI = url;

        RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .given()
                .get(endpoint)
                .then()
                .statusCode(200);
    }
}

