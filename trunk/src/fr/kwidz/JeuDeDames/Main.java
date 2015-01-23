package fr.kwidz.JeuDeDames;

import fr.kwidz.JeuDeDames.Graphisme.Fenetre;
import fr.kwidz.JeuDeDames.Graphisme.Panneau;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Panneau p = new Panneau();
        Fenetre f = new Fenetre(p);
    }
}