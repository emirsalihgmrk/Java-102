package TechStore;

import java.util.ArrayList;
import java.util.List;

public class Brand implements Comparable<Brand>{
    private int id;
    private String name;
    private static List<Brand> brands = new ArrayList<>();

    static {
        brands.add(new Brand(1,"Apple"));
        brands.add(new Brand(2,"Asus"));
        brands.add(new Brand(3,"Casper"));
        brands.add(new Brand(4,"HP"));
        brands.add(new Brand(5,"Huawei"));
        brands.add(new Brand(6,"Lenovo"));
        brands.add( new Brand(7,"Monster"));
        brands.add( new Brand(8,"Samsung"));
        brands.add(new Brand(9,"Xiaomi"));
    }
    public Brand(int id,String name) {
        this.id = id;
        this.name = name;
    }
    public void printBrands(){
        for (Brand b : brands){
            System.out.println("- "+b.name);
        }
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static List<Brand> getBrands() {
        return brands;
    }

    @Override
    public int compareTo(Brand o){
        return this.name.compareTo(o.name);
    }
}
