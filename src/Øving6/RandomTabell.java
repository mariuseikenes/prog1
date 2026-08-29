package Øving6;

import java.util.Random;

public class RandomTabell {
    public static void main() {
        Random generator = new Random();
        int[] antall = new int[10];
        for (int i = 0; i < 1000; i++) {
            int random = generator.nextInt(10);
            antall[random] += 1;
        }

        System.out.printf("""
                0: %d
                1: %d
                2: %d
                3: %d
                4: %d
                5: %d
                6: %d
                7: %d
                8: %d
                9: %d
                """, antall[0], antall[1], antall[2], antall[3], antall[4], antall[5], antall[6], antall[7], antall[8], antall[9]);
    }
}
