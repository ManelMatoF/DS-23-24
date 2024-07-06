package e2;

public abstract class NodoBifurcacion extends Nodo{
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;
    public NodoBifurcacion(Nodo izquierdo, Nodo derecho, char id, String type){
        super(id, type);
        this.hijoIzquierdo=izquierdo;
        this.hijoDerecho=derecho;
    }

    @Override
    public void visitar(Flota flota) {
        //
    }
    @Override
    public abstract Nodo obtenerSiguienteNodo(Flota flota);

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public Nodo getHijoDerecho() { return hijoDerecho; }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public String imprimirNewick() {

        String hijoIzquierdo = getHijoIzquierdo() != null ? getHijoIzquierdo().imprimirNewick() : "";
        String hijoDerecho = getHijoDerecho() != null ? getHijoDerecho().imprimirNewick() : "";
        return "(" + getId() + " " + getType() + ","  + hijoIzquierdo  + "," +  hijoDerecho + ")";
    }
}
