package e2;

public class NodoBatalla extends NodoBifurcacion{
    private int HPEnemigo;
    private int blindajeEnemigo;
    private int poderFuegoEnemigo;

    public NodoBatalla(int HPEnemigo, int blindajeEnemigo, int poderFuegoEnemigo, Nodo izquierdo, Nodo derecho, char id) {
        super(izquierdo, derecho, id, "Batalla");
        this.HPEnemigo = HPEnemigo;
        this.blindajeEnemigo = blindajeEnemigo;
        this.poderFuegoEnemigo = poderFuegoEnemigo;
    }
    @Override
    public Nodo obtenerSiguienteNodo(Flota flota) {
        int danoFlota = poderFuegoEnemigo - flota.getBlindaje();
        int danoEnemigo = flota.getPoderFuego() - blindajeEnemigo;
        if(danoFlota > 0)
            flota.setHp(flota.getHp() - danoFlota);
        HPEnemigo -= danoEnemigo;
        if (HPEnemigo <= 0){
            return getHijoIzquierdo();
        }else{
            return getHijoDerecho();
        }
    }
}
