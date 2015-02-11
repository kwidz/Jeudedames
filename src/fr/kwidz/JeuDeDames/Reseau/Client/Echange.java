package fr.kwidz.JeuDeDames.Reseau.Client;

import fr.kwidz.JeuDeDames.Graphisme.Affichage;
import fr.kwidz.JeuDeDames.Jeu.Damier;
import fr.kwidz.JeuDeDames.Reseau.Serveur.ServeurTCPMulti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by kwidz on 11/02/15.
 */
public class Echange {

    public GestionaireDeTours jeton;
    public DialogueAvecServeur dialogue;

    public Echange(Damier damier){

        jeton = new GestionaireDeTours();
        Scanner sc = new Scanner(System.in);
        // Creation de la socket
        Socket socket = null;
        try {
            socket = new Socket("localhost", ServeurTCPMulti.portEcoute);
        } catch(UnknownHostException e) {
            System.err.println("Erreur sur l'hôte : " + e);
            System.exit(-1);
        } catch(IOException e) {
            System.err.println("Creation de la socket impossible : " + e);
            System.exit(-1);
        }

        // Association d'un flux d'entree et de sortie
        BufferedReader input = null;

        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch(IOException e) {
            System.err.println("Association des flux impossible : " + e);
            System.exit(-1);
        }
        dialogue = new DialogueAvecServeur(socket);
        Affichage f = new Affichage(damier, jeton, dialogue);
        String message = "";
        ThreadEcoute t = new ThreadEcoute(input, jeton, f, dialogue);
        dialogue.setThread(t);
        t.start();

    }

    public void deconexion(){

        dialogue.deconexion();
    }

    public void jouerUnCoup(){
        if(jeton.isJeton()){
            System.out.println("vouys venez de jouer un coup !");
            dialogue.jouerUnCoups();
            jeton.setJeton(false);

        }
        else{
            System.out.println("votre adversaire est en train de jouer, veuillez attendre !");
        }
    }

}


