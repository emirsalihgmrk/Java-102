package IO;

import java.io.*;

public class bufferedOutputStream {
    public static void main(String[] args) {
        String str = "will be added";
        try {
            FileOutputStream outputStream = new FileOutputStream("test.txt");
            BufferedOutputStream bufferedStream = new BufferedOutputStream(outputStream);
            bufferedStream.write(str.getBytes());
            bufferedStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
