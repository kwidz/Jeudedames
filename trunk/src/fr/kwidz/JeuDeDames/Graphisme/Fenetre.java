package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import javax.swing.JFrame;
public class Fenetre {
        public  Fenetre(){
            JFrame maFenetre = new JFrame();

            maFenetre.setTitle("Jeu de Dames");
            maFenetre.setSize(400, 100);
            maFenetre.setLocationRelativeTo(null);
            maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            maFenetre.setVisible(true);
        }



}
