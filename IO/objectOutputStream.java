package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class objectOutputStream {
    public static void main(String[] args) {
        Car c1 = new Car("Audi","a3");
        try {
            FileOutputStream outputFile = new FileOutputStream("car.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(outputFile);
            outputStream.writeObject(c1);
            outputFile.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
