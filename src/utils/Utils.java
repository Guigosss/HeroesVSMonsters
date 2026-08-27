package utils;

import java.util.Random;

public final class Utils {

    private static final Random RANDOM = new Random();

    private Utils() {
    }

    public static int diceRolling(int nbSides) {
        return RANDOM.nextInt(nbSides) + 1;
    }

    public static int statModifier(int stat) {
        if (stat < 5) return -1;
        if (stat < 10) return 0;
        if (stat < 15) return 1;
        return 2;
    }
}