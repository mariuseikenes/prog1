package Øving1;

import java.util.Scanner;

public class to {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Antall timer: ");
        int timer = sc.nextInt();
        System.out.println("Antall minutter: ");
        int minutter = sc.nextInt();
        System.out.println("Antall sekunder: ");
        int sekunder = sc.nextInt();

        int totale_sekunder = timer*3600 + minutter*60 + sekunder;

        System.out.println("Totalt sekunder: " + totale_sekunder);
    }
}
