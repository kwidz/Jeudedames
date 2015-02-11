package fr.kwidz.JeuDeDames.Graphisme;

import fr.kwidz.JeuDeDames.Jeu.Damier;
import fr.kwidz.JeuDeDames.Reseau.Client.DialogueAvecServeur;
import fr.kwidz.JeuDeDames.Reseau.Client.GestionaireDeTours;

/**
 * Created by morgane on 27/01/15.
 */
public class Affichage {
     Fenetre fenetre;
    public Panneau interfacePaneau;
    public Affichage(Damier d, GestionaireDeTours jeton, DialogueAvecServeur dialogue){

        this.fenetre = new Fenetre();
        this.interfacePaneau = new Panneau(d,fenetre, jeton, dialogue);
    }

    public void raffraichir(Damier d){
        interfacePaneau.setDamier(d);
        interfacePaneau.repaint();
    }
}
