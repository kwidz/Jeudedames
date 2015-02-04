package fr.kwidz.JeuDeDames.Reseau.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.nio.Buffer;

/**
 * Created by kwidz on 23/01/15.
 */
public class ThreadEcoute extends Thread{

    BufferedReader input;
    public GestionaireDeTours jetonDeJeu;
    public FenetreClient f;
    private boolean tourne = true;

    public void setTourne(boolean tourne) {
        this.tourne = tourne;
    }

    public ThreadEcoute(BufferedReader input, GestionaireDeTours jetonDeJeu, FenetreClient f) {
        this.input=input;this.jetonDeJeu=jetonDeJeu;
        this.f = f;
    }
/*
*
* TODO : Améliorer le mvc pour éviter de changer le texte de la fenetre directement dans cette classe.
*
* */
    @Override
    public void run() {

        while (tourne) {
            System.out.println(tourne);
            String message = "";
            try {
                message = input.readLine();
                System.out.println("message : " + message);
                if(message.equals("joueur1")){
                    jetonDeJeu.setJeton(false);
                    f.text.setText("Vous êtes le joueur 1 attendez qu'un autre joueur se connecte pour pouvoir jouer !");
                }else
                if(message.equals("joueur2")){
                    jetonDeJeu.setJeton(false);
                    f.text.setText("Vous êtes le joueur 2 attendez que le J1 commence la partie !");
                }else
                if(message.equals("connectionJ2")){
                    jetonDeJeu.setJeton(true);
                    f.text.setText("Un joueur s'est connecté a vous de jouer !");
                }else {
                    System.out.println("Lu: " + message);
                    jetonDeJeu.setJeton(true);
                    f.text.setText("l'adversaire a joué, c'est a vous !");
                }
            } catch (SocketException e){
                System.err.println("Erreur lors de la lecture : " + e);
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture : " + e);
                System.exit(-1);

            }

        }
        System.out.print("##########################");
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
