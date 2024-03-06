package advanture_game;

import java.util.ArrayList;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private ArrayList<String> awards;

    public Inventory() {
        this.weapon = new Weapon(0,"Punch",0,0);
        this.armor = new Armor(0,"-",0,0);
        this.awards = new ArrayList<>();
    }

    public ArrayList<String> getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards.add(awards);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
