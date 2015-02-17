package fr.kwidz.JeuDeDames.Jeu;

/**
 * Created by kwidz on 17/02/15.
 */
public class Case {

    public Pion pion;
    public Boolean choisissable;

    public Case(){

    }

    public void EffacerPion() {
        this.pion = null;
    }
}
