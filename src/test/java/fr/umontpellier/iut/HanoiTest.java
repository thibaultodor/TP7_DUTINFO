package fr.umontpellier.iut;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;

class HanoiTest {

    @Test
    public void test_hanoi_taille_3() {
        int taille = 3;
        ArrayList<Integer> tour1 = new ArrayList<>();
        ArrayList<Integer> tour2 = new ArrayList<>();
        ArrayList<Integer> tour3 = new ArrayList<>();
        for(int i=taille;i!=0;i--){
            tour3.add(i);
        }

        Hanoi htest = new Hanoi(tour1,tour2,tour3,taille);
        Hanoi h = new Hanoi(taille);

        Contexte contexte = new Contexte(h);
        contexte.resoudre();
        assertEquals(htest,contexte.getSolution().get(contexte.getSolution().size() - 1));
    }

    @Test
    public void test_hanoi_taille_4() {
        int taille = 4;
        ArrayList<Integer> tour1 = new ArrayList<>();
        ArrayList<Integer> tour2 = new ArrayList<>();
        ArrayList<Integer> tour3 = new ArrayList<>();
        for(int i=taille;i!=0;i--){
            tour3.add(i);
        }

        Hanoi htest = new Hanoi(tour1,tour2,tour3,taille);
        Hanoi h = new Hanoi(taille);

        Contexte contexte = new Contexte(h);
        contexte.resoudre();
        assertEquals(htest,contexte.getSolution().get(contexte.getSolution().size() - 1));
    }

    @Test
    public void test_hanoi_taille_5() {
        int taille = 5;
        ArrayList<Integer> tour1 = new ArrayList<>();
        ArrayList<Integer> tour2 = new ArrayList<>();
        ArrayList<Integer> tour3 = new ArrayList<>();
        for(int i=taille;i!=0;i--){
            tour3.add(i);
        }

        Hanoi htest = new Hanoi(tour1,tour2,tour3,taille);
        Hanoi h = new Hanoi(taille);

        Contexte contexte = new Contexte(h);
        contexte.resoudre();
        assertEquals(htest,contexte.getSolution().get(contexte.getSolution().size() - 1));
    }

    @Test
    public void test_hanoi_complexe() {
        int taille = 3;
        ArrayList<Integer> tour1 = new ArrayList<>();
        ArrayList<Integer> tour2 = new ArrayList<>();
        ArrayList<Integer> tour3 = new ArrayList<>();
        tour1.add(1);
        tour2.add(2);
        tour3.add(3);
        Hanoi h = new Hanoi(tour1,tour2,tour3,taille);

        ArrayList<Integer> tour1test = new ArrayList<>();
        ArrayList<Integer> tour2test = new ArrayList<>();
        ArrayList<Integer> tour3test = new ArrayList<>();
        for(int i=taille;i!=0;i--){
            tour3test.add(i);
        }
        Hanoi htest = new Hanoi(tour1test,tour2test,tour3test,taille);

        Contexte contexte = new Contexte(h);
        contexte.resoudre();
        assertEquals(htest,contexte.getSolution().get(contexte.getSolution().size() - 1));
    }

    @Test
    public void test_hanoi_complexev2() {
        int taille = 3;
        ArrayList<Integer> tour1 = new ArrayList<>();
        ArrayList<Integer> tour2 = new ArrayList<>();
        ArrayList<Integer> tour3 = new ArrayList<>();
        tour1.add(3);
        tour1.add(2);
        tour3.add(1);
        Hanoi h = new Hanoi(tour1,tour2,tour3,taille);

        ArrayList<Integer> tour1test = new ArrayList<>();
        ArrayList<Integer> tour2test = new ArrayList<>();
        ArrayList<Integer> tour3test = new ArrayList<>();
        for(int i=taille;i!=0;i--){
            tour3test.add(i);
        }
        Hanoi htest = new Hanoi(tour1test,tour2test,tour3test,taille);

        Contexte contexte = new Contexte(h);
        contexte.resoudre();
        assertEquals(htest,contexte.getSolution().get(contexte.getSolution().size() - 1));
    }

    @Test
    public void test_hanoi_non_complexe() {
        int taille = 3;
        ArrayList<Integer> tour1 = new ArrayList<>();
        ArrayList<Integer> tour2 = new ArrayList<>();
        ArrayList<Integer> tour3 = new ArrayList<>();
        for(int i=taille;i!=0;i--){
            tour3.add(i);
        }
        Hanoi h = new Hanoi(tour1,tour2,tour3,taille);

        ArrayList<Integer> tour1test = new ArrayList<>();
        ArrayList<Integer> tour2test = new ArrayList<>();
        ArrayList<Integer> tour3test = new ArrayList<>();
        for(int i=taille;i!=0;i--){
            tour3test.add(i);
        }
        Hanoi htest = new Hanoi(tour1test,tour2test,tour3test,taille);

        Contexte contexte = new Contexte(h);
        contexte.resoudre();
        assertEquals(htest,contexte.getSolution().get(contexte.getSolution().size() - 1));
    }

    @Test
    public void test_hanoi_vide_faux() {
        int taille = 3;
        ArrayList<Integer> tour1 = new ArrayList<>();
        ArrayList<Integer> tour2 = new ArrayList<>();
        ArrayList<Integer> tour3 = new ArrayList<>();
        Hanoi h = new Hanoi(tour1,tour2,tour3,taille);

        ArrayList<Integer> tour1test = new ArrayList<>();
        ArrayList<Integer> tour2test = new ArrayList<>();
        ArrayList<Integer> tour3test = new ArrayList<>();
        Hanoi htest = new Hanoi(tour1test,tour2test,tour3test,taille);

        Contexte contexte = new Contexte(h);
        contexte.resoudre();
        assertNotEquals(htest,contexte.getSolution());
    }

    @Test
    public void test_hanoi_incorrecte_faux() {
        int taille = 3;
        ArrayList<Integer> tour1 = new ArrayList<>();
        ArrayList<Integer> tour2 = new ArrayList<>();
        ArrayList<Integer> tour3 = new ArrayList<>();
        tour1.add(1);
        tour2.add(2);
        tour3.add(1);
        Hanoi h = new Hanoi(tour1,tour2,tour3,taille);

        ArrayList<Integer> tour1test = new ArrayList<>();
        ArrayList<Integer> tour2test = new ArrayList<>();
        ArrayList<Integer> tour3test = new ArrayList<>();
        for(int i=taille;i!=0;i--){
            tour3test.add(i);
        }
        Hanoi htest = new Hanoi(tour1test,tour2test,tour3test,taille);

        Contexte contexte = new Contexte(h);
        contexte.resoudre();
        assertNotEquals(htest,contexte.getSolution());
    }
}