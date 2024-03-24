package IO;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class byteInputStream {
    public static void main(String[] args) {
        byte[] bytes = {1,10,98,17,65,12};
        try{
            ByteArrayInputStream input = new ByteArrayInputStream(bytes);
            int i = input.read();
            while (i != -1){
                System.out.println((char) i);
                i = input.read();
            }
            input.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
