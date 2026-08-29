package Øving6;

import java.util.*;
import java.util.stream.IntStream;

public class TekstAnalyse {
    int[] antallTegn = new int[30];
    String tekst;
    // ÆØÅ/æøå
    Set<Integer> unntak = Set.of(198, 230, 216, 248, 197, 229);

    public TekstAnalyse(String tekst) {
        this.tekst = tekst;

        // Looper gjennom kvar char i tekst
        for (int i = 0; i < tekst.length(); i++) {
            int aasciNumber = (int) (tekst.charAt(i));

            // Ser etter unntak frå den vanlege ascii-rekka (æøå)
            if (unntak.contains(aasciNumber)) {
                if (aasciNumber == 198 || aasciNumber == 230) {
                    antallTegn[26] += 1;
                } else if (aasciNumber == 216 || aasciNumber == 248) {
                    antallTegn[27] += 1;
                } else if (aasciNumber == 197 || aasciNumber == 229) {
                    antallTegn[28] += 1;
                }

                // Kan ellers rekne ut kva char ved å lese aascii-nummer, og trekke frå for å putte det på rett plass i antallTegn
            } else if (aasciNumber > 64 && aasciNumber < 91) {
                int alfabetIndex = aasciNumber - 65;
                antallTegn[alfabetIndex] += 1;
            } else if (aasciNumber > 96 && aasciNumber < 123) {
                int alfabetIndex = aasciNumber - 97;
                antallTegn[alfabetIndex] += 1;
            } else {
                antallTegn[29] += 1;
            }
        }
    }

    public int length() {
        return this.tekst.length();
    }

    public int percentageNonLetters() {
        return Math.round(((float) antallTegn[29] /this.length())*100);
    }

    public int antallAvBokstav(char bokstav) {
        int counter = 0;

        // gjer bokstav + tekst lowercase for enklare samanlikning
        char lowercaseBokstav = Character.toLowerCase(bokstav);
        String lowercase = this.tekst.toLowerCase();

        // Loopar gjennom og teller antall av bokstav
        for (int i = 0; i < lowercase.length(); i++) {
            if (lowercase.charAt(i) == lowercaseBokstav) {
                counter++;
            }
        }

        return counter;
    }

    public List<Character> mestVanligeBokstaver() {
        // Fjerner siste element fra array for å ikke telle tegn og mellomrom
        int[] arrayUtenAndreTegn = Arrays.stream(this.antallTegn, 0, 29).toArray();

        // Finner ut hva det høyeste antall av den vanligste bokstaven er
        OptionalInt maxCount = Arrays.stream(arrayUtenAndreTegn).max();
        String referanseString = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        List<Character> bokstaverMedMax = new ArrayList<Character>();

        // Finner alle bokstaver med samme antall som max
        for (int i = 0; i < 29; i++) {
            if (arrayUtenAndreTegn[i] == maxCount.getAsInt()) {
                char relevantCharacter = referanseString.charAt(i);
                bokstaverMedMax.add(relevantCharacter);
            }
        }

        return bokstaverMedMax;
    }
}

class TestKlient {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Input text: ");
            String input = sc.nextLine();
            TekstAnalyse analyse = new TekstAnalyse(input);
            System.out.println("Lengde: "+analyse.length());
            System.out.println("Prosent ikkje-bokstavar: "+analyse.percentageNonLetters()+"%");

            System.out.println("Vanligste bokstaver: "+analyse.mestVanligeBokstaver().toString());
            System.out.println("Velg bokstav å telle: ");
            String bokstav = sc.nextLine();
            System.out.printf("Antall av bokstav %s: %d \n", bokstav.charAt(0), analyse.antallAvBokstav(bokstav.charAt(0)));
        } while(true);

    }
}