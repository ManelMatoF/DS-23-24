package e2;

public class NodoTormenta extends NodoRutaFija{
    private int fuerzaTormenta;

    public NodoTormenta(int fuerzaTormenta, Nodo hijo, char id) {
        super(hijo, id, "Tormenta");
        this.fuerzaTormenta = fuerzaTormenta;
    }

    @Override
    public void visitar(Flota flota) {
        if (flota.getLineaVision() < fuerzaTormenta) {
            flota.setHp(flota.getHp() - 10);
        }
        super.visitar(flota);
    }

}