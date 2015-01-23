package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panneau extends JPanel{
    public Panneau()  {
        this.setBackground(Color.red);
        try {
            this.ajoutPion();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ajoutPion() throws IOException {
        BufferedImage myPicture = ImageIO.read(new File("Images/pion.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);
    }
}
