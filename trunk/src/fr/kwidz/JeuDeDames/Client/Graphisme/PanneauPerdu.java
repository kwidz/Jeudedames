package fr.kwidz.JeuDeDames.Client.Graphisme;

import javax.swing.*;
import java.awt.*;


/**
 * Created by kwidz on 06/03/15.
 */
public class PanneauPerdu extends JPanel {

    public void paintComponent(Graphics g){
        g.drawString("Vous avez perdu !! ", 10, 20);
    }

}
