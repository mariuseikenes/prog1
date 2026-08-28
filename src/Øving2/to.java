package Øving2;

import java.util.Scanner;

public class to {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Produkt 1 pris:");
        double produkt_1_pris = sc.nextDouble();
        System.out.println("Produkt 1 mengde (gram):");
        double produkt_1_gram = sc.nextInt();


        System.out.println("Produkt 2 pris:");
        double produkt_2_pris = sc.nextDouble();
        System.out.println("Produkt 2 mengde (gram):");
        double produkt_2_gram = sc.nextInt();

        double kg_pris_1 = (produkt_1_pris/produkt_1_gram)*1000;
        double kg_pris_2 = (produkt_2_pris/produkt_2_gram)*1000;

        if (kg_pris_1 < kg_pris_2) {
            System.out.println("Produkt 1 er billigst: "+kg_pris_1+"kr/kg.");
            System.out.println("(Produkt 2 kr/kg: "+kg_pris_2+")");
        } else {
            System.out.println("Produkt 2 er billigst: "+kg_pris_2+"kr/kg.");
            System.out.println("(Produkt 1 kr/kg: "+kg_pris_1+")");
        }
    }
}
