package fr.kwidz.JeuDeDames.Client.Reseau;


import fr.kwidz.JeuDeDames.Client.Reseau.ThreadEcoute;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

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
    public void jouerUnCoups(int caseDepartX, int caseDepartY, int caseArriveX, int caseArriveY,ArrayList<Point> lesPrises) {

        Document d = CoupsXML.getDocument(caseDepartX, caseDepartY, caseArriveX, caseArriveY, lesPrises);

        XMLOutputter xmlOutputter = new XMLOutputter(Format.getCompactFormat());
        try {
            xmlOutputter.output(d, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

        output.flush();
    }



}
