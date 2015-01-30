package fr.kwidz.JeuDeDames.Graphisme;

/**
 * Created by morgane on 23/01/15.
 */

import fr.kwidz.JeuDeDames.Jeu.CaseNoire;
import fr.kwidz.JeuDeDames.Jeu.Damier;
import javax.swing.*;
import java.awt.*;


public class Panneau extends JPanel{
    Damier damier;
    int tailleFenetreH;
    int tailleFenetreW;
    public Panneau(Damier d, Fenetre fenetre){
        fenetre.setContentPane(this);
        tailleFenetreW = fenetre.getWidth()/10;
        tailleFenetreH = fenetre.getHeight()/10;
        this.damier = d;
        this.setLayout(null);
        System.out.println(tailleFenetreW);

        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                Bouton bouton =damier.lesCases[i][j].boutonContenu;
                        bouton.setBorderPainted(false);
                bouton.setFocusPainted(false);
                bouton.setContentAreaFilled(false);


                this.add(bouton);
                bouton.modifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);
                   // this.add(new JButton(" "+i+";"+j+" "));
                    //g.setColor(new Color(182, 175, 157));
                    //g.fillRect(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);



            }


        }
    }

    public void paintComponent(Graphics g){

        tailleFenetreW = this.getWidth()/10;
        tailleFenetreH = this.getHeight()/10;
       // Bouton test = new Bouton();
        //test.ModifierBouton(10*this.tailleFenetreW,10*this.tailleFenetreH,Color.black,tailleFenetreH,tailleFenetreW);
        //this.add(test.fondBouton, test.tableauB);
        if(this.damier != null)
        for(int i = 0 ; i < 10 ; i++){
            for(int j = 0 ; j < 10 ; j++){
                if(this.damier.lesCases[i][j] instanceof CaseNoire){
                    damier.lesCases[i][j].boutonContenu.modifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);
                    //this.damier.lesCases[i][j].boutonContenu.ModifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,Color.black,tailleFenetreH,tailleFenetreW);
                    //g.setColor(new Color(182, 175, 157));
                    //g.fillRect(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);


                }else{g.setColor(new Color(253, 252, 222));
                    damier.lesCases[i][j].boutonContenu.modifierBouton(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);
                   // g.fillRect(i*this.tailleFenetreW,j*this.tailleFenetreH,tailleFenetreW,tailleFenetreH);
                    }
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
