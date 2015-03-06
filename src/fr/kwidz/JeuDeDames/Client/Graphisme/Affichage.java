package fr.kwidz.JeuDeDames.Client.Graphisme;

import fr.kwidz.JeuDeDames.Client.Jeu.Damier;
import fr.kwidz.JeuDeDames.Client.Reseau.DialogueAvecServeur;
import fr.kwidz.JeuDeDames.Client.Reseau.GestionaireDeTours;

/**
 * Created by morgane on 27/01/15.
 */
public class Affichage {
    public Fenetre fenetre;
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
