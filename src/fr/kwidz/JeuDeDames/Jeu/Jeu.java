package fr.kwidz.JeuDeDames.Jeu;

import fr.kwidz.JeuDeDames.Graphisme.Fenetre;
import fr.kwidz.JeuDeDames.Graphisme.Panneau;

/**
 * Created by morgane on 23/01/15.
 */
public class Jeu {
    public Jeu(){
        Panneau p = new Panneau();
        Fenetre f = new Fenetre(p);
    }
}
