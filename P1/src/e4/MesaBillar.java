package e4;
import java.util.ArrayList;
import java.util.Arrays;


public class MesaBillar {
    private ArrayList<BolaBillar> bolasCajetin;
    private ArrayList<BolaBillar> bolasMesa;
    private boolean iniciado;

    public MesaBillar() {
        bolasCajetin = new ArrayList<>();
        bolasMesa = new ArrayList<>();
        iniciado = false;
        bolasMesa.addAll(Arrays.asList(BolaBillar.values()));
    }

    public void iniciarPartida() {
        iniciado = true;
        System.out.println("Partida en marcha, todas las bolas estan en la mesa");
    }

    public void meterBola(BolaBillar bola) {
        if (!iniciado)
            System.out.println("No es posible introducir una bola");

        if (bola.equals(BolaBillar.BLANCA)) {
            System.out.println("La bola blanca ha vuelto a la mesa.");
            return;
        }

        if (bola.equals(BolaBillar.BOLA8)) {
            iniciado = false;
            bolasMesa.remove(bola);
            bolasCajetin.add(bola);
            System.out.println("La partida ha terminado.");
            return;
        }
        bolasMesa.remove(bola);
        bolasCajetin.add(bola);
        if (contarBolasDeTipo("LISA") == 7 || contarBolasDeTipo("RAYADA") == 7)
            iniciado = false;
    }

    public ArrayList<BolaBillar> bolasMesa() {
        return bolasMesa;
    }

    public ArrayList<BolaBillar> bolasCajetin() {
        return bolasCajetin;
    }

    public boolean esPartidaIniciada() {
        return iniciado;
    }

    public String obtenerGanador() {

        int lisas = contarBolasDeTipo("LISA");
        int rayadas = contarBolasDeTipo("RAYADA");

        if (lisas < rayadas) {
            return ("El jugador de las bolas rayadas " + (iniciado? "va ganando" : "ha ganado"));
        } else if (rayadas < lisas) {
            return ("El jugador de las bolas lisas " + (iniciado? "va ganando" : "ha ganado"));
        } else {
            return ("La partida está empatada.");
        }
    }

    private int contarBolasDeTipo(String tipo) {
        int count = 0;

        for (BolaBillar bola : bolasCajetin) {
            if (bola.getTipo().equals(tipo)) {
                count++;
            }
        }
        return count;
    }
}