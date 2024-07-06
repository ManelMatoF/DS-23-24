package e2;

public class Sword implements ObjAtack, ObjDefense {
    String codename;
    int damage, mana, uses, protection, strength;
    public Sword(String codename, int damage, int mana, int uses, int protection, int strength){
        this.codename = codename;
        this.damage = damage;
        this.mana = mana;
        this.uses = uses;
        this.protection = protection;
        this.strength = strength;
    }
    @Override
    public String getCodeName() {
        return codename;
    }

    @Override
    public int getDamage() {
        return damage;
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
