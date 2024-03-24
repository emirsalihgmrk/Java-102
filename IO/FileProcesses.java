package IO;

import java.io.File;
import java.io.IOException;

public class FileProcesses {
    public static void main(String[] args) {
        File file = new File("test.txt");

        //dosya oluşturma işlemi try catch yapısı ile gerçekleştirilir.Geriye boolean bir değer  döner
        try{
            boolean isCreated = file.createNewFile();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        //Silme işlemini ise doğrudan yapabiliriz
        //boolean isDeleted = file.delete();

        //Klasör oluşturma işlemi
        //boolean isCreated = file.mkdir();

        //Dosyaları listeleme
        String[] fileList = file.list();

    }
}
