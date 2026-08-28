package Øving1;

import java.util.Scanner;

public class en {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        double CM_TOMMER_FORHOLD = 2.54;

        System.out.println("Antall Tommer: ");
        int tommerLest = sc.nextInt();
        double cm = tommerLest*CM_TOMMER_FORHOLD;

        System.out.println("Kalkulert CM: "+cm);
    }
}
