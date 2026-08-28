package Øving1;

import java.util.Scanner;

public class tre {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Antall sekunder: ");
        int sekunder = sc.nextInt();
        double hele_timer = Math.floor(sekunder/3600.00);
        double hele_minutter = Math.floor((sekunder-hele_timer*3600)/60.00);
        double resterende_sekunder = sekunder-(hele_timer*3600)-(hele_minutter*60);

        System.out.println("Timer: "+hele_timer);
        System.out.println("Minutter: "+hele_minutter);
        System.out.println("Sekunder: "+resterende_sekunder);
    }
}
