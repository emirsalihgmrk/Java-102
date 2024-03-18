package TechStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        User user = new User();
        System.out.println("Welcome to tech store");
        boolean isFinish = false;
        while (!isFinish){
            System.out.println("Please select the action you want to perform");
            System.out.println("----------------------");
            System.out.println("""
                1-See your devices
                2-Notebook actions
                3-Mobile phone actions
                4-Quit"""
            );
            System.out.println("----------------------");
            System.out.print("ID : ");
            int action = inp.nextInt();
            switch (action) {
                case 1 -> user.printDevices();
                case 2 -> {
                    System.out.println("Select the device you want to buy");
                    while (true) {
                        Notebook.getNotebooks().get(0).printNotebooks();
                        System.out.print("ID : ");
                        int number = inp.nextInt();
                        if (number == 0) break;
                        user.addNotebook(Notebook.getNotebooks().get(number - 1));
                        System.out.println("You bought a " + Notebook.getNotebooks().get(number - 1).getName());
                    }
                }
                case 3 -> {
                    System.out.println("Select the device you want to buy");
                    while (true) {
                        MobilePhone.getMobilePhones().get(0).printMobilePhones();
                        System.out.print("ID : ");
                        int number = inp.nextInt();
                        if (number == 0) break;
                        user.addMobilePhone(MobilePhone.getMobilePhones().get(number - 1));
                        System.out.println("You bought a " + MobilePhone.getMobilePhones().get(number - 1).getName());
                    }
                }
                case 4 -> isFinish = true;
            }
        }
    }
}
