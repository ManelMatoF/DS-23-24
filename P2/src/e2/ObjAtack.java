package e2;

public interface ObjAtack extends Objeto {
    int getDamage();

    int getMinMana();

    int getNumUses();

    void reduceUses();
}