package fr.kwidz.JeuDeDames.Reseau.Client;

import fr.kwidz.JeuDeDames.Reseau.Serveur.ServeurTCPMulti;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by kwidz on 23/01/15.
 *
 */
public class ClientTCPMulti{



    public static void main(String[] args) {

        GestionaireDeTours jetonDeJeu = new GestionaireDeTours();
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
        PrintWriter output = null;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        } catch(IOException e) {
            System.err.println("Association des flux impossible : " + e);
            System.exit(-1);
        }
        FenetreClient f = new FenetreClient(jetonDeJeu, output);
        String message = "";
        ThreadEcoute t = new ThreadEcoute(input, jetonDeJeu, f);
        t.start();

    }

    public void fermerSockets(){

    }

}
