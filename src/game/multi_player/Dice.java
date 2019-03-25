package game.multi_player;

import java.awt.*;
import java.util.Random;

public class Dice {
    public String title;
    Random random = new Random();

    public Dice(String title) {
        this.title = title;
    }

    public int role() {
        return role(3) + 1;
    }

    public int role(int bound) {
        return random.nextInt(bound);
    }
}
