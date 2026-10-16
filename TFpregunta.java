/**
 * Pregunta de Verdadero/Falso.
 */
public class TFpregunta extends Pregunta {

    private final boolean respuestaCorrecta;

    public TFpregunta(String text, boolean respuestaCorrecta, int peso) {
        super(text, peso);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public boolean buscar() throws ExamenInterrumpidoException {
        while (true) {
            System.out.print(getText() + " (ingrese T o F): ");
            String r = leerLinea();

            if (r.equalsIgnoreCase("t") || r.equalsIgnoreCase("f")) {
                boolean respuestaUsuario = r.equalsIgnoreCase("t");
                if (respuestaUsuario == respuestaCorrecta) {
                    System.out.println("correcta!");
                    return true;
                }
                System.out.println("no, la respuesta es " + (respuestaCorrecta ? "verdadera" : "falsa"));
                return false;
            }
            System.out.println("Respuesta no válida. Use T o F (o escriba STOP para salir).");
        }
    }
}
