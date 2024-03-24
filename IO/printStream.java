package IO;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class printStream {
    public static void main(String[] args) {
        try {
            PrintStream pStream = new PrintStream("test.txt");
            pStream.print(122342424);//İçerik ne olursa olsun stringe çevirir
            pStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
