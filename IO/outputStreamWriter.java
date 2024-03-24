package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class outputStreamWriter {
    public static void main(String[] args) {
        String str = "ğüçşö";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"UTF8");
            outputStreamWriter.write(str);//Karakterleri byte türüne çevirmek gerekmiyor
            outputStreamWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
