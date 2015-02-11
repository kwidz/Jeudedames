package fr.kwidz.JeuDeDames.Jeu;

import fr.kwidz.JeuDeDames.Graphisme.Affichage;
import fr.kwidz.JeuDeDames.Graphisme.Fenetre;
import fr.kwidz.JeuDeDames.Graphisme.Panneau;
import fr.kwidz.JeuDeDames.Reseau.Client.Echange;

/**
 * Created by morgane on 23/01/15.
 */
public class Jeu {

    Damier damier;
    public Echange echange;
    public Jeu(){
        this.damier = new Damier();
        this.echange = new Echange(damier);
        /*vueJeu = new Affichage(damier);
        vueJeu.raffraichir(this.damier);
*/        //Panneau p = new Panneau();
        //Fenetre f = new Fenetre(p);
    }


}
