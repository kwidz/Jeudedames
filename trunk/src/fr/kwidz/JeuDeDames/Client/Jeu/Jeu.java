package fr.kwidz.JeuDeDames.Client.Jeu;

import fr.kwidz.JeuDeDames.Client.Reseau.Echange;

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
