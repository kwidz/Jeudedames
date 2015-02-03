package fr.kwidz.JeuDeDames.Jeu;

import fr.kwidz.JeuDeDames.Graphisme.Bouton;

/**
 * Created by morgane on 27/01/15.
 */
public class Case{
    public Bouton boutonContenu;
    public Pion pion;
    public Case(){
        boutonContenu = new Bouton();
    }
}
