package OtherSubjects;

public class LambdaExpression {
    public static void main(String[] args) {
        //İçerisinde tek bir metod bulunan interfacelere functional interface denir
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        r1.run();
        //Bunun daha kısa yolu lambdaExpression ile sağlanır
        Runnable r2 = () -> System.out.println("Hello World");
        r2.run();
    }
}
