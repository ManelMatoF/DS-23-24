package e4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MesaBillarTest {
    private static MesaBillar mesa;

    @BeforeAll
    public static void setUp() {
        mesa = new MesaBillar();
    }

    @Test
    public void testIniciarPartida() {
        mesa.iniciarPartida();
        assertTrue(mesa.esPartidaIniciada());
    }

    @Test
    public void testMeterBolaNegra() {
        setUp();
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA8);
        assertFalse(mesa.esPartidaIniciada());
    }

    @Test
    public void testMeterBola() {
        setUp();
        mesa.iniciarPartida();
        mesa.meterBola(BolaBillar.BOLA5);
        assertFalse(mesa.bolasMesa().contains(BolaBillar.BOLA5));
        assertTrue(mesa.bolasCajetin().contains(BolaBillar.BOLA5));
    }

    @Test
    public void testGetGanador() {
        setUp();
        mesa.iniciarPartida();
        assertEquals("La partida está empatada.", mesa.obtenerGanador());

        mesa.meterBola(BolaBillar.BOLA3);
        mesa.meterBola(BolaBillar.BOLA10);
        mesa.meterBola(BolaBillar.BOLA2);

        assertEquals("El jugador de las bolas lisas va ganando", mesa.obtenerGanador());

        mesa.meterBola(BolaBillar.BOLA8);

        assertEquals("El jugador de las bolas lisas ha ganado", mesa.obtenerGanador());
    }

    @Test
    public void testPartidaCompleta() {
        // Iniciar la partida
        setUp();
        mesa.iniciarPartida();
        assertTrue(mesa.esPartidaIniciada());

        // Meter bolas a la mesa
        mesa.meterBola(BolaBillar.BLANCA);
        mesa.meterBola(BolaBillar.BOLA1);
        mesa.meterBola(BolaBillar.BOLA2);
        mesa.meterBola(BolaBillar.BOLA9);

        // Verificar el estado de la partida
        assertTrue(mesa.esPartidaIniciada());

        // Obtener bolas en la mesa y en el cajetín
        assertEquals(13, mesa.bolasMesa().size());
        assertEquals(3, mesa.bolasCajetin().size());

        // Meter bolas a la mesa
        mesa.meterBola(BolaBillar.BOLA10);
        mesa.meterBola(BolaBillar.BOLA11);
        mesa.meterBola(BolaBillar.BOLA12);
        mesa.meterBola(BolaBillar.BOLA13);
        mesa.meterBola(BolaBillar.BOLA14);
        mesa.meterBola(BolaBillar.BOLA15);

        // Verificar que la partida ha terminado
        assertFalse(mesa.esPartidaIniciada());

        // Obtener el ganador y comprobar que es el esperado
        assertEquals("El jugador de las bolas rayadas ha ganado", mesa.obtenerGanador());
    }
}
