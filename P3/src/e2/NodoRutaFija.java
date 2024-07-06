package e2;


public abstract class NodoRutaFija extends Nodo{
    private Nodo hijo;

    public NodoRutaFija(Nodo hijo, char id, String type) {
        super(id, type);
        this.hijo = hijo;
    }
    @Override
    public void visitar (Flota flota){
        //
    }
    @Override
    public Nodo obtenerSiguienteNodo(Flota flota){
        return hijo;
    }

    public Nodo getHijo() {
        return hijo;
    }

    public void setHijo(Nodo hijo) {
        this.hijo = hijo;
    }

    @Override
    public String imprimirNewick() {
        if (getHijo() != null) {
            return "(" + getId() + " " + getType() + "," +  hijo.imprimirNewick()   + ")";
        } else {
            return "(" + getId() + " " + getType() + ")";
        }
    }
}