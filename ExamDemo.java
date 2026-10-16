/**
 * Programa principal para testear: crea un examen de 10 puntos y lo administra.
 */
public class ExamDemo {

    public static void main(String[] args) {
        System.out.println("=== Examen de capitales ===");
        System.out.println("(escriba STOP en cualquier momento para salir)\n");
        System.out.print("Ingrese su nombre: ");
        String nombre = "Anónimo";
        try {
            String leido = Pregunta.teclado.nextLine().trim(); // mismo Scanner que las preguntas
            if (!leido.isEmpty()) nombre = leido;
        } catch (java.util.NoSuchElementException e) {
            System.out.println("\nNo se pudo leer el nombre, se usará 'Anónimo'.");
        }

        try {
            // 8 preguntas de 1 punto y una de 2 puntos = 10 puntos
            Exam miExam = new Exam();
            miExam.agregaPregunta(new TFpregunta("La capital de Chile es Santiago", true, 1));
            String santiagoElec[] = {"Santiago", "Valparaiso", "Concepcion", "Magallanes", "Arica"};
            miExam.agregaPregunta(new Selec_Mul_Pregunta("Cuál es la capital de Region Metropolitana", santiagoElec, 0, 1));
            miExam.agregaPregunta(new Resp_Cortas_Pregunta("Cuál es la capital de IV Region", "Coquimbo", 1));
            miExam.agregaPregunta(new TFpregunta("La capital de Alberta es Calgary", false, 1));
            String BCElec[] = {"Victoria", "Vancouver", "Nanaimo"};
            miExam.agregaPregunta(new Selec_Mul_Pregunta("Cuál es la capital de British Columbia", BCElec, 0, 1));
            miExam.agregaPregunta(new Resp_Cortas_Pregunta("Cuál es la capital de Argentina", "Buenos Aires", 1));
            miExam.agregaPregunta(new Resp_Cortas_Pregunta("Cuál es la capital de Canada", "Ottawa", 2));
            miExam.agregaPregunta(new TFpregunta("La capital de La Serena es Illapel", false, 1));
            String PElec[] = {"Brasilia", "Rio de Janeiro", "Sao Paulo", "Blumenau"};
            miExam.agregaPregunta(new Selec_Mul_Pregunta("Cuál es la capital de Brasil", PElec, 0, 1));

            int puntaje = miExam.darExam();
            System.out.println("su resultado es " + puntaje + "%");

            RegistroPuntajes.guardar(nombre, puntaje);
            RegistroPuntajes.mostrarHistorial();

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error al armar o administrar el examen: " + e.getMessage());
        }
    }
}
