package Øving7;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Tekstbehandler {
    public String tekst;
    public Tekstbehandler(String tekst) {
        this.tekst = tekst;
    }

    public int antallOrd() {
        String[] splitTekst = this.tekst.split(" ");
        return splitTekst.length;
    }

    public double gjennomsnittligOrdlengd() {
        String[] splitTekst = this.tekst.split(" ");
        int totaleOrd = splitTekst.length;
        AtomicInteger totalOrdlengd = new AtomicInteger();
        Arrays.stream(splitTekst).forEach(ord-> totalOrdlengd.addAndGet(ord.length()));
        return (double) totalOrdlengd.intValue() /totaleOrd;
    }

    public double ordPerPeriode() {
        String[] perioder = this.tekst.split("[.!?:]");
        String[] ord = this.tekst.split(" ");
        return (double) ord.length / perioder.length;
    }

    public void byttUt(String gammeltOrd, String nyttOrd) {
        this.tekst = this.tekst.replaceAll(gammeltOrd, nyttOrd);
    }

    public String getTekst() {
        return tekst;
    }

    public String getTekstStor() {
        return tekst.toUpperCase();
    }
}

class TekstKlientTekstbehandler {
    public static void main() {
        Tekstbehandler behandler = new Tekstbehandler("Hei, jeg heter marius og kommer fra Ørsta, møre og romsdal. Nå studerer jeg i Trondheim ved NTNU. Der studerer jeg dataingeniør (systemutvikling)!");
        System.out.println("Antall ord: " + behandler.antallOrd());
        System.out.println("Avg. lengd på ord: " + behandler.gjennomsnittligOrdlengd());
        System.out.println("Avg. ord per periode: " + behandler.ordPerPeriode());
        behandler.byttUt("marius", "Marius");
        System.out.println("Vanlig tekst: "+behandler.getTekst());
        System.out.println("Stor tekst: "+behandler.getTekstStor());

    }
}