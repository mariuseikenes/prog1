package Øving3;

import java.util.Scanner;

public class to {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nytt tall å sjekke: ");
            int numberToCheck = sc.nextInt();
            if (numberToCheck < 2) {
                System.out.println("Tall må være større en 1 for å være primtall.");
            }
            for (int i = 2; i <= numberToCheck; i++) {
                if (i == numberToCheck) {
                    System.out.println(numberToCheck + " er primtall.");
                    break;
                }
                if (numberToCheck%i == 0) {
                    System.out.println(numberToCheck+" er ikke et primtall.");
                    break;
                }
            }
        } while (true);
    }
}
