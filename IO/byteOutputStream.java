package IO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class byteOutputStream {
    public static void main(String[] args) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String str = "will be added";
        try{
            output.write(str.getBytes());
            output.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
