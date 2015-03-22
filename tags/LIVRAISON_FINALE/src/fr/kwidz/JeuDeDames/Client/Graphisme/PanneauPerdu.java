package fr.kwidz.JeuDeDames.Client.Graphisme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by kwidz on 06/03/15.
 */
public class PanneauPerdu extends JPanel {

    public void paintComponent(Graphics g){
        BufferedImage marioGagne = null;

        try {
            marioGagne = ImageIO.read(new File("Images/marioGagne.png"));

        } catch (IOException ex) {
            System.out.print("non chargé");
        }
        g.drawImage(marioGagne,0,0,this.getWidth(),this.getHeight(),null);




    }

}
