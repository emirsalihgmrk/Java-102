package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class objectInputStream {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("car.txt");
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);
            Car newCar = (Car) objectStream.readObject();
            System.out.println(newCar.getBrand());
            System.out.println(newCar.getModel());
            inputStream.close();
            objectStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
