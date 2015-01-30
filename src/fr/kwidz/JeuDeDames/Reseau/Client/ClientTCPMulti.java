package fr.kwidz.JeuDeDames.Reseau.Client;

import fr.kwidz.JeuDeDames.Reseau.*;
import fr.kwidz.JeuDeDames.Reseau.Serveur.ServeurTCPMulti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by kwidz on 23/01/15.
 */
public class ClientTCPMulti implements ActionListener{



    public static void main(String[] args) {


        JPanel p = new JPanel();
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Jeu de Dames En reseau");
        fenetre.setSize(610, 630);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setContentPane(p);
        fenetre.setVisible(true);


        boolean jetonDeJeu = false;
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
        String message = "";
        ThreadEcoute t = new ThreadEcoute(input, jetonDeJeu);
        t.start();

        JButton boutonJouer = new JButton("cliquez ici pour jouer un coup !");
        JLabel text = new JLabel("Bienvenue dans le jeu de Dames");
        p.add(boutonJouer);
        p.add(text);
        fenetre.setContentPane(p);





    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
