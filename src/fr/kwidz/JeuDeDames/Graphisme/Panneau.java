package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import fr.kwidz.JeuDeDames.Jeu.CaseNoire;
import fr.kwidz.JeuDeDames.Jeu.Damier;
import fr.kwidz.JeuDeDames.Jeu.EcouteCase;
import fr.kwidz.JeuDeDames.Jeu.Pion;
import fr.kwidz.JeuDeDames.Reseau.Client.DialogueAvecServeur;
import fr.kwidz.JeuDeDames.Reseau.Client.GestionaireDeTours;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class Panneau extends JPanel{
    Damier damier;
    public Panneau self = this;
    int tailleFenetreH;
    int tailleFenetreW;
    //ArrayList listeCaseSelectionne = new ArrayList();


    public Panneau(Damier d, Fenetre fenetre, GestionaireDeTours jeton, DialogueAvecServeur dialogue){
        fenetre.setContentPane(this);
        tailleFenetreW = fenetre.getWidth()/10;
        tailleFenetreH = fenetre.getHeight()/10;
        this.damier = d;
        this.setLayout(null);
        System.out.println(tailleFenetreW);










        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                final CaseDrawable caseDrawableContenu =damier.lesCases[i][j].caseDrawableContenu;

                if(this.damier.lesCases[i][j] instanceof CaseNoire){
                    this.add(caseDrawableContenu);
                    caseDrawableContenu.setBackground(Color.black);
                    caseDrawableContenu.modifierBouton(i * this.tailleFenetreW, j * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);
                    caseDrawableContenu.modifierCoordonneeCase(i, j);
                    caseDrawableContenu.addMouseListener(new EcouteCase(this.damier.lesCases[i][j], this.damier,jeton,dialogue));


                }else{
                    this.add(caseDrawableContenu);
                    caseDrawableContenu.setBackground(Color.white);
                    caseDrawableContenu.modifierBouton(i * this.tailleFenetreW, j * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);



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

                        damier.lesCases[i][j].caseDrawableContenu.modifierBouton(i * this.tailleFenetreW, j * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);
                        if(damier.lesCases[i][j].pion != null){
                            if(damier.lesCases[i][j].pion.blanc){
                                damier.lesCases[i][j].caseDrawableContenu.dessinerPion(4, 4 , tailleFenetreW-10, tailleFenetreH-10, Color.white);
                            }else{
                                damier.lesCases[i][j].caseDrawableContenu.dessinerPion(4, 4 , tailleFenetreW-10, tailleFenetreH-10, Color.red);
                            }
                        }else{
                            //damier.lesCases[i][j].caseDrawableContenu.dessinerPion(4, 4 , tailleFenetreW, tailleFenetreH, Color.black);
                        }


                    } else {

                        damier.lesCases[i][j].caseDrawableContenu.modifierBouton(i * this.tailleFenetreW, j * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);

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

