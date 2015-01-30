package fr.kwidz.JeuDeDames.Graphisme;

import javax.swing.*;
import java.awt.*;

/**
 * Created by morgane on 28/01/15.
 */
public class Bouton extends JButton{
    JPanel fondBouton;
    int posX;
    int posY;
    int width;
    int height;
    public Bouton(){
        fondBouton = new JPanel();
        fondBouton.setBackground(Color.cyan);
        //La taille en hauteur et en largeur
        this.add(fondBouton);
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
