package GenericUse;

public class Main {
    public static void main(String[] args) {
        Mylist<String> strMylist = new Mylist<>();
        strMylist.add("apple");
        strMylist.add("orange");
        strMylist.add("banana");
        strMylist.add("strawberry");
        strMylist.add("peach");
        strMylist.add("kiwi");
        strMylist.add("watermelon");
        strMylist.add("melon");
        strMylist.add("cherry");
        strMylist.add("lemon");
        strMylist.add("kiwi");
        strMylist.add("avocado");
        strMylist.remove(1);
        strMylist.set(0,"blueberry");
        System.out.print("Liste\n-------\n");
        System.out.println(strMylist.toString());
        System.out.println("4.eleman : " + strMylist.get(3));;
        System.out.println("Dizi boyutu : " + strMylist.getCapacity());
        System.out.println("Dizideki eleman sayısı : " + strMylist.size());
        System.out.println("Kiwi elemanının indexi : " + strMylist.indexOfData("kiwi"));
        System.out.println("Dizideki son kiwi elemanının indexi: " + strMylist.lastIndexOfData("kiwi"));
        System.out.print("\n5 ve 8 index aralığındaki değerler\n------------------------------------------\n");
        System.out.println(strMylist.sublist(5,8).toString());
        System.out.println("Dizide avocado elemanı var mı : " + strMylist.contains("avocado"));
        System.out.println("Dizide grape elemanı var mı :" + strMylist.contains("grape"));
        System.out.println("\nDizi boş mu : " + strMylist.isEmpty());
        strMylist.clear();
        System.out.println("Dizi elemanları silindi");
        System.out.println("Dizi boş mu : " + strMylist.isEmpty());

    }
}
