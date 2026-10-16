import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Extra: registro de puntajes en un archivo de texto.
 */
public class RegistroPuntajes {

    private static final String ARCHIVO = "puntajes.txt";

    public static void guardar(String nombre, int porcentaje) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
        try (PrintWriter out = new PrintWriter(new FileWriter(ARCHIVO, true))) { // true = agregar al final
            out.println(fecha + ";" + nombre + ";" + porcentaje + "%");
        } catch (IOException e) {
            System.out.println("Aviso: no se pudo guardar el puntaje (" + e.getMessage() + ").");
        }
    }

    public static void mostrarHistorial() {
        try (BufferedReader in = new BufferedReader(new FileReader(ARCHIVO))) {
            System.out.println("\n--- Historial de puntajes ---");
            String linea;
            while ((linea = in.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    System.out.println(partes[0] + "  " + partes[1] + "  " + partes[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Aún no hay historial de puntajes.");
        }
    }
}
