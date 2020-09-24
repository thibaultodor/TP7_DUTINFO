package fr.umontpellier.iut;

import java.util.ArrayList;

public interface JeuPuzzle<P>{
    boolean estGagnant();
    ArrayList<P> genererFils();
}