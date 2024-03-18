package TechStore;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone extends Notebook {
    private int camera;
    private double battery;
    private String color;
    private static List<MobilePhone> mobilePhones = new ArrayList<>();

    static{
        mobilePhones.add(new MobilePhone(1,"SAMSUNG GALAXY A51","3199.0 TL", Brand.getBrands().get(7),128,6.5,6,32,4000,"black"));
        mobilePhones.add(new MobilePhone(2,"iPhone 11 64 GB","7379.0 TL", Brand.getBrands().get(0),64,6.1,6,5,3046,"blue"));
        mobilePhones.add(new MobilePhone(3,"Redmi Note 10 Pro 8GB","4012.0 TL", Brand.getBrands().get(8),128,6.5,12,35,4000,"white"));
    }

    public MobilePhone(int id, String name, String price, Brand brand, int storage, double screenSize, int ram, int camera, double battery, String color) {
        super(id, name, price, brand, storage, screenSize, ram);
        this.camera = camera;
        this.battery = battery;
        this.color = color;
    }

    public void printMobilePhones(){
        System.out.format("| %2s | %-20s | %-9s | %-9s | %-9s | %11s | %-9s | %-9s | %-9s | %-9s |%n",
                "ID", "Device Name", "Price", "TechStore.Brand", "Storage", "Screen Size", "Camera","Battery","RAM","Color");
        for (MobilePhone e : mobilePhones){
            System.out.format("| %2s | %-20s | %-9s | %-9s | %-9d | %-11f | %-9d | %-9f | %-9d | %-9s |%n",
                    e.getId(),e.getName(),e.getPrice(),e.getBrand().getName(),e.getStorage(),e.getScreenSize(),e.getCamera(),e.getBattery(),e.getRam(),e.getColor());
        }
        System.out.println("0 - Quit");
    }

    public static List<MobilePhone> getMobilePhones() {
        return mobilePhones;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void setMobilePhones(List<MobilePhone> mobilePhones) {
        MobilePhone.mobilePhones = mobilePhones;
    }
}
