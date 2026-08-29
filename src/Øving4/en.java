package Øving4;

import java.util.Scanner;

class Valuta {
    String valutaNavn;
    double verdiIKroner;
    public Valuta(double verdi, String navn) {
        valutaNavn = navn;
        verdiIKroner = verdi;
    }

    public double convertToNOK(double antall) {
        return Math.round(antall*verdiIKroner * 100.0) / 100.0;
    }
}

public class en {
    public static void main() {
        Valuta dollar = new Valuta(9.37, "USD");
        Valuta euro = new Valuta(10.87, "EUR");
        Valuta pund = new Valuta(12.71, "GBP");

        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Velkommen! Kva for ein valuta vil du konvertere til norske kroner?
                1: Amerikanske Dollar (USD)
                2: Euro (EUR)
                3: Britisk Pund (GBP)
                4: Avslutt
                Tast eit nummer for å begynne.
                """
        );

        int choice = 0;
        boolean validChoice = false;
        do {
            try {
                choice = sc.nextInt();
                validChoice = true;
            } catch (Exception e) {
                System.out.println("Ugyldig input - prøv igjen. Input må vere tall.");
                sc.next();
            }
        } while (!validChoice);

        Valuta chosenValuta;

        switch (choice) {
            case 4:
                System.out.println("4 valgt. Avsluttar.");
                return;
            case 1:
                System.out.println("Du valgte Dollar.");
                chosenValuta = dollar;
                break;
            case 2:
                System.out.println("Du valgte Euro.");
                chosenValuta = euro;
                break;
            case 3:
                System.out.println("Du valgte Britiske Pund.");
                chosenValuta = pund;
                break;
            default:
                System.out.println("Fann ingen valuta ved dette valget. Avsluttar.");
                return;
        }

        System.out.println("Kor mange "+chosenValuta.valutaNavn+" skal du konvertere?");

        double amount = 0;
        boolean validAmount = false;
        do {
            try {
                amount = sc.nextDouble();
                validAmount = true;
            } catch (Exception e) {
                System.out.print("Ugyldig input. Input må være eit tal, der desimal skrivast med punktum.");
                sc.next();
            }
        } while (!validAmount);

        System.out.println(amount + " " + chosenValuta.valutaNavn + " tilsvarar " + chosenValuta.convertToNOK(amount) + " norske kroner.");

    }
}
