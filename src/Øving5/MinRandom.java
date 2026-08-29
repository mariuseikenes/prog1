package Øving5;

import java.util.Random;

public class MinRandom {
    Random randomGenerator = new Random();

    public int nesteHeltall(int nedre, int ovre) {
        return randomGenerator.nextInt(ovre-nedre+1)+nedre;
    }

    public double nesteDesimaltall(double nedre, double ovre) {
        return nedre + (randomGenerator.nextDouble() * (ovre-nedre));
    }
}

class TestKlientRandom {
    public static void main() {
       MinRandom randomObjekt = new MinRandom();

       for (int i = 0; i < 20; i++) {
           System.out.println("Tilfelding int: " + randomObjekt.nesteHeltall(3, 6));
       }
       for (int i = 0; i < 20; i++ ) {
           System.out.println("Tilfelding double: " + randomObjekt.nesteDesimaltall(3, 6));
       }
    }
}