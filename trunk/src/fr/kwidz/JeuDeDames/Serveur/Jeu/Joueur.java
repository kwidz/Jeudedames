package fr.kwidz.JeuDeDames.Serveur.Jeu;

import java.awt.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by kwidz on 18/02/15.
 */
public class Joueur {

    private boolean joueur1;

    public Joueur(boolean joueur1){
        this.joueur1 = joueur1;
    }

    public ArrayList jouerUnCoup(String message) {
        ArrayList lesCoups = new ArrayList();
        StringTokenizer coordonnees = new StringTokenizer(message,";");

        while(coordonnees.hasMoreTokens()){
            StringTokenizer xy = new StringTokenizer(coordonnees.nextToken(),",");
            Point p = new Point();
            p.x = Integer.parseInt(xy.nextToken());
            p.y = Integer.parseInt(xy.nextToken());
            lesCoups.add(p);
        }

        return lesCoups;
    }

    public boolean isPerdu(Damier d){
        int nombrePieces=0;
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                if(joueur1) {
                    if (d.lesCases[i][j].pion != null &&
                            d.lesCases[i][j].pion.blanc) {
                        return false;
                    }
                }else
                if (d.lesCases[i][j].pion != null &&
                        !d.lesCases[i][j].pion.blanc) {
                    return false;
                }


            }
        }
        return  true;
    }
}
