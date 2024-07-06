package e2;

public class FireBallSpell implements ObjAtack {
    String codename;
    int damage, mana, uses;

    public FireBallSpell(String codename, int damage, int mana, int uses) {
        this.codename = codename;
        this.uses = uses;
        this.damage = damage;
        this.mana = mana;
    }

    @Override
    public String getCodeName() {
        return codename;
    }

    @Override
    public int getDamage() {
        if (uses == 1)
            return damage - 1;
        else return damage;
    }

    @Override
    public int getMinMana() {
        return mana;
    }

    @Override
    public int getNumUses() {
        return uses;
    }

    @Override
    public void reduceUses() {
        if (uses > 0)
            uses--;
    }
}
