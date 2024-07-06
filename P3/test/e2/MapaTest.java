package e2;

import e1.Hotel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {
    private static Mapa mapa;
    private static NodoAvistamiento nodoAvistamiento1;
    private static NodoTormenta nodoTormenta1, nodoTormenta2;
    private static NodoBatalla nodoBatalla1, nodoBatalla2;
    private static NodoFinal nodoFinal1, nodoFinal2, nodoFinal3, nodoFinal4;
    private static NodoAtaqueAereo nodoAtaqueAereo1;
    private static Flota flotaA, flotaB;
    @BeforeAll
    static void setUp() {
        // Crear un mapa
        mapa = new Mapa();

        // Añadir Nodos
        nodoAvistamiento1 = new NodoAvistamiento(28, null, null, 'A');
        nodoTormenta1 = new NodoTormenta(20, null, 'C');
        nodoBatalla1 = new NodoBatalla(30, 20, 25, null, null, 'B');
        nodoFinal1 = new NodoFinal('D');
        nodoAtaqueAereo1 = new NodoAtaqueAereo(151, null, 'E');
        nodoBatalla2 = new NodoBatalla(17, 30, 41, null, null, 'F');
        nodoTormenta2 = new NodoTormenta(67, null, 'G');
        nodoFinal2 = new NodoFinal('H');
        nodoFinal3 = new NodoFinal('I');
        nodoFinal4 = new NodoFinal('K');

        nodoAvistamiento1.setHijoDerecho(nodoTormenta1);
        nodoAvistamiento1.setHijoIzquierdo(nodoBatalla1);
        nodoTormenta1.setHijo(nodoBatalla2);
        nodoBatalla1.setHijoDerecho(nodoAtaqueAereo1);
        nodoBatalla1.setHijoIzquierdo(nodoFinal1);
        nodoAtaqueAereo1.setHijo(nodoFinal4);
        nodoBatalla2.setHijoDerecho(nodoTormenta2);
        nodoBatalla2.setHijoIzquierdo(nodoFinal2);
        nodoTormenta2.setHijo(nodoFinal3);

        // Crear flotas
        flotaA = new Flota(11, 42, 47, 0, 0);
        flotaB = new Flota(1, 25, 0, 46, 28);
    }

    @Test
    void testRealizarIncursion(){
        setUp();
        assertEquals(nodoTormenta1,  nodoAvistamiento1.obtenerSiguienteNodo(flotaA));
        assertEquals(nodoBatalla1,  nodoAvistamiento1.obtenerSiguienteNodo(flotaB));
        assertEquals(nodoBatalla2,  nodoTormenta1.obtenerSiguienteNodo(flotaA));
        assertEquals(nodoAtaqueAereo1,  nodoBatalla1.obtenerSiguienteNodo(flotaB));
        assertEquals(nodoAtaqueAereo1,  nodoBatalla1.obtenerSiguienteNodo(flotaA));
        assertEquals(nodoFinal2,  nodoBatalla2.obtenerSiguienteNodo(flotaA));

    }
    @Test
    void testSimularIncursion() {
        setUp();
        flotaA.SimularIncursion(nodoAvistamiento1);
        flotaB.SimularIncursion(nodoAvistamiento1);
    }
    @Test
    void testMinNodos(){
        setUp();
        assertEquals(3, mapa.determinarNumeroMinimoNodos(nodoAvistamiento1));
        nodoBatalla1.setHijoIzquierdo(null);
        assertEquals(4, mapa.determinarNumeroMinimoNodos(nodoAvistamiento1));
    }

    @Test
    void testNewick() {
        setUp();
        System.out.println("\n\ntestNewick");
        mapa.Newick(nodoAvistamiento1);
    }


}
