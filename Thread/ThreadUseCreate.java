package Thread;

public class ThreadUseCreate extends Thread{
    private String name;
    public ThreadUseCreate(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            System.out.println(this.name + " - " + i);
        }
    }
    public static void main(String[] args) {
        ThreadUseCreate thread1 = new ThreadUseCreate("thread1");
        ThreadUseCreate thread2 = new ThreadUseCreate("thread2");
        thread1.start();
        thread2.start();
    }
}
