package fr.kwidz.JeuDeDames.Serveur.Jeu;

import java.awt.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by kwidz on 18/02/15.
 */
public class Joueur {
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
}
