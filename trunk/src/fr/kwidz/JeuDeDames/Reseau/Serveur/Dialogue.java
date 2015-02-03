package fr.kwidz.JeuDeDames.Reseau.Serveur;

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

    public void envoyer(String message, PrintWriter myOutput, int joueur){
        PrintWriter output = null;
        /*for (int i = 0; i < outputs.size(); i++) {
            if (outputs.get(i) != myOutput){


                outputs.get(i).println(message);
                outputs.get(i).flush();


            }
        }*/
        if (joueur%2==0){
            outputs.get(joueur-2).println(message);
            outputs.get(joueur-2).flush();
        }else
        {
            outputs.get(joueur).println(message);
            outputs.get(joueur).flush();
        }
    }
}
