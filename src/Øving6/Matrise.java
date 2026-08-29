package Øving6;

public class Matrise {
    private final int[][] matrisen;

    public Matrise(int[][] verdier) {
        this.matrisen = kopier(verdier);
    }

    // Lager deep-copy for å holde klassen virkelig immutabel
    private static int[][] kopier(int[][] original) {
        int[][] kopi = new int[original.length][];

        for (int i = 0; i < original.length; i++) {
            kopi[i] = original[i].clone();
        }

        return kopi;
    }

    public void displayMatrisen() {
        for(int r=0; r<matrisen.length; r++) {
            for(int c=0; c<matrisen[r].length; c++)
                System.out.print(matrisen[r][c] + " ");
            System.out.println();
        }
    }

    public int[][] getMatrisen() {
        return kopier(this.matrisen);
    }

    private boolean erMatriseneLikeStore(Matrise to) {
        int y1 = this.matrisen.length;
        int y2 = to.getMatrisen().length;
        if (y1 != y2) return false;

        int x1 = this.matrisen[0].length;
        int x2 = to.getMatrisen()[0].length;
        return x1 == x2;
    }

    public Matrise adder(Matrise nyMatrise) {
       if (!erMatriseneLikeStore(nyMatrise)) {
          return null;
       }
        int[][] nyMatrisenArray = nyMatrise.getMatrisen();
       int[][] resultat = new int[this.matrisen.length][this.matrisen[0].length];

       for (int r = 0; r < this.matrisen.length; r++) {
           for (int c = 0; c < this.matrisen[0].length; c++) {
               resultat[r][c] = this.matrisen[r][c] + nyMatrisenArray[r][c];
           }
       }

        return new Matrise(resultat);
    }

    public Matrise multipliser(Matrise nyMatrise) {
        // Sjekker at matrisene kan multipliseres
        if (this.matrisen[0].length != nyMatrise.getMatrisen().length) {
            System.out.println("Incom,patiblke");
            return null;
        }

        // Den nye matrisen skal ha antall rader til matrise A og antall kolonner til matrise B
        int[][] resultat = new int[this.matrisen.length][nyMatrise.getMatrisen()[0].length];

        for (int i = 0; i < this.matrisen.length; i++) {
            for (int j = 0; j < nyMatrise.getMatrisen()[0].length; j++) {
                for (int k = 0; k < this.matrisen[0].length; k++) {
                    resultat[i][j] += this.matrisen[i][k] * nyMatrise.getMatrisen()[k][j];
                }
            }
        }

        return new Matrise(resultat);
    }

    public Matrise transponer() {
        int[][] transponert = new int[this.matrisen[0].length][this.matrisen.length];

        for (int i = 0; i < this.matrisen.length; i++) {
            for (int j = 0; j < this.matrisen[0].length; j++) {
                transponert[j][i] = this.matrisen[i][j];
            }
        }

        return new Matrise(transponert);
    }
}

class TestKlientMatrise {
    public static void main() {
        int[][] verdierEn = {{1,2,3,4,5}, {1,2,3,4,5}};
        int[][] verdierTo = {{1,2,3,4}, {1,2,3,4}, {1,2,3,4}, {1,2,3,4}, {1,2,3,4}};
        int[][] verdierTre = {{6, 7, 8, 9, 10}, {5, 1, 3, 6, 4}};
        Matrise matriseEn = new Matrise(verdierEn);
        Matrise matriseTo = new Matrise(verdierTo);
        Matrise matriseTre = new Matrise(verdierTre);

        System.out.println("Matrise En: ");
        matriseEn.displayMatrisen();
        System.out.println("Matrise To: ");
        matriseTo.displayMatrisen();
        System.out.println("Matrise Tre: ");
        matriseTre.displayMatrisen();

        System.out.println("Matrise En + Tre: ");
        Matrise adderteMatriser = matriseEn.adder(matriseTre);
        adderteMatriser.displayMatrisen();

        System.out.println("Matrise En*To: ");
        Matrise matriseMultiplikasjon = matriseEn.multipliser(matriseTo);
        matriseMultiplikasjon.displayMatrisen();

        System.out.println("Transponert En: ");
        Matrise transponert = matriseEn.transponer();
        transponert.displayMatrisen();
    }
}