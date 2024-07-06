package e2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonajesTest {
    private static Warrior jugador1;
    private static Wizard jugador2;
    @BeforeAll
    static void setUP() {
        jugador1 = new Warrior("Pepe", 20, 10, 5, null, null);
        jugador2 = new Wizard("Juan", 20, 8, 3, null, null);
        jugador1.equiparObjetoDeAtaque(new Wand("Vara1", 2, 1, 2, 2, 1));
        jugador1.equiparObjetoDefensivo(new Armor("Escudo1", 3, 1));
        jugador1.equiparObjetoDefensivo(new Armor("Escudo2", 1, 3));
        jugador1.equiparObjetoDeAtaque(new FireBallSpell("BolaFuego2", 1, 2, 3));
        jugador2.equiparObjetoDefensivo(new Wand("Vara2", 3, 2, 2, 2, 2));
        jugador2.equiparObjetoDeAtaque(new FireBallSpell("BolaFuego1", 2, 1, 2));
    }
    @Test
    void testObjetosDeAtaque(){
        setUP();

        assertEquals(4, jugador1.usarObjetoDeAtaque());
        assertEquals(2, jugador1.usarObjetoDeAtaque());
        assertEquals(1, jugador1.usarObjetoDeAtaque());
        assertEquals(1, jugador1.usarObjetoDeAtaque());
        assertEquals(0, jugador1.usarObjetoDeAtaque());
        assertEquals(0, jugador1.usarObjetoDeAtaque());

        assertEquals(2, jugador2.usarObjetoDeAtaque());
        jugador2.setMana(0);
        assertEquals(0, jugador2.usarObjetoDeAtaque());
        jugador2.setMana(2);
        assertEquals(1, jugador2.usarObjetoDeAtaque());
    }
    @Test
    void testObjetosDefensa(){
        setUP();

        assertEquals(4, jugador1.getProteccionTotal());
        assertEquals(2, jugador2.getProteccionTotal());
        jugador1.setStrength(2);
        assertEquals(3, jugador1.getProteccionTotal());
    }

}