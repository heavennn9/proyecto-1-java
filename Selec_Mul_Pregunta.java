import java.util.Scanner;

public class Selec_Mul_Pregunta extends Pregunta {
    private String[] opciones;
    private int indiceCorrecto;

    public Selec_Mul_Pregunta(String texto, String[] opciones, int indiceCorrecto, int peso) {
        this.texto = texto;
        this.opciones = opciones;
        this.indiceCorrecto = indiceCorrecto;
        this.peso = peso;
    }

    @Override
    public boolean buscar() {
        Scanner sc = new Scanner(System.in);
        System.out.println(texto + "?");

        for (int i = 0; i < opciones.length; i++) {
            char letra = (char) ('a' + i);
            System.out.println("  " + letra + ". " + opciones[i]);
        }

        int seleccion = -1;
        while (seleccion == -1) {
            System.out.print("ingrese la letra de su eleccion: ");
            String input = sc.nextLine().trim().toLowerCase();

            if (!input.isEmpty()) {
                int idx = input.charAt(0) - 'a';
                if (idx >= 0 && idx < opciones.length) {
                    seleccion = idx;
                } else {
                    System.out.println("Opcion fuera de rango.");
                }
            }
        }

        if (seleccion == indiceCorrecto) {
            System.out.println("correcta!");
            return true;
        } else {
            System.out.println("no, la respuesta correcta era: " + (char) ('a' + indiceCorrecto));
            return false;
        }
    }
}
