package fr.kwidz.JeuDeDames.Graphisme;

import javax.swing.*;
import java.awt.*;

/**
 * Created by morgane on 28/01/15.
 */
public class Bouton extends JPanel{
    JPanel fondBouton;
    int posX;
    int posY;
    int width;
    int height;
    public Bouton(){
        //this.setLayout(null);
        //this.setBackground(Color.black);

        //fondBouton = new JPanel();
        //fondBouton.setBackground(Color.black);
        //this.add(fondBouton);
        //La taille en hauteur et en largeur

        //content.add(cell1, gbc);
    }

    public void modifierBouton(int x, int y, int w, int h){

        this.posX = x;
        this.posY = y;
        this.width = w;
        this.height = h;
        this.setBounds(this.posX,this.posY,this.width, this.height);
    }



}
