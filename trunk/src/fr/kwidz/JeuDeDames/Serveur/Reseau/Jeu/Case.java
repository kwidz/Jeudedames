package fr.kwidz.JeuDeDames.Serveur.Reseau.Jeu;

import fr.kwidz.JeuDeDames.Client.Graphisme.CaseDrawable;

/**
 * Created by morgane on 27/01/15.
 */
public class Case{

    public Pion pion;


    public Case() {


    }

    public void EffacerPion(){
        this.pion = null;

    }
}
