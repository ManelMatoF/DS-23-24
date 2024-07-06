package e2;

import java.util.ArrayList;
import java.util.List;


public class Personajes {
    private final String name;
    private int health;
    private int strength;
    private int mana;
    private final List<ObjDefense> objectsDefense;
    private final List<ObjAtack> objectsAtack;

    public Personajes(String name, int vida, int fuerza, int mana, List<ObjDefense> objetosDefensivos, List<ObjAtack> objetosDeAtaque) {
        this.name = name;
        this.health = Math.min(Math.max(vida, 0), 20);
        this.strength = Math.min(Math.max(fuerza, 1), 10);
        this.mana = Math.min(Math.max(mana, 1), 10);
        this.objectsDefense = (objetosDefensivos != null) ? new ArrayList<>(objetosDefensivos.subList(0, Math.min(objetosDefensivos.size(), 5))) : new ArrayList<>();
        this.objectsAtack = (objetosDeAtaque != null) ? new ArrayList<>(objetosDeAtaque.subList(0, Math.min(objetosDeAtaque.size(), 5))) : new ArrayList<>();
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getMana(){ return mana; }

    public List<ObjAtack> getObjetosDeAtaque() {
        return objectsAtack;
    }

    public List<ObjDefense> getObjetosDefensivos() {
        return objectsDefense;
    }

    public void equiparObjetoDefensivo(ObjDefense objetoDefensivo) {
        if (objectsDefense.size() < 5) {
            objectsDefense.add(objetoDefensivo);
        }
    }

    public void equiparObjetoDeAtaque(ObjAtack objetoDeAtaque) {
        if (objectsAtack.size() < 5) {
            objectsAtack.add(objetoDeAtaque);
        }
    }

    public int getProteccionTotal() {
        int proteccionTotal = 0;
        for (ObjDefense objeto : objectsDefense) {
            if(objeto.getMinStrength() < getStrength())
                proteccionTotal += objeto.getProtection();
        }
        return proteccionTotal;
    }
    public int usarObjetoDeAtaque() {
        int tDamage = 0;
        if (objectsAtack.isEmpty()) {
            return tDamage;
        }
        ObjAtack obj = objectsAtack.get(0);
        if (obj.getNumUses() == 0){
            objectsAtack.remove(0);
            return usarObjetoDeAtaque();
        }
        else if(obj.getMinMana() > getMana()){
            if(objectsAtack.size()>1)
                obj = objectsAtack.get(1);
        }

        if(obj.getMinMana() < getMana() && obj.getNumUses() > 0){
            tDamage = obj.getDamage();
            obj.reduceUses();
        }
        return tDamage;
    }
}
class Wizard extends Personajes {
    public Wizard(String name, int vida, int fuerza, int mana, List<ObjDefense> objetosDefensivos, List<ObjAtack> objetosDeAtaque) {
        super(name, vida, fuerza, mana, objetosDefensivos, objetosDeAtaque);}
}

class Warrior extends Personajes {
    public Warrior(String name, int vida, int fuerza, int mana, List<ObjDefense> objetosDefensivos, List<ObjAtack> objetosDeAtaque) {
        super(name, vida, fuerza, mana, objetosDefensivos, objetosDeAtaque);}
}
