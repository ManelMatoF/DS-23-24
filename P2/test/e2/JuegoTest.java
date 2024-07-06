package e2;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuegoTest {
    private static Warrior jugador1;
    private static Wizard jugador2;

    @BeforeAll
    static void setUP() {
        jugador1 = new Warrior("Pepe", 20, 8, 5, null, null);
        jugador2 = new Wizard("Juan", 20, 5, 3, null, null);
        jugador1.equiparObjetoDeAtaque(new Wand("Vara1", 2, 3, 2, 2, 1));
        jugador1.equiparObjetoDefensivo(new Armor("Escudo", 3, 1));
        jugador1.equiparObjetoDefensivo(new Armor("Escudo2", 1, 7));
        jugador2.equiparObjetoDefensivo(new Wand("Vara2", 3, 2, 2, 4, 2));
        jugador2.equiparObjetoDeAtaque(new Sword("Escudo3", 3, 2, 1, 1, 2));
        jugador2.equiparObjetoDeAtaque(new FireBallSpell("BolaFuego", 2, 1, 2));
    }
    @Test
    public void testAtaque(){
        setUP();

        assertEquals(8, Juego.SingleAttack(jugador1, jugador2));
        assertEquals(4, Juego.SingleAttack(jugador2, jugador1));
    }
    @Test
    public void testTurns(){
        setUP();
        assertEquals(jugador1, Juego.Turns(jugador1, jugador2, 7));
        setUP();
        assertNull(Juego.Turns(jugador2, jugador1, 7));
        setUP();
        jugador1.setMana(1);
        jugador1.setStrength(6);
        assertEquals(jugador2, Juego.Turns(jugador2, jugador1, 20));
        setUP();
        jugador1.setMana(1);
        jugador1.setStrength(5);
        jugador1.equiparObjetoDefensivo(new Sword("Escudo4", 3, 2, 1, 2, 2));
        assertEquals(jugador1, Juego.Turns(jugador1, jugador2, 40));
    }

}