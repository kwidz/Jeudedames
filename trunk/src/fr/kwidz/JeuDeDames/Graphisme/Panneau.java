package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import fr.kwidz.JeuDeDames.Jeu.CaseNoire;
import fr.kwidz.JeuDeDames.Jeu.Damier;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Panneau extends JPanel{
    Damier damier;
    int tailleFenetreH;
    int tailleFenetreW;
    BufferedImage imageTest;
    public Panneau(Damier d, Fenetre fenetre){
        fenetre.setContentPane(this);
        tailleFenetreW = fenetre.getWidth()/10;
        tailleFenetreH = fenetre.getHeight()/10;
        this.damier = d;
        this.setLayout(null);
        System.out.println(tailleFenetreW);



            try {
                imageTest = ImageIO.read(new File("Image/minion.png"));
            } catch (IOException ex) {
                System.out.print("ERREUR charge Image");
            }


        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                final Bouton bouton =damier.lesCases[i][j].boutonContenu;

                if(this.damier.lesCases[i][j] instanceof CaseNoire){
                    this.add(bouton);
                    bouton.setBackground(Color.black);
                    bouton.modifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);
                    bouton.modifierCoordonneeCase(i,j);
                    bouton.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println("x : " + bouton.caseX + " y :" + bouton.caseY+ " ");
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });

                }else{
                    this.add(bouton);
                    bouton.setBackground(Color.white);
                    bouton.modifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);
                }





            }


        }
        this.repaint();
    }

    public void paintComponent(Graphics g){

        tailleFenetreW = this.getWidth()/10;
        tailleFenetreH = this.getHeight()/10;

        if(this.damier != null)
        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                if(this.damier.lesCases[i][j] instanceof CaseNoire){

                    damier.lesCases[i][j].boutonContenu.modifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);


                }else{

                    damier.lesCases[i][j].boutonContenu.modifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);

                    }
            }
        }

        g.drawImage(imageTest, 0,0, null);
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
