package fr.kwidz.JeuDeDames.Serveur.Jeu;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by morgane on 23/01/15.
 */
public class Jeu {

    public Damier damier;
    public Joueur joueur1;
    public Joueur joueur2;


    public Jeu(){
        this.damier = new Damier();
        this.joueur1 = new Joueur(true);
        this.joueur2 = new Joueur(false);

    }


    public void jouerUnCoup(Coup monCoup) {
        for (int i = 0; i < monCoup.lesprises.size(); i ++) {

            damier.lesCases[((Point) (monCoup.lesprises.get(i))).x][((Point) (monCoup.lesprises.get(i))).y].effacerPion();

        }
        Piece p = damier.lesCases[monCoup.depart.x][monCoup.depart.y].getPion();
        Piece p2;
        if(p instanceof Pion) {
            p2 = new Pion((Pion) p);
        }
         else {
            p2 = new Dame(p);
        }
        damier.lesCases[monCoup.arrivee.x][monCoup.arrivee.y].pion = p2;
        damier.lesCases[monCoup.depart.x][monCoup.depart.y].effacerPion();

        if(monCoup.isDame){
            damier.lesCases[monCoup.dame.x][monCoup.dame.y].effacerPion();
            damier.lesCases[monCoup.dame.x][monCoup.dame.y].pion=new Dame(p);

        }

        System.out.print(damier);
    }


}
