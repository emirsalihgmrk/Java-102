package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class fileReader {
    public static void main(String[] args) {
        // Bu sınıfla dosya oluşturma ve reader oluşturma işlemlerini tek seferde yapabiliyoruz
        try {
            FileReader fileReader = new FileReader("test.txt", Charset.forName("UTF8"));
            int i = fileReader.read();
            while (i != 0){
                System.out.println((char) i);
                i = fileReader.read();
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
