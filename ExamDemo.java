public class ExamDemo {
    public static void main(String args[]) {
        Exam miExam = new Exam();
        
        miExam.agregaPregunta(new TFpregunta("La capital de Chile es Santiago", true, 1));
        
        String santiagoElec[] = {"Santiago", "Valparaiso", "Concepcion", "Magallanes", "Arica"};
        miExam.agregaPregunta(new Selec_Mul_Pregunta("Cual es la capital de Region Metropolitana", santiagoElec, 0, 1));
        
        miExam.agregaPregunta(new Resp_Cortas_Pregunta("Cual es la capital de IV Region", "Coquimbo", 1));
        miExam.agregaPregunta(new TFpregunta("La capital de Alberta es Calgary", false, 1));
        
        String BCElec[] = {"Victoria", "Vancouver", "Nanaimo"};
        miExam.agregaPregunta(new Selec_Mul_Pregunta("Cual es la capital de British Columbia", BCElec, 0, 1));
        
        miExam.agregaPregunta(new Resp_Cortas_Pregunta("Cual es la capital de Argentina", "Buenos Aires", 1));
        miExam.agregaPregunta(new Resp_Cortas_Pregunta("Cual es la capital de Canada", "Ottawa", 2));
        miExam.agregaPregunta(new TFpregunta("La capital de La Serena es Illapel", false, 1));
        
        String PElec[] = {"Brasilia", "Rio de Janeiro", "Sao Paulo", "Blumenau"};
        miExam.agregaPregunta(new Selec_Mul_Pregunta("Cual es la capital de Brasil", PElec, 0, 1));

        int puntaje = miExam.darExam();
        System.out.println("su resultado es " + puntaje + "%");
    }
}
