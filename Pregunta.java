import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Clase abstracta con los elementos comunes a todos los tipos de preguntas.
 */
public abstract class Pregunta {

    // private: nadie fuera de esta clase debe tocarlos directamente.
    private final String text;   // el texto se fija en el constructor y nunca cambia
    private int peso;

    // protected + static: las subclases comparten un único Scanner sobre System.in
    protected static final Scanner teclado = new Scanner(System.in);

    protected Pregunta(String text, int peso) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto de la pregunta no puede estar vacío.");
        }
        this.text = text.trim();
        setPeso(peso);
    }

    public String getText() {
        return text;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que 0 (recibido: " + peso + ").");
        }
        this.peso = peso;
    }

    /**
     * Hace la pregunta, lee la respuesta e imprime si fue correcta o no.
     * @return true si el usuario respondió correctamente
     * @throws ExamenInterrumpidoException si el usuario escribe STOP o se cierra la entrada
     */
    public abstract boolean buscar() throws ExamenInterrumpidoException;

    /**
     * Lee una línea de consola. Si el usuario escribe "stop" interrumpe el examen.
     */
    protected String leerLinea() throws ExamenInterrumpidoException {
        try {
            String linea = teclado.nextLine().trim();
            if (linea.equalsIgnoreCase("stop")) {
                throw new ExamenInterrumpidoException("El usuario escribió STOP.");
            }
            return linea;
        } catch (NoSuchElementException | IllegalStateException e) {
            throw new ExamenInterrumpidoException("La entrada de consola se cerró.");
        }
    }
}
