/**
 * Se lanza cuando el usuario escribe STOP o cuando la entrada de consola se cierra.
 */
public class ExamenInterrumpidoException extends Exception {
    public ExamenInterrumpidoException(String mensaje) {
        super(mensaje);
    }
}
