package fr.kwidz.JeuDeDames.Client.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import fr.kwidz.JeuDeDames.Client.Jeu.*;
import fr.kwidz.JeuDeDames.Client.Reseau.DialogueAvecServeur;
import fr.kwidz.JeuDeDames.Client.Reseau.GestionaireDeTours;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Panneau extends JPanel{
    private DialogueAvecServeur dialogue;
    Damier damier;
    public Panneau self = this;
    int tailleFenetreH;
    int tailleFenetreW;
    boolean joueur1;
    //ArrayList listeCaseSelectionne = new ArrayList();


    public Panneau(Damier d, Fenetre fenetre, GestionaireDeTours jeton, DialogueAvecServeur dialogue){
        fenetre.setContentPane(this);
        tailleFenetreW = fenetre.getWidth()/10;
        tailleFenetreH = fenetre.getHeight()/10;
        this.damier = d;
        this.setLayout(null);
        this.dialogue = dialogue;


        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                CaseDrawable caseDrawableContenu =damier.lesCases[i][j].caseDrawableContenu;

                if(this.damier.lesCases[i][j] instanceof CaseNoire){
                    this.add(caseDrawableContenu);
                    caseDrawableContenu.setBackground(Color.black);
                    caseDrawableContenu.modifierBouton(j * this.tailleFenetreW, i * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);
                    caseDrawableContenu.modifierCoordonneeCase(i, j);
                    caseDrawableContenu.addMouseListener(new EcouteCase(this.damier.lesCases[i][j], this.damier,jeton,dialogue));


                }else{
                    this.add(caseDrawableContenu);
                    caseDrawableContenu.setBackground(Color.white);
                    caseDrawableContenu.modifierBouton(j * this.tailleFenetreW, i * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);



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

            if(dialogue.joueur1.isJeton()){
                System.out.println("affichage joueur 1");
                int imoins = 9;
                for (int i = 9; i >= 0; i--) {
                    int jmoins = 9;
                    for (int j = 9; j >= 0; j--) {
                        if (this.damier.lesCases[i][j] instanceof CaseNoire) {

                            damier.lesCases[i][j].caseDrawableContenu.modifierBouton((j-jmoins) * this.tailleFenetreW, (i-imoins) * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);
                            if(damier.lesCases[i][j].piece != null ){
                                if(damier.lesCases[i][j].piece.blanc){
                                    damier.lesCases[i][j].caseDrawableContenu.dessinerPion(4, 4 , tailleFenetreW-10, tailleFenetreH-10, Color.white, damier.lesCases[i][j].piece);
                                }else{
                                    damier.lesCases[i][j].caseDrawableContenu.dessinerPion(4, 4 , tailleFenetreW-10, tailleFenetreH-10, Color.red, damier.lesCases[i][j].piece);
                                }
                            }else{
                                //damier.lesCases[i][j].caseDrawableContenu.dessinerPion(4, 4 , tailleFenetreW, tailleFenetreH, Color.black);
                            }


                        } else {

                            damier.lesCases[i][j].caseDrawableContenu.modifierBouton((j-jmoins) * this.tailleFenetreW, (i-imoins) * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);

                        }
                        jmoins-=2;
                    }
                    imoins-=2;
                }
            }
            else {
                System.out.println("affichage joueur 2");
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (this.damier.lesCases[i][j] instanceof CaseNoire) {

                            damier.lesCases[i][j].caseDrawableContenu.modifierBouton(j * this.tailleFenetreW, i * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);
                            if (damier.lesCases[i][j].piece != null) {
                                if (damier.lesCases[i][j].piece.blanc) {
                                    damier.lesCases[i][j].caseDrawableContenu.dessinerPion(4, 4, tailleFenetreW - 10, tailleFenetreH - 10, Color.white, damier.lesCases[i][j].piece);
                                } else {
                                    damier.lesCases[i][j].caseDrawableContenu.dessinerPion(4, 4, tailleFenetreW - 10, tailleFenetreH - 10, Color.red, damier.lesCases[i][j].piece);
                                }
                            } else {
                                //damier.lesCases[i][j].caseDrawableContenu.dessinerPion(4, 4 , tailleFenetreW, tailleFenetreH, Color.black);
                            }


                        } else {

                            damier.lesCases[i][j].caseDrawableContenu.modifierBouton(j * this.tailleFenetreW, i * this.tailleFenetreH, tailleFenetreW, tailleFenetreH);

                        }
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


    public void jouerUnCoup(int xDepart, int yDepart, int xArrivee, int yArrivee, ArrayList<Point> lesprises){

        Case caseDepart = this.damier.lesCases[xDepart][yDepart];
        Case caseArrivee = this.damier.lesCases[xArrivee][yArrivee];

        if(caseDepart.piece instanceof  Pion)
            caseArrivee.piece = new Pion(caseDepart.piece.blanc);
        else
            caseArrivee.piece = new Dame(caseDepart.piece.blanc);

        caseArrivee.caseDrawableContenu.dessinerPion(caseDepart.caseDrawableContenu.pionPosX, caseDepart.caseDrawableContenu.pionPosY,caseDepart.caseDrawableContenu.pionWidth, caseDepart.caseDrawableContenu.pionHeight, caseDepart.caseDrawableContenu.couleurPion, caseArrivee.piece);
        caseDepart.effacerPiece();
        for (int i = 0; i < lesprises.size(); i++) {

            Case casetmp = this.damier.lesCases[((Point)lesprises.get(i)).x][((Point)lesprises.get(i)).y];
            casetmp.effacerPiece();
        }
    }
    public void jouerUnCoup(int xDepart, int yDepart, int xArrivee, int yArrivee, ArrayList<Point> lesprises, Point dame){

        Case caseDepart = this.damier.lesCases[xDepart][yDepart];
        Case caseArrivee = this.damier.lesCases[xArrivee][yArrivee];
        caseArrivee.piece = new Dame(caseDepart.piece.blanc);
        caseArrivee.caseDrawableContenu.dessinerPion(caseDepart.caseDrawableContenu.pionPosX, caseDepart.caseDrawableContenu.pionPosY,caseDepart.caseDrawableContenu.pionWidth, caseDepart.caseDrawableContenu.pionHeight, caseDepart.caseDrawableContenu.couleurPion, caseArrivee.piece);
        caseDepart.effacerPiece();
        for (int i = 0; i < lesprises.size(); i++) {

            Case casetmp = this.damier.lesCases[((Point)lesprises.get(i)).x][((Point)lesprises.get(i)).y];
            casetmp.effacerPiece();
        }
    }


}

