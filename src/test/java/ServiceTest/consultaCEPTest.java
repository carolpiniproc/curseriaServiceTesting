package ServiceTest;

import org.junit.Test;

public class consultaCEPTest {
    @Test
    public void consultaCEP(){
       //http://viacep.com.br/ws/{{cep}}/json/
        String cep = "13087500";
        String url = "http://viacep.com.br/ws/";
        String endpoint = cep.concat("/json/");
    }
}

