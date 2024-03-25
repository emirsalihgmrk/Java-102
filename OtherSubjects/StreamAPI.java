package OtherSubjects;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamAPI {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(12);
        list.add(3);
        list.add(89);
        list.add(25);
        list.add(44);
        list.add(100);
        list.add(7);
        list.add(63);
        //Aşağıda listeyi distinct ile tekrar eden verileri hariç tutarak sorted metodu ile büyükten küçüğe sıraladık
        //Filter metodu ile 25 ten küçük elemanları hariç tutarak limit ile ilk 5 elemanı alıp foreach ile yazdırdık
        list.stream().distinct().sorted(Comparator.reverseOrder()).filter(i -> i > 12).limit(5).forEach(i -> System.out.println(i));
        //Listede 44 e sşit olan elmean var mı
        System.out.println(list.stream().anyMatch(i -> i == 44));
        //Listedeki bütün elemanlar 3 den küçük mü
        System.out.println(list.stream().allMatch(i -> i > 3));
        //Listedeki bütün elemanlar 100 den küçükmü
        System.out.println(list.stream().noneMatch(i -> i > 100));
    }
}
