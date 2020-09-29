package examples;

import mediaNotas.Media;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MediaTest {

    @Test
    public void testReprovado() {
        int nota1 = 5;
        int nota2 = 5;
        String resultado = "";
        Media media = new Media(nota1, nota2);
        resultado = media.getResultado();
        assertEquals("Reprovado", resultado);
    }

    @Test
    public void testAprovado(){
        String resultado = "";
        Media media = new Media(6, 6);
        resultado = media.getResultado();
        assertEquals("Aprovado", resultado);
    }

}
