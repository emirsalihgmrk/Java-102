package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class fileInputStream {
    public static void main(String[] args) {
        try{
            FileInputStream input = new FileInputStream("test.txt");
            //Dosyayı okuma
            int i = input.read();//Dosyadaki ilk karakterin byte değerini döndürür ve bir sonrakine geçer
            input.skip(5);//İlk beş karakteri atlar
            while (i != -1){     //Dosya sonun geldiğinde -1 değerini döndürür
                System.out.print((char) i);
                i = input.read();
                input.available();//Okunabilir karakter sayısını döndürür
            }
            input.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
