package fr.kwidz.JeuDeDames.Reseau.Client;

/**
 * Created by kwidz on 30/01/15.
 */
public class GestionaireDeTours {
    private boolean jeton = true;
    public GestionaireDeTours(){

    }

    public boolean isJeton() {
        return jeton;
    }

    public void setJeton(boolean jeton) {
        this.jeton = jeton;
    }
}
