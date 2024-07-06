package e2;

public class NodoAvistamiento extends NodoBifurcacion{
    private int distancia;


    public NodoAvistamiento(int distancia, Nodo izquierdo, Nodo derecho, char id) {
        super(izquierdo, derecho, id, "Avistamiento");
        this.distancia = distancia;
    }

    @Override
    public Nodo obtenerSiguienteNodo(Flota flota) {
        if (flota.getLineaVision() >= distancia) {
            return getHijoIzquierdo();
        }else{
            return getHijoDerecho();
        }
    }

}
