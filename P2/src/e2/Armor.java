package e2;

public class Armor implements ObjDefense {
    String codename;
    int protection, strength;

    public Armor(String codename, int protection, int strength) {
        this.codename = codename;
        this.protection = protection;
        this.strength = strength;
    }

    @Override
    public String getCodeName() {
        return codename;
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