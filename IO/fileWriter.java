package IO;

import java.io.FileWriter;
import java.io.IOException;

public class fileWriter {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("test.txt");
            fileWriter.write("ğüçş");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
