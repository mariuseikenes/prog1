package Øving5;

public class Broekkalkulator {
    int teller;
    int nevner;

    public Broekkalkulator (int teller, int nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException();
        }
        this.teller = teller;
        this.nevner = nevner;
    }

    public Broekkalkulator (int teller) {
        this.teller = teller;
        this.nevner = 1;
    }

    public void summer(int nyTeller, int nyNevner) {
        this.teller = this.teller * nyNevner + nyTeller * this.nevner;
        this.nevner = this.nevner * nyNevner;
    }

    public void subtraher(int nyTeller, int nyNevner) {
        this.teller = this.teller*nyNevner - nyTeller*this.nevner;
        this.nevner = this.nevner * nyNevner;
    }

    public void multipliser(int nyTeller, int nyNevner) {
        this.teller *= nyTeller;
        this.nevner *= nyNevner;
    }

    public void divider(int nyTeller, int nyNevner) {
        this.teller *= nyNevner;
        this.nevner *= nyTeller;
    }

    public int getTeller() {
        return this.teller;
    }

    public int getNevner() {
        return nevner;
    }

}

class TestKlientBroek {
    public static void main() {
        Broekkalkulator calc = new Broekkalkulator(3, 4);
        calc.multipliser(4, 5);
        System.out.println("Ny brøk: "+calc.getTeller()+"/"+calc.getNevner());
    }
}
