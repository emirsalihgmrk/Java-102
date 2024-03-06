package advanture_game;
import javax.swing.*;
import java.util.Scanner;
public class Player {
    Scanner input = new Scanner(System.in);
    private GameChar gameChar;
    private Inventory inventory;
    private int damage;
    private int health;
    private int money;
    String charName;
    String name;
    private int OrijinalHealth;

    public Player(String name) {
        this.inventory = new Inventory();
        this.name = name;
    }
    public void selectChar(){
        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("-------------------------------------------------------");
        for (GameChar gameChar:charList) {
            System.out.println(
                    "ID : " + gameChar.getID()+
                    "\t\t" + gameChar.getName()+
                    "\t\tDamage : " + gameChar.getDamage()+
                    "\t\tHealth : " + gameChar.getHealth()+
                    "\t\tMoney : " + gameChar.getMoney()
            );
        }
        System.out.println("-------------------------------------------------------");
        System.out.print("Character ID : ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 2 -> initPlayer(new Archer());
            case 3 -> initPlayer(new Knight());
            default -> initPlayer(new Samurai());
        }
    }
    public void printPlayerInfo(){
        System.out.println(
                "Damage : " + this.getDamage() +
                " , Health : " + this.getHealth() +
                " , Money : " + this.getMoney()
        );
    }
    public void initPlayer(GameChar gameChar){
        this.setCharName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setOrijinalHealth(gameChar.getHealth());
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrijinalHealth() {
        return OrijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        OrijinalHealth = orijinalHealth;
    }
}
