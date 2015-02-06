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
    public int joueur;

    public ThreadConnexion(Socket socketClient, Dialogue d) {
        this.d = d;
        this.socketClient = socketClient;
        System.out.println("connection d'un client");
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
            System.out.println("le joueur 2 arrive");
        }
        else{
            player="joueur1";
            System.out.println("le joueur 1 arrive");

        }
        this.joueur=d.outputs.size();
        if(player.equals("joueur1"))
            d.envoyer(player,output,joueur+1);
        else
            d.envoyer(player,output,joueur-1);

        if(player.equals("joueur2")){
            System.out.println("le joueur 2 se connecte");
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
            if(message==null){
                System.out.println("Deconnexion d'un joueur");
                d.envoyer("deconexion", output, joueur);
                try {
                    input.close();
                    output.close();
                    socketClient.close();

                } catch (IOException e) {
                    System.err.println("Erreur lors de la fermeture des flux et des sockets : " + e);
                    System.exit(-1);
                }
                d.supprimer(output, joueur);
                System.out.println(d.outputs);
                break;
            }
            else {
                System.out.println("Envoi: " + message);
                d.envoyer(message, output, joueur);
            }
        }
    }
}
