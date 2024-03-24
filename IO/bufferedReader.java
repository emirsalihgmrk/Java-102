package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class bufferedReader {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("test.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            /*String line = bufferedReader.readLine();
            while (line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }*/
            //Şu şekilde de yapılabilir
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
