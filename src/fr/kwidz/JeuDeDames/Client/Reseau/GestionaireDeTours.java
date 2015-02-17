package fr.kwidz.JeuDeDames.Client.Reseau;

/**
 * Created by kwidz on 30/01/15.
 */
public class GestionaireDeTours {
    private boolean jeton = true;
    private boolean joueur1;
    public GestionaireDeTours(){

    }

    public boolean isJeton() {
        return jeton;
    }

    public void setJeton(boolean jeton) {
        this.jeton = jeton;
    }

    public boolean isJoueur1() {
        return joueur1;
    }

    public void setJoueur1(boolean joueur1){
        this.joueur1 = joueur1;
    }
}
