package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import fr.kwidz.JeuDeDames.Jeu.CaseNoire;
import fr.kwidz.JeuDeDames.Jeu.Damier;

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
    Damier damier;
    public void paintComponent(Graphics g){
        if(this.damier != null)
        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                if(this.damier.lesCases[i][j] instanceof CaseNoire){
                    g.setColor(Color.black);
                    g.fillRect(i*10,j*10,10,10);


                }else{g.setColor(Color.white);
                    g.fillRect(i*10,j*10,10,10);}
            }
        }
    }

    public Damier getDamier(){
        return this.damier;
    }

    public void setDamier(Damier d){
        this.damier = d;
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
