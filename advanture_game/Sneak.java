package advanture_game;

import java.util.Random;

public class Sneak extends Obstacle{

    public Sneak() {
        super("Sneak",4,getRandomDamage(),12,0);
    }
    public static int getRandomDamage(){
        Random rand = new Random();
        return rand.nextInt(3,7);
    }
}
