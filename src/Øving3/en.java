package Øving3;

import java.util.Scanner;

public class en {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Første tall: ");
        int tall1 = 0;
        boolean tall1Gyldig = false;
        do {
            try {
                tall1 = sc.nextInt();
                tall1Gyldig = true;
            } catch (Exception e) {
                System.out.println("Ugyldig input - prøv igjen. Input må vere tall.");
                sc.next();
            }
        } while (!tall1Gyldig);

        System.out.println("Andre tall: ");
        int tall2 = 0;
        boolean tall2Gyldig = false;
        do {
            try {
                tall2 = sc.nextInt();
                tall2Gyldig = true;
            } catch (Exception e) {
                System.out.println("Ugyldig input - prøv igjen. Input må vere tall.");
                sc.next();
            }
        } while (!tall2Gyldig);

        int lavest = Math.min(tall1, tall2);
        int hoyest = Math.max(tall1, tall2);
        for (int i = lavest; i <= hoyest; i++) {
            System.out.println(i+"-gangen:");
            for (int j = 1; j <= 10; j++) {
                System.out.println(i+"*"+j+" = "+i*j);
            }
        }
    }
}
