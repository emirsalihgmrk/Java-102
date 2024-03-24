package Thread;

import java.util.ArrayList;
import java.util.List;

public class Exercise implements Runnable{
    private List<Integer> list;
    private List<Integer> odds = new ArrayList<>();
    private List<Integer> evens = new ArrayList<>();
    public Exercise(List<Integer> list){
        this.list = list;
    }
    @Override
    public void run() {
        for (Integer number : list){
            if (number % 2 == 0)addEvenNumber(number);
            else addOddNumber(number);
        }
    }
    public void addOddNumber(int i){
        odds.add(i);
    }
    public void addEvenNumber(int i){
        evens.add(i);
    }

    public List<Integer> getOdds() {
        return odds;
    }

    public List<Integer> getEvens() {
        return evens;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> part1 = new ArrayList<>();
        List<Integer> part2 = new ArrayList<>();
        List<Integer> part3 = new ArrayList<>();
        List<Integer> part4 = new ArrayList<>();
        for(int i = 1;i <= 10000 ;i++){
            if (i <= 2500)part1.add(i);
            else if (i <= 5000)part2.add(i);
            else if (i <= 7500)part3.add(i);
            else part4.add(i);
        }
        Exercise r1 = new Exercise(part1);
        Exercise r2 = new Exercise(part2);
        Exercise r3 = new Exercise(part3);
        Exercise r4 = new Exercise(part4);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        List<Integer> oddNumbers = new ArrayList<>(r1.getOdds());
        oddNumbers.addAll(r2.getOdds());
        oddNumbers.addAll(r3.getOdds());
        oddNumbers.addAll(r4.getOdds());
        List<Integer> evenNumbers = new ArrayList<>(r1.getEvens());
        evenNumbers.addAll(r2.getEvens());
        evenNumbers.addAll(r3.getEvens());
        evenNumbers.addAll(r4.getEvens());
        System.out.println(oddNumbers);
        System.out.println(evenNumbers);
    }
}
