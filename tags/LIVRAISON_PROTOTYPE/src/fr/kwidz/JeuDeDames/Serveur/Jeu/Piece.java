package fr.kwidz.JeuDeDames.Serveur.Jeu;

/**
 * Created by morgane on 27/01/15.
 */
public abstract class Piece {

    public boolean blanc;


    public Piece(boolean blanc){
        this.blanc = blanc;
    }

    public Piece(Piece p){
        this.blanc = p.blanc;
    }

}
