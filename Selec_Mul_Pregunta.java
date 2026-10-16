/**
 * Pregunta de selección múltiple (mínimo 2 alternativas).
 */
public class Selec_Mul_Pregunta extends Pregunta {

    private final String[] elecciones;
    private final int respuestaCorrecta; // índice en el arreglo de elecciones

    public Selec_Mul_Pregunta(String text, String[] elecciones, int respuestaCorrecta, int peso) {
        super(text, peso);
        if (elecciones == null || elecciones.length < 2) {
            throw new IllegalArgumentException("Una pregunta de selección múltiple necesita al menos 2 elecciones.");
        }
        if (elecciones.length > 26) {
            throw new IllegalArgumentException("Máximo 26 elecciones (letras a-z).");
        }
        for (String e : elecciones) {
            if (e == null || e.trim().isEmpty()) {
                throw new IllegalArgumentException("Ninguna elección puede estar vacía.");
            }
        }
        if (respuestaCorrecta < 0 || respuestaCorrecta >= elecciones.length) {
            throw new IllegalArgumentException("El índice de la respuesta correcta está fuera de rango: " + respuestaCorrecta);
        }
        this.elecciones = elecciones.clone(); // copia defensiva
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean buscar() throws ExamenInterrumpidoException {
        System.out.println(getText() + "?");
        for (int i = 0; i < elecciones.length; i++) {
            System.out.println("    " + (char) ('a' + i) + ". " + elecciones[i]);
        }
        char ultima = (char) ('a' + elecciones.length - 1);

        while (true) {
            System.out.print("ingrese la letra de su eleccion: ");
            String r = leerLinea().toLowerCase();

            if (r.length() == 1 && r.charAt(0) >= 'a' && r.charAt(0) <= ultima) {
                int indice = r.charAt(0) - 'a';
                if (indice == respuestaCorrecta) {
                    System.out.println("correcta!");
                    return true;
                }
                System.out.println("no, la respuesta correcta es " + (char) ('a' + respuestaCorrecta)
                        + ". " + elecciones[respuestaCorrecta]);
                return false;
            }
            System.out.println("Opción no válida. Ingrese una letra entre a y " + ultima + " (o STOP para salir).");
        }
    }
}
