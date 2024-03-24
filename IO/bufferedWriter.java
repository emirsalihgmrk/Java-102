package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class bufferedWriter {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("test.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("asdğşlkjhç");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
