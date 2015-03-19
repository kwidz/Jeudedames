package fr.kwidz.JeuDeDames.Client.Graphisme;

import fr.kwidz.JeuDeDames.Client.Jeu.Pion;
import fr.kwidz.JeuDeDames.Client.Jeu.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by morgane on 28/01/15.
 */
public class CaseDrawable extends JPanel{
    JPanel fondBouton;
    int posX;
    int posY;
    int width;
    int height;
    public int caseX;
    public int caseY;
    BufferedImage couronne;
    BufferedImage mario;
    BufferedImage luigi;

    Piece pieceADessiner;

    public int pionPosX;
    public int pionPosY;
    public int pionWidth = 0;
    public int pionHeight;
    public Color couleurPion;
    Boolean estSelectionnee;


    public CaseDrawable(){
        estSelectionnee =false;
        this.repaint();
        this.pieceADessiner = null;

        try {
            couronne = ImageIO.read(new File("Images/couronne.png"));
        } catch (IOException ex) {

        }

        try {
            mario = ImageIO.read(new File("Images/mario.png"));
        } catch (IOException ex) {
        System.out.print("non chargé");
        }

        try {
            luigi = ImageIO.read(new File("Images/luigi.png"));
        } catch (IOException ex) {
            System.out.print("non chargé2");
        }

    }

    public void modifierBouton(int x, int y, int w, int h){

        this.posX = x;
        this.posY = y;
        this.width = w;
        this.height = h;
        this.setBounds(this.posX,this.posY,this.width, this.height);

    }

    public void modifierCoordonneeCase(int x, int y){
        this.caseX = x;
        this.caseY = y;

    }

    public void paintComponent(Graphics g){
        //g.dispose();
        super.paintComponent(g);

        if((this.pieceADessiner != null) ){
            if(this.pieceADessiner instanceof Pion){
                g.setColor(this.couleurPion);
                g.fillOval( this.pionPosX, this.pionPosY, this.pionWidth, this.pionHeight);
                if(this.couleurPion == Color.red){

                    g.drawImage(mario,this.pionPosY-15,this.pionPosY-15, this.pionWidth+30, this.pionHeight+30,null);
                }else{
                    g.drawImage(luigi,this.pionPosY-15,this.pionPosY-10, this.pionWidth+30, this.pionHeight+30,null);
                }

            } else{
                //Dessiner dame
                g.setColor(this.couleurPion);

                g.fillOval( this.pionPosX, this.pionPosY,this.pionWidth,this.pionHeight);
                g.drawImage(couronne,this.pionPosY,this.pionPosY, this.pionWidth, this.pionHeight,null);


            }
        }else{
            g.dispose();
        }


        this.repaint();
    }


    public void dessinerPion(int x, int y, int w, int h, Color c, Piece p){
        this.pionPosX = x;
        this.pionPosY = y;
        this.pionWidth = w;
        this.pionHeight = h;
        this.couleurPion = c;
        this.pieceADessiner = p;
       // this.g.setColor(Color.red);
        //this.g.fillOval(this.pionPosX,this.pionPosY,this.pionWidth,this.pionHeight);
       this.repaint();
    }

    public void effacerPiece(){
        this.pionWidth = 0;
        this.pieceADessiner = null;
        this.repaint();
    }

    public void Selectionner(){
        estSelectionnee = true;
        this.setBackground(Color.gray);
    }

    public void DeSelectionner(){
        estSelectionnee = false;
        this.setBackground(Color.black);
    }

    public void modifierCouleurPion(Color c){
        this.couleurPion = c;
        this.repaint();
    }



}
