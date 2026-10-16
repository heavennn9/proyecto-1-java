import java.util.Scanner;

public class TFpregunta extends Pregunta {
    private boolean respuestaCorrecta;

    public TFpregunta(String texto, boolean respuestaCorrecta, int peso) {
        this.texto = texto;
        this.respuestaCorrecta = respuestaCorrecta;
        this.peso = peso;
    }

    @Override
    public boolean buscar() {
        Scanner sc = new Scanner(System.in);
        String entrada = "";

        while (true) {
            System.out.print(texto + " (ingrese T o F): ");
            entrada = sc.nextLine().trim();

            if (entrada.equalsIgnoreCase("T") || entrada.equalsIgnoreCase("F")) {
                break;
            }
            System.out.println("Entrada invalida. Intente de nuevo.");
        }

        boolean respuestaUsuario = entrada.equalsIgnoreCase("T");
        if (respuestaUsuario == respuestaCorrecta) {
            System.out.println("correcta!");
            return true;
        } else {
            System.out.println("no, la respuesta es falsa");
            return false;
        }
    }
}
