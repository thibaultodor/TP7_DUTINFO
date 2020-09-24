package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Taquin implements JeuPuzzle{
    private int[][] tableau;

    public Taquin(int[][] tableau) {
        this.tableau = tableau;
    }

    public boolean estGagnant() {
        int nbvoulu = 1;
        int nbmax = tableau.length * tableau[0].length;
        for (int[] ints : tableau) {
            for (int anInt : ints) {
                if(anInt != nbvoulu){
                    return false;
                }
                nbvoulu++;
                if (nbvoulu == nbmax){
                    nbvoulu = 0;
                }
            }
        }
        return true;
    }

    public ArrayList<Taquin> genererFils() {
        int[] trou = trouverTrou();
        int ligne = trou[0];
        int colonne = trou[1];
        ArrayList<Taquin> liste = new ArrayList<>();
        if(ligne>0){
            int[][] tableauFils = copieProfonde(tableau);
            tableauFils[ligne][colonne] = tableauFils[ligne-1][colonne];
            tableauFils[ligne-1][colonne] = 0;
            liste.add(new Taquin(tableauFils));
        }
        if(ligne<tableau.length-1){
            int[][] tableauFils = copieProfonde(tableau);
            tableauFils[ligne][colonne] = tableauFils[ligne+1][colonne];
            tableauFils[ligne+1][colonne] = 0;
            liste.add(new Taquin(tableauFils));
        }
        if(colonne>0){
            int[][] tableauFils = copieProfonde(tableau);
            tableauFils[ligne][colonne] = tableauFils[ligne][colonne-1];
            tableauFils[ligne][colonne-1] = 0;
            liste.add(new Taquin(tableauFils));
        }
        if(colonne<tableau[0].length-1){
            int[][] tableauFils = copieProfonde(tableau);
            tableauFils[ligne][colonne] = tableauFils[ligne][colonne+1];
            tableauFils[ligne][colonne+1] = 0;
            liste.add(new Taquin(tableauFils));
        }
        return liste;
    }

    public int[][] copieProfonde(int[][] tableau) {
        int [][] tableauFils = new int[tableau.length][tableau[0].length];
        for (int i = 0; i < tableau.length; i++) {
            for (int i1 = 0; i1 < tableau[0].length; i1++) {
                tableauFils[i][i1]=tableau[i][i1];
                }
            }
        return tableauFils;
    }

    //retourne un tableau [i,j] si tableau[i][j]==0
    public int[] trouverTrou() {
        for (int i = 0; i < tableau.length; i++) {
            for (int i1 = 0; i1 < tableau[0].length; i1++) {
                if (tableau[i][i1] == 0) {
                    int[] tab = {i,i1};
                    return tab;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String res = "";
        for (int[] ints : tableau) {
            for (int anInt : ints) {
                res = res + (anInt + " ");
            }
            res = res + "\n";
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Taquin taquin = (Taquin) o;
        return Arrays.deepEquals(tableau, taquin.tableau);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tableau);
    }
}