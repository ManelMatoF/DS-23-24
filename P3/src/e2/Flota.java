package e2;
import java.util.LinkedList;
import java.util.Queue;

public class Flota{
    private int hp;
    private int blindaje;
    private int poderFuego;
    private int antiaereo;
    private int lineaVision;

    public Flota(int hp, int blindaje, int poderFuego, int antiaereo, int lineaVision) {
        this.hp = hp;
        this.blindaje = blindaje;
        this.poderFuego = poderFuego;
        this.antiaereo = antiaereo;
        this.lineaVision = lineaVision;
    }

    public int getHp() {
        return hp;
    }

    public int getBlindaje() {
        return blindaje;
    }

    public int getPoderFuego() {
        return poderFuego;
    }

    public int getAntiaereo() {
        return antiaereo;
    }

    public int getLineaVision() {
        return lineaVision;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void SimularIncursion(Nodo nodoInicial) {
        Nodo nodoActual = nodoInicial;
        while (hp > 0 && (nodoActual.obtenerSiguienteNodo(this) != null)) {
            nodoActual.visitar(this);
            if(hp > 0)
                nodoActual = nodoActual.obtenerSiguienteNodo(this);
        }
        System.out.println("Sortie Result:\n" + (this.hp > 0? "    SUCCESS\n" : "    FAIl\n") + "    Last Visited Node: "
        + nodoActual.getId() + "\n    Final HP: " + this.hp);
    }
}