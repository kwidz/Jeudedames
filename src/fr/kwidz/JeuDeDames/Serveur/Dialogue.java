package fr.kwidz.JeuDeDames.Serveur;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by kwidz on 23/01/15.
 */
public class Dialogue {
    public PrintWriter[] outputs = new PrintWriter[3];

    public Dialogue(){

    }

    public void envoyer(Socket socket, String message){
        PrintWriter output = null;
        for (int i = 0; i < outputs.length; i++) {
            //if ((Socket)lesSockets.get(i) != socket){


                outputs[0].println(message);
                outputs[0].flush();


            //}
        }
    }
}
