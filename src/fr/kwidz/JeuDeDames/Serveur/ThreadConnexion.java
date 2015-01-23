package fr.kwidz.JeuDeDames.Serveur;

import java.io.*;
import java.net.Socket;

/**
 * Created by kwidz on 23/01/15.
 */
public class ThreadConnexion extends Thread{

    private BufferedReader input;
    private PrintWriter output;
    private Socket socketClient;

    public ThreadConnexion(Socket socketClient) {
        this.socketClient = socketClient;

        // Association d'un flux d'entree et de sortie
        try {
            input = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream())), true);
        } catch(IOException e) {
            System.err.println("Association des flux impossible : " + e);
            System.exit(-1);
        }
    }


    @Override
    public void run() {

        System.out.println("test");
    }
}
