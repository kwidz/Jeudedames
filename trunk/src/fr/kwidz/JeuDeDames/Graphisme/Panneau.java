package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import fr.kwidz.JeuDeDames.Jeu.CaseNoire;
import fr.kwidz.JeuDeDames.Jeu.Damier;
import fr.kwidz.JeuDeDames.Jeu.Pion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Panneau extends JPanel{
    Damier damier;
    public Panneau self = this;
    int tailleFenetreH;
    int tailleFenetreW;


    public Panneau(Damier d, Fenetre fenetre){
        fenetre.setContentPane(this);
        tailleFenetreW = fenetre.getWidth()/10;
        tailleFenetreH = fenetre.getHeight()/10;
        this.damier = d;
        this.setLayout(null);
        System.out.println(tailleFenetreW);










        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                final Bouton bouton =damier.lesCases[i][j].boutonContenu;

                if(this.damier.lesCases[i][j] instanceof CaseNoire){
                    this.add(bouton);
                    bouton.setBackground(Color.black);
                    bouton.modifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);
                    bouton.modifierCoordonneeCase(i,j);
                    bouton.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            System.out.println("x : " + bouton.caseX + " y :" + bouton.caseY+ " ");
                            if(self.damier.lesCases[bouton.caseX][bouton.caseY].pion != null){
                                self.damier.lesCases[bouton.caseX][bouton.caseY].pion = null;
                            }else{
                                if(e.getButton() == MouseEvent.BUTTON1){
                                    self.damier.lesCases[bouton.caseX][bouton.caseY].pion = new Pion(true);
                                }else{
                                    self.damier.lesCases[bouton.caseX][bouton.caseY].pion = new Pion(false);
                                }

                            }

                           self.repaint();
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });

                }else{
                    this.add(bouton);
                    bouton.setBackground(Color.white);
                    bouton.modifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);



                }





            }


        }

        this.repaint();

    }

    public void paintComponent(Graphics g){

    //g.dispose();
        tailleFenetreW = this.getWidth()/10;
        tailleFenetreH = this.getHeight()/10;


        if(this.damier != null) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (this.damier.lesCases[i][j] instanceof CaseNoire) {

                        damier.lesCases[i][j].boutonContenu.modifierBouton(i * this.tailleFenetreW, j * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);
                        if(damier.lesCases[i][j].pion != null){
                            if(damier.lesCases[i][j].pion.blanc){
                                damier.lesCases[i][j].boutonContenu.dessinerPion(4, 4 , tailleFenetreW-10, tailleFenetreH-10, Color.white);
                            }else{
                                damier.lesCases[i][j].boutonContenu.dessinerPion(4, 4 , tailleFenetreW-10, tailleFenetreH-10, Color.red);
                            }
                        }else{
                            damier.lesCases[i][j].boutonContenu.dessinerPion(4, 4 , tailleFenetreW, tailleFenetreH, Color.black);
                        }


                    } else {

                        damier.lesCases[i][j].boutonContenu.modifierBouton(i * this.tailleFenetreW, j * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);

                    }
                }
            }


        }






    }

    public Damier getDamier(){
        return this.damier;
    }

    public void setDamier(Damier d){
        this.damier = d;

    }



}

