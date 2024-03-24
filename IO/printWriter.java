package IO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class printWriter {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter("test.txt");
            writer.write(String.valueOf(123345));
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
