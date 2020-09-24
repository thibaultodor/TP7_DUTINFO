package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.HashSet;

@SuppressWarnings("Duplicates")
public class Couple {

    private JeuPuzzle jeuPuzzle;
    private Couple predecesseur;

    public Couple(JeuPuzzle jeuPuzzle, Couple predecesseur) {
        this.jeuPuzzle = jeuPuzzle;
        this.predecesseur = predecesseur;
    }

    public void mettreAJour(ArrayList<Couple> frontiere, HashSet<JeuPuzzle> dejaVus) {
        ArrayList<JeuPuzzle> fils = this.jeuPuzzle.genererFils();
        dejaVus.add(this.jeuPuzzle);
        for (int i = 0;i<fils.size();i++){
            if(!dejaVus.contains(fils.get(i))){
                Couple tmp = new Couple(fils.get(i),this);
                frontiere.add(tmp);
            }
        }
    }

    public ArrayList<JeuPuzzle> getListeDeMouvements() {
        ArrayList<JeuPuzzle> liste = new ArrayList<>();
        if(predecesseur==null){
            liste.add(jeuPuzzle);
            return liste;
        }
        liste = predecesseur.getListeDeMouvements();
        liste.add(jeuPuzzle);
        return liste;
    }

    public JeuPuzzle getjeu() {
        return jeuPuzzle;
    }
}
