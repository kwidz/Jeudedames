package fr.kwidz.JeuDeDames.Jeu;

import fr.kwidz.JeuDeDames.Graphisme.CaseDrawable;

/**
 * Created by morgane on 27/01/15.
 */
public class Case{
    public CaseDrawable caseDrawableContenu;
    public Pion pion;
    public Boolean estSelectionne;
    public Case(){

        caseDrawableContenu = new CaseDrawable();
        estSelectionne =false;
    }
}
