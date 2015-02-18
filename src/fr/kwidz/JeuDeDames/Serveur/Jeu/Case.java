package fr.kwidz.JeuDeDames.Serveur.Jeu;

/**
 * Created by morgane on 27/01/15.
 */
public class Case{

    public Piece pion;


    public Case() {


    }

    public Piece getPion() {
        return pion;
    }

    public void effacerPion(){
        this.pion = null;

    }
}
