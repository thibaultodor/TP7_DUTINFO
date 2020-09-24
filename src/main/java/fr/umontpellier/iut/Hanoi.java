package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Objects;

public class Hanoi implements JeuPuzzle {

    private ArrayList<Integer> tour1;
    private ArrayList<Integer> tour2;
    private ArrayList<Integer> tour3;
    private int taille;

    public Hanoi(int taille) {
        this.taille = taille;
        tour1 = new ArrayList<>();
        for(int i = taille; i!=0; i--){
            tour1.add(i);
        }
        tour2 = new ArrayList<>();
        tour3 = new ArrayList<>();
    }


    public Hanoi(ArrayList<Integer> tour1, ArrayList<Integer> tour2, ArrayList<Integer> tour3, int taille) {
        /*
        Crée un hanoi où la tour 1 (resp. tour 2 et tour 3) contient les entiers de tour1 (resp. tour2 et tour3). Par exemple,
        si tour1 est une ArrayList contenant [3,2,1], et tour2 et tour3 sont des ArrayList vides, alors
        Hanoi(tour1, tour2, tour3) doit créer la même configuration que Hanoi(3).
         */
        this.taille = taille;
        this.tour1 = new ArrayList<>();
        for(int i=0;i<tour1.size();i++) this.tour1.add(tour1.get(i));
        this.tour2 = new ArrayList<>();
        for(int i=0;i<tour2.size();i++) this.tour2.add(tour2.get(i));
        this.tour3 = new ArrayList<>();
        for(int i=0;i<tour3.size();i++) this.tour3.add(tour3.get(i));
    }

    public Hanoi(Hanoi hanoi){
        this(hanoi.tour1,hanoi.tour2,hanoi.tour3,hanoi.taille);
    }

    public boolean estGagnant() {
        boolean tour3correct = false;
        for(int i=0;i<tour3.size()-1;i++){
            if(tour3.get(i) > tour3.get(i+1)){
                tour3correct = true;
            }
        }
        if(tour1.isEmpty() && tour2.isEmpty() && tour3correct){
            return true;
        }
        else{
            return  false;
        }
    }


    @Override
    public ArrayList<Hanoi> genererFils() {
        ArrayList<Hanoi> fils = new ArrayList<>();
        if(!tour1.isEmpty()) {
            if (tour2.isEmpty() || tour1.get(tour1.size() - 1) < tour2.get(tour2.size() - 1)){
                fils.add(mouvement(1,2));
            }
            if (tour3.isEmpty() || tour1.get(tour1.size() - 1) < tour3.get(tour3.size() - 1)) {
                fils.add(mouvement(1, 3));
            }
        }
        if(!tour2.isEmpty()) {
            if (tour1.isEmpty() || tour2.get(tour2.size() - 1) < tour1.get(tour1.size() - 1)){
                fils.add(mouvement(2,1));
            }
            if (tour3.isEmpty() || tour2.get(tour2.size() - 1) < tour3.get(tour3.size() - 1)) {
                fils.add(mouvement(2, 3));
            }
        }
        if(!tour3.isEmpty()) {
            if (tour1.isEmpty() || tour3.get(tour3.size() - 1) < tour1.get(tour1.size() - 1)){
                fils.add(mouvement(3,1));
            }
            if (tour2.isEmpty() || tour3.get(tour3.size() - 1) < tour2.get(tour2.size() - 1)) {
                fils.add(mouvement(3, 2));
            }
        }
        return fils;
    }

    public Hanoi mouvement (int source , int sortie){
        Hanoi tampon = new Hanoi(this);
        if(source == 1 && sortie != 1 && !tour1.isEmpty()){
            if(sortie == 2){
                tampon.tour2.add(tampon.tour1.get((tampon.tour1.size())-1));
            }
            else{
                tampon.tour3.add(tampon.tour1.get((tampon.tour1.size())-1));
            }
            tampon.tour1.remove((tampon.tour1.size())-1);
        }
        if(source == 2 && sortie != 2 && !tour2.isEmpty()){
            if(sortie == 1){
                tampon.tour1.add(tampon.tour2.get((tampon.tour2.size())-1));
            }
            else{
                tampon.tour3.add(tampon.tour2.get((tampon.tour2.size())-1));
            }
            tampon.tour2.remove((tampon.tour2.size())-1);
        }
        if(source == 3 && sortie != 3 && !tour3.isEmpty()){
            if(sortie == 1){
                tampon.tour1.add(tampon.tour3.get((tampon.tour3.size())-1));
            }
            else{
                tampon.tour2.add(tampon.tour3.get((tampon.tour3.size())-1));
            }
            tampon.tour3.remove((tampon.tour3.size())-1);
        }
        return  tampon;
    }

    @Override
    public String toString() {
        String ret;
        ret = "tour1 : ";
        for(int i=0;i<tour1.size();i++) ret = ret + tour1.get(i) + " ";
        ret = ret + "\ntour2 : ";
        for(int i=0;i<tour2.size();i++) ret = ret + tour2.get(i) + " ";
        ret = ret + "\ntour3 : ";
        for(int i=0;i<tour3.size();i++) ret = ret + tour3.get(i) + " ";
        ret = ret + "\n";
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hanoi hanoi = (Hanoi) o;
        return taille == hanoi.taille &&
                Objects.equals(tour1, hanoi.tour1) &&
                Objects.equals(tour2, hanoi.tour2) &&
                Objects.equals(tour3, hanoi.tour3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tour1, tour2, tour3, taille);
    }
}