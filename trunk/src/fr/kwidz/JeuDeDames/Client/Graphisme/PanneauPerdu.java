package fr.kwidz.JeuDeDames.Client.Graphisme;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by kwidz on 06/03/15.
 */
public class PanneauPerdu extends JPanel {

    public void paintComponent(Graphics g){
        BufferedImage perdu;
        g.drawString("Vous avez perdu !! ", 10, 20);


    }

}
