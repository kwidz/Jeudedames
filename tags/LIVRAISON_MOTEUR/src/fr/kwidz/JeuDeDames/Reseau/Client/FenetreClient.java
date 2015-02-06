package fr.kwidz.JeuDeDames.Reseau.Client;

import javax.security.auth.callback.Callback;
import javax.swing.*;
import java.awt.event.*;

/**
 * Created by kwidz on 30/01/15.
 */
public class FenetreClient extends JFrame implements ActionListener{
    JPanel p = new JPanel();
    JButton boutonJouer = new JButton("cliquez ici pour jouer un coup !");
    JLabel text = new JLabel("Bienvenue dans le jeu de Dames");
    private GestionaireDeTours jeton;
    DialogueAvecServeur dialogue;

    public FenetreClient(GestionaireDeTours jeton, DialogueAvecServeur dialogue){
        this.dialogue = dialogue;
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


        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(null, "Voulez vous vraiment fermer le jeu ?", "attention !", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    deconexion();
                    System.exit(0);
                }
            }
        };

        this.addWindowListener(exitListener);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(jeton.isJeton()){
            text.setText("vouys venez de jouer un coup !");
            dialogue.jouerUnCoups();

            jeton.setJeton(false);
        }
        else{
            text.setText("votre adversaire est en train de jouer, veuillez attendre !");
        }
    }

    private void deconexion(){

        dialogue.deconexion();
    }
}
