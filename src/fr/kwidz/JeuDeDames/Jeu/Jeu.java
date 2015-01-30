package fr.kwidz.JeuDeDames.Jeu;

import fr.kwidz.JeuDeDames.Graphisme.Affichage;
import fr.kwidz.JeuDeDames.Graphisme.Fenetre;
import fr.kwidz.JeuDeDames.Graphisme.Panneau;

/**
 * Created by morgane on 23/01/15.
 */
public class Jeu {
    Affichage vueJeu;
    Damier damier;
    public Jeu(){
        this.damier = new Damier();
        vueJeu = new Affichage(damier);
        vueJeu.raffraichir(this.damier);
        //Panneau p = new Panneau();
        //Fenetre f = new Fenetre(p);
    }
}
