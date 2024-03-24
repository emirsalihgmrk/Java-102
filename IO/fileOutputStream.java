package IO;

import java.io.IOException;
import java.io.FileOutputStream;

public class fileOutputStream {
    public static void main(String[] args) {
        String str = "will be added";
        try{
            FileOutputStream output = new FileOutputStream("test.txt",true);//true parametresi verilmezse test.txt dosaysı varsa üzerine yenisini oluşturur.Dosyanın içeriği silinir
            byte[] strByte = str.getBytes();//Stringdeki harflerin sayı byte değerlerini dizi şeklinde döndürür
            output.write(strByte);
            output.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
