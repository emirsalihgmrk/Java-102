package TechStore;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private int id;
    private String name;
    private String price;
    private Brand brand;
    private int storage;
    private double screenSize;
    private int ram;
    private static List<Notebook> notebooks = new ArrayList<>();

    static{
        notebooks.add(new Notebook(1,"HUAWEI Matebook 14","7000.0 TL",Brand.getBrands().get(4),512,14,16));
        notebooks.add(new Notebook(2,"LENOVO V14 IGL","3699.0 TL",Brand.getBrands().get(5),1024,14,8));
        notebooks.add(new Notebook(3,"ASUS Tuf Gaming","8199.0 TL", Brand.getBrands().get(1),2048,15.6,32));
    }

    public Notebook(int id, String name, String price, Brand brand, int storage, double screenSize, int ram) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.storage = storage;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public void printNotebooks(){
        System.out.format("| %2s | %-20s | %-9s | %-9s | %-9s | %-11s | %-9s |%n",
                "ID", "Device Name", "Price", "TechStore.Brand", "Storage", "Screen Size", "RAM");
        for (Notebook e : notebooks){
            System.out.format("| %2d | %-20s | %-9s | %-9s | %-9d | %-11f | %-9d |%n",
                    e.getId(),e.getName(),e.getPrice(),e.getBrand().getName(),e.getStorage(),e.getScreenSize(),e.getRam());
        }
        System.out.println("0 - Quit");
    }

    public static List<Notebook> getNotebooks() {
        return notebooks;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public static void setNotebooks(List<Notebook> notebooks) {
        Notebook.notebooks = notebooks;
    }
}
