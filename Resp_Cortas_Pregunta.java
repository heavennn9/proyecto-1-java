import java.util.Scanner;

public class Resp_Cortas_Pregunta extends Pregunta {
    private String respuestaCorrecta;

    public Resp_Cortas_Pregunta(String texto, String respuestaCorrecta, int peso) {
        this.texto = texto;
        this.respuestaCorrecta = respuestaCorrecta;
        this.peso = peso;
    }

    @Override
    public boolean buscar() {
        Scanner sc = new Scanner(System.in);
        System.out.print(texto + ": ");
        String respuestaUsuario = sc.nextLine().trim();

        if (respuestaUsuario.equalsIgnoreCase(respuestaCorrecta)) {
            System.out.println("correcta!");
            return true;
        } else {
            System.out.println("no, la respuesta correcta es " + respuestaCorrecta);
            return false;
        }
    }
}
