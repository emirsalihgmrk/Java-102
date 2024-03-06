package advanture_game;

import java.util.Random;

public class Mine extends BattleLocation{
    public Mine(Player player) {
        super(player,"Mine",new Sneak(),"",5);
    }
}
