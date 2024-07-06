package e2;

public abstract class Nodo {
    private char id;
    private String type;

    public Nodo(char id, String type) {
        this.id = id;
        this.type = type;
    }

    public abstract void visitar(Flota flota);
    public abstract Nodo obtenerSiguienteNodo(Flota flota);

    public char getId() {
        return id;
    }
    public String getType() { return type; }

    // Método para imprimir en formato Newick
    public abstract String imprimirNewick();

    // Método para imprimir todo el árbol
    public void imprimirArbol() {
        System.out.println(imprimirNewick());
    }
}