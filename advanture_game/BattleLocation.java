package advanture_game;

import java.util.Random;

public abstract class BattleLocation extends Location{
    public static Random rand = new Random();
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(Player player, String name,Obstacle obstacle,String award,int maxObstacle)
    {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    boolean onLocation() {
        if (this.getPlayer().getInventory().getAwards().contains(this.award)){
            System.out.println("You got the award in this location you cant come back here");
            return true;
        }
        int obsNum = getObstacleCount();
        System.out.println("You are in " + this.getName() + " , there are " + obsNum + " " + this.obstacle.getName() + " here");
        System.out.println("<F>ight or <E>scape");
        String select = Game.input.next();
        select = select.toUpperCase();
        while (!select.equals("F") && !select.equals("E")){
            System.out.println("You entered an invalid value");
            select = Game.input.nextLine();
            select = select.toUpperCase();
        }
        if (select.equals("F") && combat(obsNum)){
            System.out.println("You killed all the obstacle in the " + this.getName());
            if (!this.getName().equals("Mine"))System.out.println("You won this award : " + this.getAward());
            this.getPlayer().getInventory().setAwards(this.getAward());
            return true;
        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("You dead");
            return false;
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Player remaining health : " + this.getPlayer().getHealth());
        System.out.println(this.obstacle.getName() + " remaining health : " + this.obstacle.getHealth());
        System.out.println();
    }
    public int getObstacleCount(){
        Random rand = new Random();
        return rand.nextInt(this.maxObstacle) + 1;
    }
    public boolean combat(int ObsCount){
        int OriginalObstacleHealth = this.obstacle.getHealth();
        for (int i = 0 ; i < ObsCount ; i++){
            this.obstacle.setHealth(OriginalObstacleHealth);
            PlayerStats();
            System.out.println();
            ObstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.obstacle.getHealth() > 0){
                System.out.println("<H>it or <E>scape");
                String combatSelect = Game.input.nextLine();
                combatSelect = combatSelect.toUpperCase();
                while (!combatSelect.equals("H") && !combatSelect.equals("E")){
                    combatSelect = Game.input.nextLine();
                    combatSelect = combatSelect.toUpperCase();
                }
                if (combatSelect.equals("H")){
                    hitTurn();
                }else{
                    System.out.println("You escaped");
                    break;
                }
            }
            if (this.obstacle.getHealth() < this.getPlayer().getHealth()){
                System.out.println("-------------------------------------------");
                System.out.println("You defeated the enemy");
                System.out.println("You won " + this.obstacle.getMoney() + " money");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.obstacle.getMoney());
                System.out.println("Your new money : " + this.getPlayer().getMoney());
                System.out.println("-------------------------------------------");
                if (this.getName().equals("Mine"))this.randAward();
            }else{
                return false;
            }
        }
        return true;
    }
    public void randAward(){
        int random = rand.nextInt(100);
        int random2 = rand.nextInt(100);
        if (random <= 14){
            if (random2 <= 19)this.getPlayer().getInventory().setWeapon(Weapon.weapons()[2]);
            else if (random2 <= 39)this.getPlayer().getInventory().setWeapon(Weapon.weapons()[1]);
            else this.getPlayer().getInventory().setWeapon(Weapon.weapons()[0]);
            System.out.println("You got " + this.getPlayer().getInventory().getWeapon().getName());
        } else if (random <= 29) {
            if (random2 <= 19)this.getPlayer().getInventory().setArmor(Armor.armors()[2]);
            else if (random2 <= 49)this.getPlayer().getInventory().setArmor(Armor.armors()[1]);
            else this.getPlayer().getInventory().setArmor(Armor.armors()[0]);
            System.out.println("You got " + this.getPlayer().getInventory().getArmor().getName());
        } else if (random <= 54) {
            int originalMoney = this.getPlayer().getMoney();
            if (random2 <= 19)this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
            else if (random2 <= 49)this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
            else this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
            System.out.println("You got " + (this.getPlayer().getMoney() - originalMoney) + " money");
        } else {
            System.out.println("You couldn't get anything");
        }
    }
    public void PlayerStats(){
        System.out.println("///////////////////////////");
        System.out.println("PLayer Informations\n---------------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : " + this.getPlayer().getDamage());
        System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money : " + this.getPlayer().getMoney());
    }
    public void ObstacleStats(int i){
        System.out.println(i + 1 + "." + this.obstacle.getName() + " Informations\n---------------------------");
        System.out.println("Health : " + this.obstacle.getHealth());
        System.out.println("Damage : " + this.obstacle.getDamage());
        System.out.println("Money : " + this.obstacle.getMoney());
        System.out.println("///////////////////////////");
        System.out.println();
    }
    public void hitTurn(){
        Random rand = new Random();
        int randomTurn = rand.nextInt(2);
        if (randomTurn == 0){
            System.out.println("Obstacle hit");
            int ObstacleDamage = this.obstacle.getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
            if (ObstacleDamage < 0){
                ObstacleDamage = 0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth() - ObstacleDamage);
            afterHit();
            if (this.getPlayer().getHealth() > 0){
                System.out.println("You hit");
                this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getDamage());
                if (this.getPlayer().getHealth() < 0){
                    this.getPlayer().setHealth(0);
                }
                afterHit();
            }
        }else{
            System.out.println("You hit");
            this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getDamage());
            afterHit();
            if (this.obstacle.getHealth() > 0){
                System.out.println("Obstacle hit");
                int ObstacleDamage = this.obstacle.getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                if (ObstacleDamage < 0){
                    ObstacleDamage = 0;
                }
                this.getPlayer().setHealth(this.getPlayer().getHealth() - ObstacleDamage);
                if (this.getPlayer().getHealth() < 0){
                    this.getPlayer().setHealth(0);
                }
                afterHit();
            }
        }
    }
    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}

