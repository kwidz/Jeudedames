package fr.kwidz.JeuDeDames.Reseau.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

/**
 * Created by kwidz on 30/01/15.
 */
public class FenetreClient extends JFrame implements ActionListener{
    JPanel p = new JPanel();
    JButton boutonJouer = new JButton("cliquez ici pour jouer un coup !");
    JLabel text = new JLabel("Bienvenue dans le jeu de Dames");
    private GestionaireDeTours jeton;
    PrintWriter outpout;

    public FenetreClient(GestionaireDeTours jeton, PrintWriter output){
        this.outpout = output;
        this.jeton = jeton;
        JFrame fenetre = new JFrame();
        this.setTitle("Jeu de Dames En reseau");
        this.setSize(610, 630);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(p);
        this.setVisible(true);
        boutonJouer.addActionListener(this);
        p.add(boutonJouer);
        p.add(text);
        this.setContentPane(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(jeton.isJeton()){
            text.setText("vouys venez de jouer un coup !");
            outpout.println("Le joueur a joué");
            outpout.flush();
            jeton.setJeton(false);
        }
        else{
            text.setText("votre adversaire est en train de jouer, veuillez attendre !");
        }
    }
}
