package TechStore;

import TechStore.MobilePhone;
import TechStore.Notebook;

import java.util.ArrayList;

public class User {
    private ArrayList<Notebook> notebooksList = new ArrayList<>();
    private ArrayList<MobilePhone> mobilePhonesList = new ArrayList<>();

    public void printDevices(){
        System.out.println("##########\nNotebooks\n##########");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.format("| %2s | %-20s | %-9s | %-9s | %-9s | %-9s | %-9s |%n",
                            "ID", "Device Name", "Price", "TechStore.Brand", "Storage", "Screen Size", "RAM");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Notebook e : notebooksList){
            System.out.format("| %2d | %-20s | %-9s | %-9s | %-9d | %-9f | %-9d |%n",
                    e.getId(),e.getName(),e.getPrice(),e.getBrand().getName(),e.getStorage(),e.getScreenSize(),e.getRam());
        }
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("##########\nMobilePhones\n##########");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %2s | %-20s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s |%n",
                "ID", "Device Name", "Price", "TechStore.Brand", "Storage", "Screen Size", "Camera","Battery","RAM","Color");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        for (MobilePhone e : mobilePhonesList){
            System.out.format("| %2s | %-20s | %-9s | %-9s | %-9d | %-9f | %-9d | %-9f | %-9d | %-9s |%n",
                    e.getId(),e.getName(),e.getPrice(),e.getBrand().getName(),e.getStorage(),e.getScreenSize(),e.getCamera(),e.getBattery(),e.getRam(),e.getColor());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
    }

    public void addNotebook(Notebook e){
        notebooksList.add(e);
    }

    public void addMobilePhone(MobilePhone e){
        mobilePhonesList.add(e);
    }
    public ArrayList<Notebook> getNotebooksList() {
        return notebooksList;
    }
    public ArrayList<MobilePhone> getMobilePhonesList() {
        return mobilePhonesList;
    }
}
