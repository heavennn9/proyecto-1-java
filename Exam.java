public class Exam {
    private Pregunta[] listaPreguntas;
    private int totalPreguntas;

    public Exam() {
        listaPreguntas = new Pregunta[10];
        totalPreguntas = 0;
    }

    public void agregaPregunta(Pregunta p) {
        if (totalPreguntas < listaPreguntas.length) {
            listaPreguntas[totalPreguntas] = p;
            totalPreguntas++;
        } else {
            System.out.println("Limite de preguntas alcanzado.");
        }
    }

    public int darExam() {
        int obtenidos = 0;
        int maximos = 0;

        for (int i = 0; i < totalPreguntas; i++) {
            maximos += listaPreguntas[i].getPeso();
            if (listaPreguntas[i].buscar()) {
                obtenidos += listaPreguntas[i].getPeso();
            }
        }

        if (maximos == 0) {
            return 0;
        }

        double porcentaje = ((double) obtenidos / maximos) * 100.0;
        return (int) Math.round(porcentaje);
    }
}
