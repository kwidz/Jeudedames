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
    public Joueur joueur1;
    public Joueur joueur2;
    public Jeu(){
        this.damier = new Damier();
        this.echange = new Echange(damier);
        this.joueur1 = new Joueur();
        this.joueur2 = new Joueur();
        /*vueJeu = new Affichage(damier);
        vueJeu.raffraichir(this.damier);
*/        //Panneau p = new Panneau();
        //Fenetre f = new Fenetre(p);
    }


}
