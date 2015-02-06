package fr.kwidz.JeuDeDames.Graphisme;

import fr.kwidz.JeuDeDames.Jeu.Damier;

/**
 * Created by morgane on 27/01/15.
 */
public class Affichage {
     Fenetre fenetre;
    Panneau interfac;
    public Affichage(Damier d){

        this.fenetre = new Fenetre();
        this.interfac = new Panneau(d,fenetre);
    }

    public void raffraichir(Damier d){
        interfac.setDamier(d);
        interfac.repaint();
    }
}
