package Monopoly;

import java.util.Random;

public class Dice {

    private Random random;

    public Dice(Random random) {
        this.random = random;
    }

    public Dice() {
        random = new Random();
    }

    public int getRoll() {
        return random.nextInt(6) + 1;
    }
}