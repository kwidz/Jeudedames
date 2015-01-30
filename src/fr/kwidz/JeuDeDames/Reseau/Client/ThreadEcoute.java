package fr.kwidz.JeuDeDames.Reseau.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by kwidz on 23/01/15.
 */
public class ThreadEcoute extends Thread{

    BufferedReader input;
    public boolean jetonDeJeu;
    public FenetreClient f;

    public ThreadEcoute(BufferedReader input, boolean jetonDeJeu, FenetreClient f) {
        this.input=input;this.jetonDeJeu=jetonDeJeu;
        this.f = f;
    }

    @Override
    public void run() {

        while (true) {
            String message = "";
            try {
                message = input.readLine();
                System.out.println("Lu: " + message);
                this.jetonDeJeu = true;
                f.text.setText("l'adversaire a joué, c'est a vous !");
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture : " + e);
                System.exit(-1);

            }

        }
    }
}
