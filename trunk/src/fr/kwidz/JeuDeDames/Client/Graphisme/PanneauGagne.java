package fr.kwidz.JeuDeDames.Client.Graphisme;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kwidz on 06/03/15.
 */
public class PanneauGagne extends JPanel{

    public void paintComponent(Graphics g){
        g.drawString("Félicitation vous venez de gagner !!! ", 10, 20);
    }
}
