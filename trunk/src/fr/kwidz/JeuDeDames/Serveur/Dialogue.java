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
    public ArrayList <PrintWriter> outputs = new ArrayList<PrintWriter>();

    public Dialogue(){

    }

    public void envoyer(Socket socket, String message){
        PrintWriter output = null;
        for (int i = 0; i < outputs.size(); i++) {
            //if ((Socket)lesSockets.get(i) != socket){


                outputs.get(i).println(message);
                outputs.get(i).flush();


            //}
        }
    }
}
