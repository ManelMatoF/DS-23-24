package e2;


public class NodoFinal extends Nodo{

    public NodoFinal(char id){
        super(id, "Final");
    }
    @Override
    public void visitar(Flota flota) {
        // No hay acción que realizar en un nodo final.
    }
    @Override
    public Nodo obtenerSiguienteNodo(Flota flota){
        return null; //nulo para indicar que es un nodo final.
    }
    @Override
    public String imprimirNewick() {
        return "(" + getId() + " " + getType() + ")";
    }
}
