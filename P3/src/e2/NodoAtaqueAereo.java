package e2;

public class NodoAtaqueAereo extends NodoRutaFija {
    private int poderAereoEnemigo;

    public NodoAtaqueAereo(int poderAereoEnemigo, Nodo hijo, char id) {

        super(hijo, id, "AtaqueAereo");
        this.poderAereoEnemigo = poderAereoEnemigo;
    }

    @Override
    public void visitar(Flota flota) {
        int dano = poderAereoEnemigo - (2 * flota.getAntiaereo() + flota.getBlindaje());
        flota.setHp(flota.getHp() - dano);
        super.visitar(flota);
    }
}
