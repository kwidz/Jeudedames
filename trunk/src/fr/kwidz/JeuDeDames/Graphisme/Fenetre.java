package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Fenetre extends JFrame{
    public Panneau tableauJeu;
    public Fenetre self = this;
        public  Fenetre(){

            this.addComponentListener(new ComponentAdapter()
            {
                public void componentResized(ComponentEvent evt) {
                    if(self.getHeight()>self.getWidth()) {
                        self.setSize(self.getHeight(), self.getHeight());
                    }
                    else {
                        self.setSize(self.getWidth(), self.getWidth());
                    }
                }
            });

            //this.tableauJeu = p;
            this.setTitle("Jeu de Dames");
            this.setSize(610, 630);
            this.setLocationRelativeTo(null);
            //this.setLayout(null);
            /*Bouton b = new Bouton();
            this.add(b);
            b.modifierBouton(0,0,50,50);*/
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //this.setContentPane(this.tableauJeu);
            this.setVisible(true);
        }



}
