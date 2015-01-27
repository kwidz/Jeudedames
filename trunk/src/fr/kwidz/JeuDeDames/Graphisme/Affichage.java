package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 27/01/15.
 */
public class Affichage {
    Fenetre fenetre;
    public Affichage(){
        this.fenetre = new Fenetre(new Panneau());
    }
}
