package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class Contexte {

    private JeuPuzzle jeuInitial;
    private ArrayList<JeuPuzzle> solution;

    public Contexte(JeuPuzzle jeuInitial) {
        this.jeuInitial = jeuInitial;
        solution = new ArrayList<>();
    }

    public void resoudre() {
        Couple couple = new Couple(jeuInitial,null);
        ArrayList<Couple> frontiere = new ArrayList<>();
        HashSet<JeuPuzzle> dejasvu = new HashSet<>();
        couple.mettreAJour(frontiere,dejasvu);
        solution = new ArrayList<>();
        while(!frontiere.isEmpty()){
            if (couple.getjeu().estGagnant()){
                solution = couple.getListeDeMouvements();
                break;
            }
            couple = frontiere.remove(0);
            couple.mettreAJour(frontiere,dejasvu);
        }
    }

    public ArrayList<JeuPuzzle> getSolution() {
        return solution;
    }

    @Override
    public String toString() {
        String res = "Solution :\n\n";
        for(int i=0;i<solution.size();i++){
            res = res + solution.get(i).toString();
            res = res + "\n";
        }
        return res;
    }
}
