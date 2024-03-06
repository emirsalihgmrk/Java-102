package advanture_game;

public class ToolStore extends Location{
    public ToolStore(Player player) {
        super(player,"Tool Store");
    }

    @Override
    boolean onLocation() {
        System.out.println();
        System.out.println("##########################");
        System.out.println("You are in Tool Store");
        System.out.println("##########################");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("Please enter ID of the tool you want to select");
            System.out.print("1 - Weapons\n2 - Armors\n3 - Quit\nTool ID : ");
            int selectTool = Game.input.nextInt();
            while (selectTool < 1 || selectTool > 3){
                selectTool = Game.input.nextInt();
            }
            switch (selectTool) {
                case 1 -> {
                    printWeapon();
                    buyWeapon();
                    showMenu = false;
                }
                case 2 -> {
                    printArmor();
                    buyArmor();
                    showMenu = false;
                }
                case 3 -> {
                    System.out.println("You logged out");
                    showMenu = false;
                }
            }
        }
        return true;
    }
    public void printWeapon(){
        System.out.println();
        System.out.println("------------------Weapons------------------");
        for (Weapon w:Weapon.weapons()) {
            System.out.println(w.getID() + "\t" + w.getName() + "  < Damage : " + w.getDamage() + " , Price : " + w.getPrice() + " >");
        }
        System.out.println("4 - Quit");
        System.out.println("-------------------------------------------");
    }
    public void buyWeapon(){
        System.out.println("Please enter ID of the Weapons you want to buy");
        int selectWeaponID = Game.input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length + 1){
            System.out.println("Please enter available an ID");
            selectWeaponID = Game.input.nextInt();
        }
        if (selectWeaponID == 4){
            System.out.println("You logged out");
            return;
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if (selectedWeapon != null){
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You don't have enough money for this weapon");
            }else{
                System.out.println("-----------------------------------------------------");
                System.out.println("You bought a " + selectedWeapon.getName());
                this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedWeapon.getPrice());
                System.out.println("You have " + this.getPlayer().getMoney() + " money left");
                System.out.println("Your old weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Your new weapon : " + this.getPlayer().getInventory().getWeapon().getName());
                System.out.println("-----------------------------------------------------");
            }
        }
    }
    public void printArmor(){
        System.out.println();
        System.out.println("------------------Armors-------------------");
        for (Armor a:Armor.armors()) {
            System.out.println(a.getID() + "\t" + a.getName() + "  < Block : " + a.getBlock() + " , Price" + a.getPrice() + " >");
        }
        System.out.println("-------------------------------------------");
    }
    public void buyArmor(){
        System.out.println("Please enter ID of the Armor you want to buy");
        int selectArmorID = Game.input.nextInt();
        while (selectArmorID < 1 || selectArmorID > Armor.armors().length){
            System.out.println("Please enter available an ID");
            selectArmorID = Game.input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
        if (selectedArmor != null){
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You don't have enough money for this armor");
            }else{
                System.out.println("You bought a " + selectedArmor.getName());
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                System.out.println("You have " + this.getPlayer().getMoney() + " money left");
                System.out.println("Your old armor : " + this.getPlayer().getInventory().getArmor().getName());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Your new armor : " + this.getPlayer().getInventory().getArmor().getName());
            }
        }
    }
}
