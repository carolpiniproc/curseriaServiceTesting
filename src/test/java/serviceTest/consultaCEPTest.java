package serviceTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import utils.RestUtils;
import java.util.LinkedHashMap;
import static junit.framework.Assert.assertEquals;

public class consultaCEPTest {
    String url = "http://viacep.com.br/ws/";

    @Test
    public void validaStatusCodeLong() {
        //http://viacep.com.br/ws/{{cep}}/json/
        String cep = "13087500";
        String endpoint = cep.concat("/json/"); // ou pode usar endpoint = cep+"/json/"

        RestAssured.baseURI = url;

        RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200);
    }

    @Test
    public void validaStatusCodeShort() {
        String cep = "13087500";
        String endpoint = cep.concat("/json/");

        RestUtils.setUrl(url);

        RestUtils.get(endpoint);
        assertEquals(200, RestUtils.getStatusCode());
    }

    @Test
    public void validaDadosCEPHeaders(){
        String cep = "13087500";
        String endpoint = cep.concat("/json/");
        LinkedHashMap<String, String> header = new LinkedHashMap<>();
        header.put("clientId", "curso");
        header.put("Authorization", "Basic Y2Fyb2w6dGVzdGU=");

        RestUtils.setUrl(url);

        RestUtils.get(endpoint, header);

        assertEquals(200, RestUtils.getStatusCode());
        assertEquals("Mansões Santo Antônio", RestUtils.getValue("bairro"));
        assertEquals("Rua Hermantino Coelho", RestUtils.getValue("logradouro"));
        assertEquals("Campinas", RestUtils.getValue("localidade"));
    }


    @Test
    public void validaDadosCEPParam(){
        String cep = "13087500";
        String endpoint = cep.concat("/json/"); // ou pode usar endpoint = cep+"/json/";
        LinkedHashMap<String, String> param = new LinkedHashMap<>();
        param.put("clientId", "curso");
        param.put("nome", "Carol");

        RestUtils.setUrl(url);

        RestUtils.getParams(endpoint, param);

        assertEquals(200, RestUtils.getStatusCode());
        assertEquals("Mansões Santo Antônio", RestUtils.getValue("bairro"));
        assertEquals("Rua Hermantino Coelho", RestUtils.getValue("logradouro"));
        assertEquals("Campinas", RestUtils.getValue("localidade"));
        // se houver bug na primeira validação, os seguintes testes não são executados
    }

}

