package Øving7;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class NyString {
    private final String tekst;

    public NyString(String input) {
        this.tekst = input;
    }

    public String forkort() {
        String[] oppdelt = this.tekst.split(" ");

        String forkortelse = "";
        for (int i = 0; i < oppdelt.length; i++) {
            forkortelse += oppdelt[i].charAt(0);
        }

        return forkortelse;
    }

    public String fjern(Character bokstav) {
        String kopi = tekst;

        return kopi.replaceAll(bokstav.toString(), "");
    }

    public String getTekst() {
        return tekst;
    }
}

class TestKlientNyString {
    public void main() {
        NyString streng = new NyString("Testinput her, tester greier.");
        System.out.println(streng.forkort());
        System.out.println(streng.fjern('e'));
        System.out.println(streng.getTekst());
    }
}