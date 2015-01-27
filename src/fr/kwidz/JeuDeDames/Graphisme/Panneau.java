package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panneau extends JPanel{
    public void paintComponent(Graphics g){
        
    }



    }



  /*JButton bouton = new JButton("jouer");
    public Panneau()  {
        //this.setBackground(Color.red);
        //this.ajoutPion();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.print("cliqueSouri");
            }
        });
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("clique");

            }
        });
        this.add(bouton);

    }



    public void ajoutPion() {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("Images/pion.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);
    }*/
