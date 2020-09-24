package fr.umontpellier.iut;

public class AppJeuxPuzzle {
    public static void main(String[] args) {
        long debut = System.currentTimeMillis();
        int[][] t = {{1,4,5} ,{0,2,3}, {6,8,7}};
        Taquin tinitial = new Taquin(t);
        System.out.println("Tableau :\n\n"+tinitial.toString()+"\n");
        Contexte contexte = new Contexte(tinitial);
        contexte.resoudre();
        System.out.println(contexte.toString());
        System.out.println("Temps de traitement : "+(System.currentTimeMillis()-debut));
    }
}