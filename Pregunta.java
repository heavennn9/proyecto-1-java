public abstract class Pregunta {
    protected int peso;
    protected String texto;

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getText() {
        return texto;
    }

    public abstract boolean buscar();
}
