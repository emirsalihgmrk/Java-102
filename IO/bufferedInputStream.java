package IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class bufferedInputStream {
    //Daha hızlı çalışır ve hafızada daha az yer kaplar genelde büyük dosyalarda kullanılır
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("test.txt");
            BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
            int i = inputStream.read();
            while (i != -1){
                System.out.print((char) i);
                i = inputStream.read();
            }
            inputStream.close();
            bufferedStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
