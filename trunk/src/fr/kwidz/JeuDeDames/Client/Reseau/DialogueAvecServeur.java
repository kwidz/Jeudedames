package fr.kwidz.JeuDeDames.Client.Reseau;


import fr.kwidz.JeuDeDames.Client.Reseau.ThreadEcoute;

import java.io.*;
import java.net.Socket;

/**
 * Created by kwidz on 04/02/15.
 */
public class DialogueAvecServeur {
    PrintWriter output = null;
    Socket socket = null;
    InputStream input = null;
    private ThreadEcoute thread;

    public void setThread(ThreadEcoute thread) {
        this.thread = thread;
    }


    public DialogueAvecServeur(Socket socket){

        this.socket = socket;
        try {
            input = socket.getInputStream();
            output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deconexion() {
        // Fermeture des flux et des sockets
        thread.setTourne(false);

        try {
            input.close();
            output.close();
            socket.close();

        } catch (IOException e) {
            System.err.println("Erreur lors de la fermeture des flux et des sockets : " + e);
            System.exit(-1);
        }
    }

    public void jouerUnCoups(int caseDepartX, int caseDepartY, int caseArriveX, int caseArriveY) {
        output.println(caseDepartX+","+caseDepartY+";"+caseArriveX+","+caseArriveY);
        output.flush();
    }
}
