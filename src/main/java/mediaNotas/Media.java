package mediaNotas;

import java.util.LinkedHashMap;

public class Media {
    int nota1;
    int nota2;

    public Media(int nota1, int _nota2) {
        this.nota1 = nota1;
        nota2 = _nota2;
    }

    public String getResultado(){
        int soma = nota1+nota2;
        if (soma < 12){
            return "Reprovado";
        }
        return "Aprovado";
    }

    public void Test(){
        String tempo = "sol";
        String resultado = "";

        switch (tempo){
            case "sol":
                resultado = "saia de máscara";
                break;
            case "chuva":
                resultado = "saia de máscara e guarda-chuva";
                break;
            case "neve":
                resultado = "fique em casa";
            default:
                break;
        }
    }

    public void TestMap(){
        String tempo = "sol";
        String resultado = "";

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("sol", "saia de máscara");
        map.put("chuva","saia de máscara e guarda-chuva");
        map.put("neve", "fique em casa");

        resultado = map.get(tempo);
    }
}

