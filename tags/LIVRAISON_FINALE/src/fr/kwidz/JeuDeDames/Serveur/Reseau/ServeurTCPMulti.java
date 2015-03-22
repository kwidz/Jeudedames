package fr.kwidz.JeuDeDames.Serveur.Reseau;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kwidz on 23/01/15.
 */
public class ServeurTCPMulti {
    public static final int portEcoute = 9876;


    public static void main(String[] args){

        Dialogue d = new Dialogue();
        ServerSocket socketServeur = null;
        try {
            socketServeur = new ServerSocket(portEcoute);
        } catch(IOException e) {
            System.err.println("Creation de la socket impossible : " + e);
            System.exit(-1);
        }

        // Attente des connexions des clients
        try {
            Socket socketClient;
            while(true) {
                socketClient = socketServeur.accept();

                ThreadConnexion t = new ThreadConnexion(socketClient, d);
                d.threads.add(t);
                t.start();
            }
        } catch(IOException e) {
            System.err.println("Erreur lors de l'attente d'une connexion : " + e);
            System.exit(-1);
        }

        // Fermeture de la socket
        try {
            socketServeur.close();
        } catch(IOException e) {
            System.err.println("Erreur lors de la fermeture de la socket : " + e);
            System.exit(-1);
        }
    }
}
