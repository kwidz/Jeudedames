package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Fenetre extends JFrame{
    Panneau tableauJeu;
        public  Fenetre(Panneau p){
            this.addComponentListener(new ComponentAdapter()
            {
                public void componentResized(ComponentEvent evt) {
                    Component c = (Component)evt.getSource();
                    //........
                    System.out.print("resize");
                }
            });

            this.tableauJeu = p;
            this.setTitle("Jeu de Dames");
            this.setSize(400, 400);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(this.tableauJeu);
            this.setVisible(true);
        }



}
