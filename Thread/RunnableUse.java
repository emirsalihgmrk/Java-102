package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableUse implements Runnable{
    private boolean isRun = true;
    private int counter;
    private final Object LOCK = new Object();
    public RunnableUse(){
        this.counter = 0;
    }

    @Override
    public void run() {
        while (isRun){
            try {
                Thread.sleep(1000L);//program 1 saniyeliğine bekletilir
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (LOCK){//Threadlerin birbiriyle çakışarak aynı değerleri almasını önlüyoruz
                System.out.println(Thread.currentThread().getName() + " => " + this.counter++);
            }
        }
    }
    public void stop(){
        this.isRun = false;
    }
    public static void main(String[] args) throws InterruptedException {
        RunnableUse r1 = new RunnableUse();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(5000L);
        r1.stop();
        //ThreadPooling
        RunnableUse r2 = new RunnableUse();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10;i++){
            pool.execute(r2);
        }
        Thread.sleep(5000L);
        r2.stop();
        pool.close();
    }
}
