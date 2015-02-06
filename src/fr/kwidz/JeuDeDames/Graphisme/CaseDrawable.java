package fr.kwidz.JeuDeDames.Graphisme;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by morgane on 28/01/15.
 */
public class CaseDrawable extends JPanel{
    JPanel fondBouton;
    int posX;
    int posY;
    int width;
    int height;
    int caseX;
    int caseY;

    int pionPosX;
    int pionPosY;
    int pionWidth = 0;
    int pionHeight;
    Color couleurPion;
    Boolean estSelectionnee;


    public CaseDrawable(){
        estSelectionnee =false;
this.repaint();

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

        if(this.pionWidth != 0){
            g.setColor(this.couleurPion);
            g.fillOval( this.pionPosX, this.pionPosY,this.pionWidth,this.pionHeight);
        }else{
            g.dispose();
        }

        if(this.estSelectionnee){
            this.setBackground(Color.gray);
        }
        this.repaint();
    }

    public void dessinerPion(int x, int y, int w, int h, Color c){
        this.pionPosX = x;
        this.pionPosY = y;
        this.pionWidth = w;
        this.pionHeight = h;
        this.couleurPion = c;
       // this.g.setColor(Color.red);
        //this.g.fillOval(this.pionPosX,this.pionPosY,this.pionWidth,this.pionHeight);
       this.repaint();
    }

    public void effacerPion(){
        this.pionWidth = 0;
        this.repaint();
    }

    public void Selectionner(){
        estSelectionnee = true;
    }

    public void DeSelectionner(){
        estSelectionnee = false;
    }

}
