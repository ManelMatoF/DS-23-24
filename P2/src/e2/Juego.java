package e2;

public class Juego {
    public static int SingleAttack(Personajes attacker, Personajes defender) {
        return Math.max(attacker.usarObjetoDeAtaque() + attacker.getStrength() - defender.getProteccionTotal(), 0);
    }

    public static Personajes Turns(Personajes character1, Personajes character2, int maxTurns) {
        for (int turn = 1; turn <= maxTurns; turn++) {
            int damage1 = SingleAttack(character1, character2);
            character2.setHealth(character2.getHealth()-damage1);

            if (character2.getHealth() <= 0)
                return character1;

            Personajes temp = character1;
            character1 = character2;
            character2 = temp;
        }
        return null;
    }
}