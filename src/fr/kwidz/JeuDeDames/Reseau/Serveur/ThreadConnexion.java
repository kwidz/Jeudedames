package fr.kwidz.JeuDeDames.Reseau.Serveur;

import java.io.*;
import java.net.Socket;

/**
 * Created by kwidz on 23/01/15.
 */
public class ThreadConnexion extends Thread{

    private BufferedReader input;
    private PrintWriter output;
    private Socket socketClient;
    private Dialogue d;
    private int joueur;

    public ThreadConnexion(Socket socketClient, Dialogue d) {
        this.d = d;
        this.socketClient = socketClient;

        // Association d'un flux d'entree et de sortie
        try {
            input = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            output = new PrintWriter(socketClient.getOutputStream());

            d.outputs.add(output);
        } catch(IOException e) {
            System.err.println("Association des flux impossible : " + e);
            System.exit(-1);
        }
        String player="";
        if(d.outputs.size()%2==0){
            player="joueur2";
        }
        else{
            player="joueur1";
        }
        this.joueur=d.outputs.size();
        output.print(player);
        output.flush();
        if(player=="joueur2"){
            d.envoyer("connectionJ2",output,this.joueur);
        }
    }


    @Override
    public void run() {

        while(true) {
            String message = "";
            try {
                message = input.readLine();
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture : " + e);
                System.exit(-1);
            }
            System.out.println("Lu: " + message);



            System.out.println("Envoi: " + message);
            d.envoyer(message, output,joueur);

        }
    }
}
