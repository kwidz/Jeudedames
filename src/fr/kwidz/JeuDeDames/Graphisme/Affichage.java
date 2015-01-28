package fr.kwidz.JeuDeDames.Graphisme;

import fr.kwidz.JeuDeDames.Jeu.Damier;

/**
 * Created by morgane on 27/01/15.
 */
public class Affichage {
     Fenetre fenetre;
    Panneau interfac;
    public Affichage(){
        this.interfac = new Panneau();
        this.fenetre = new Fenetre(interfac);
       
    }

    public void raffraichir(Damier d){
        interfac.setDamier(d);
        interfac.repaint();
    }
}
