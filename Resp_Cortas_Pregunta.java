/**
 * Pregunta de respuesta corta (una única respuesta posible).
 */
public class Resp_Cortas_Pregunta extends Pregunta {

    private final String respuestaCorrecta;

    public Resp_Cortas_Pregunta(String text, String respuestaCorrecta, int peso) {
        super(text, peso);
        if (respuestaCorrecta == null || respuestaCorrecta.trim().isEmpty()) {
            throw new IllegalArgumentException("La respuesta correcta no puede estar vacía.");
        }
        this.respuestaCorrecta = respuestaCorrecta.trim();
    }

    @Override
    public boolean buscar() throws ExamenInterrumpidoException {
        String r;
        do {
            System.out.print(getText() + ": ");
            r = leerLinea();
            if (r.isEmpty()) {
                System.out.println("Debe escribir una respuesta (o STOP para salir).");
            }
        } while (r.isEmpty());

        if (r.equalsIgnoreCase(respuestaCorrecta)) {
            System.out.println("correcta!");
            return true;
        }
        System.out.println("no, la respuesta correcta es " + respuestaCorrecta);
        return false;
    }
}
