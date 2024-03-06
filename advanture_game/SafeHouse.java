package advanture_game;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        if (this.getPlayer().getInventory().getAwards().contains("Food")&&this.getPlayer().getInventory().getAwards().contains("Firewood")&&this.getPlayer().getInventory().getAwards().contains("water")){
            return false;
        }
        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
        System.out.println("##########################");
        System.out.println("You are in Safe House");
        System.out.println("Your health is renewed");
        System.out.println("##########################");
        return true;
    }
}
