package e2;

public class Wand implements ObjAtack, ObjDefense {
    String codename;
    int damage, mana, uses, protection, strength, maxuses;

    public Wand(String codename, int damage, int mana, int uses, int protection, int strength) {
        this.codename = codename;
        this.damage = damage;
        this.mana = mana;
        this.uses = uses;
        this.protection = protection;
        this.strength = strength;
        maxuses = uses;
    }

    @Override
    public String getCodeName() {
        return codename;
    }

    @Override
    public int getDamage() {
        if (maxuses == uses)
        return 2 * damage;
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

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public int getMinStrength() {
        return strength;
    }
}
