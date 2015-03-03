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


    public void jouerUnCoup(ArrayList lesCoups) {
        for (int i = 0; i < lesCoups.size(); i += 2) {
            Piece p = damier.lesCases[((Point) (lesCoups.get(i))).x][((Point) (lesCoups.get(i))).y].getPion();
            Piece p2 = new Pion((Pion) p);
            damier.lesCases[((Point) (lesCoups.get(i + 1))).x][((Point) (lesCoups.get(i + 1))).y].pion = p2;
            damier.lesCases[((Point) (lesCoups.get(i))).x][((Point) (lesCoups.get(i))).y].effacerPion();

        }
        System.out.print(damier);
    }


}
