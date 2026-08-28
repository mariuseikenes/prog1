package Øving2;

import java.util.Scanner;

public class en {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        int aarstall = sc.nextInt();

        if (aarstall%4 == 0) {
            if (aarstall%100 == 0 && aarstall%400 != 0) {
                System.out.println("Dette er ikke et skuddår.");
                return;
            }
            System.out.println("Dette er et skuddår.");
            return;
        }
        System.out.println("Dette er ikke et skuddår.");
    }
}
