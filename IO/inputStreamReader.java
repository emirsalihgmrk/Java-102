package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class inputStreamReader {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("test.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF8");//Karakter setini belirtebiliyoruz
            System.out.println(inputStreamReader.getEncoding());
            int i = inputStreamReader.read();
            while (i != -1){
                System.out.print((char) i);
                i = inputStreamReader.read();
            }
            inputStream.close();
            inputStreamReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
