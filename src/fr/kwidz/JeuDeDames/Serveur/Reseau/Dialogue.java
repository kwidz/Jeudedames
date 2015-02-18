package fr.kwidz.JeuDeDames.Serveur;

import fr.kwidz.JeuDeDames.Serveur.Jeu.Jeu;
import fr.kwidz.JeuDeDames.Serveur.Reseau.ThreadConnexion;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by kwidz on 23/01/15.
 */
public class Dialogue {
    public ArrayList <PrintWriter> outputs = new ArrayList<PrintWriter>();
    public ArrayList<ThreadConnexion> threads = new ArrayList<ThreadConnexion>();
    public Jeu jeu;

    public Dialogue(){

        jeu = new Jeu();

    }

    public void envoyer(String message, PrintWriter myOutput, int joueur){
        PrintWriter output = null;

        if (joueur%2==0){
            if(message !="joueur1" && message !="joueur2" && message != "connectionJ2" && message != "deconexion")
            jeu.jouerUnCoup(jeu.joueur2.jouerUnCoup(message));

            outputs.get(joueur-2).println(message);
            outputs.get(joueur-2).flush();
        }else
        {
            if(message !="joueur1" && message !="joueur2" && message != "connectionJ2" && message != "deconexion")
            jeu.jouerUnCoup(jeu.joueur1.jouerUnCoup(message));
            outputs.get(joueur).println(message);
            outputs.get(joueur).flush();
        }
        for (int i = 0; i < threads.size(); i++) {
            System.out.println(threads.get(i).joueur+" ");
        }
    }

    public void supprimer(PrintWriter output, int joueur) {
        if(outputs.indexOf(output) != -1) {
            System.out.println("deconexion########################");
            if (joueur % 2 == 0) {

                outputs.remove(joueur - 2);
                outputs.remove(output);
               /* for (int i = joueur; i < threads.size(); i++) {
                    threads.get(i).joueur-=2;
                }*/
                for (int i = joueur; i < threads.size(); i++) {
                    threads.get(i).joueur-=2;
                }
                threads.remove(joueur-2);
                threads.remove(joueur-1);

            } else {
                outputs.remove(joueur);
                outputs.remove(output);
                for (int i = joueur+1; i < threads.size(); i++) {
                    threads.get(i).joueur-=2;
                }
                threads.remove(joueur);
                threads.remove(joueur-1);

            }
        }
        for (int i = 0; i < threads.size(); i++) {
            System.out.println(threads.get(i).joueur+" ");
        }
    }
}
