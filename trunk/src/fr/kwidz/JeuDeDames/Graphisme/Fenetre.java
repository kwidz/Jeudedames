package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import javax.swing.JFrame;
public class Fenetre extends JFrame{
        public  Fenetre(Panneau p){
            this.setTitle("Jeu de Dames");
            this.setSize(400, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(p);
            this.setVisible(true);
        }



}
