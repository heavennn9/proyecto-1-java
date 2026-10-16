/**
 * Colección de preguntas que se administra al usuario.
 */
public class Exam {

    public static final int MAX_PREGUNTAS = 10;

    private final Pregunta[] preguntas = new Pregunta[MAX_PREGUNTAS];
    private int contador = 0;

    public void agregaPregunta(Pregunta p) {
        if (p == null) {
            throw new IllegalArgumentException("No se puede agregar una pregunta nula.");
        }
        if (contador >= MAX_PREGUNTAS) {
            throw new IllegalStateException("El examen ya tiene el máximo de " + MAX_PREGUNTAS + " preguntas.");
        }
        preguntas[contador++] = p;
    }

    public int getNumPreguntas() {
        return contador;
    }

    /**
     * Administra el examen y devuelve el porcentaje (0-100) redondeado.
     * Si el usuario interrumpe con STOP, las preguntas sin responder cuentan como incorrectas.
     */
    public int darExam() {
        if (contador == 0) {
            throw new IllegalStateException("El examen no tiene preguntas.");
        }

        int pesoTotal = 0;
        for (int i = 0; i < contador; i++) {
            pesoTotal += preguntas[i].getPeso();
        }

        int pesoObtenido = 0;
        for (int i = 0; i < contador; i++) {
            try {
                if (preguntas[i].buscar()) {
                    pesoObtenido += preguntas[i].getPeso();
                }
            } catch (ExamenInterrumpidoException e) {
                System.out.println("\nExamen interrumpido: " + e.getMessage()
                        + " Las preguntas restantes cuentan como incorrectas. ¡A estudiar!");
                break;
            }
        }
        return (int) Math.round(pesoObtenido * 100.0 / pesoTotal);
    }
}
