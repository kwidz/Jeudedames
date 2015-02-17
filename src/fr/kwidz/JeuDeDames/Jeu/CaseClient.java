package fr.kwidz.JeuDeDames.Jeu;

import fr.kwidz.JeuDeDames.Graphisme.CaseDrawable;

import java.awt.*;

/**
 * Created by morgane on 27/01/15.
 */
public class CaseClient extends Case{

    public CaseDrawable caseDrawableContenu;

    public Boolean estSelectionne;
    public Boolean choisissable;

    public CaseClient() {

        caseDrawableContenu = new CaseDrawable();
        estSelectionne =false;
        choisissable = false;
    }


    public void Selectionner(){
        this.estSelectionne =true;
        this.caseDrawableContenu.Selectionner();
        this.caseDrawableContenu.repaint();
        //Ici nous appelerons la fonction qui dira sur quelle case on peut cliquer
    }

    public void DeSelectionner(){
        this.estSelectionne =false;
        this.caseDrawableContenu.DeSelectionner();
        this.caseDrawableContenu.repaint();
    }

    public void EffacerPion(){
        super.EffacerPion();
        this.caseDrawableContenu.effacerPion();
    }
}
