package Øving4;
import java.util.Random;

class Spiller {
    int sumPoeng = 0;
    String navn;
    java.util.Random terning = new java.util.Random();

    public Spiller(String spillerNavn) {
        navn = spillerNavn;
    }

    public int getSumPoeng() {
        return sumPoeng;
    }

    public int kastTerningen() {
        int terningKast = terning.nextInt(6)+1;
        return terningKast;
    }

    public boolean erFerdig() {
        return sumPoeng == 100;
    }
}

public class to {
    public static void main() {
        Spiller spiller1 = new Spiller("A");
        Spiller spiller2 = new Spiller("B");
        int rundenr = 1;

        do {
            System.out.println("Runde "+rundenr+":");
            int spiller1Kast = spiller1.kastTerningen();
            System.out.println(spiller1.navn+" kastet "+spiller1Kast);

            int spiller2Kast = spiller2.kastTerningen();
            System.out.println(spiller2.navn+" kastet "+spiller2Kast);
            if (spiller2.getSumPoeng() > 100) spiller2Kast = -spiller2Kast;
            if (spiller1.getSumPoeng() > 100) spiller1Kast = -spiller1Kast;

            spiller1.sumPoeng += spiller1Kast;
            spiller2.sumPoeng += spiller2Kast;
            System.out.printf("""
                               Nye scores:
                               %s: %d
                               %s: %d
                               """,
                    spiller1.navn, spiller1.getSumPoeng(), spiller2.navn, spiller2.getSumPoeng());

        } while(!spiller1.erFerdig() && !spiller2.erFerdig());

        System.out.println("Spillet er ferdig!");
        System.out.println(spiller1.navn + " har " + spiller1.getSumPoeng() + " poeng.");
        System.out.println(spiller2.navn + " har " + spiller2.getSumPoeng() + " poeng.");
    }
}
