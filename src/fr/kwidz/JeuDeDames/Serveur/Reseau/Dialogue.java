package fr.kwidz.JeuDeDames.Serveur.Reseau;

import fr.kwidz.JeuDeDames.Serveur.Jeu.Jeu;


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
            System.out.print(jeu.joueur1.isPerdu(jeu.damier));
            if(jeu.joueur1.isPerdu(jeu.damier)){
                outputs.get(joueur-2).println("Perdu");
                outputs.get(joueur-2).flush();
                outputs.get(joueur-1).println("gagne");
                outputs.get(joueur-1).flush();
                supprimer(outputs.get(joueur),1);
                supprimer(outputs.get(joueur-2),2);
                System.exit(0);
            }
            else {
                outputs.get(joueur - 2).println(message);
                outputs.get(joueur - 2).flush();
            }
        }else
        {
            if(message !="joueur1" && message !="joueur2" && message != "connectionJ2" && message != "deconexion")
            jeu.jouerUnCoup(jeu.joueur1.jouerUnCoup(message));
            System.out.print(jeu.joueur1.isPerdu(jeu.damier));
            if(jeu.joueur2.isPerdu(jeu.damier)){
                outputs.get(joueur-1).println("gagne");
                outputs.get(joueur-1).flush();
                outputs.get(joueur).println("perdu");
                outputs.get(joueur).flush();
                supprimer(outputs.get(joueur),1);
                supprimer(outputs.get(joueur-2),2);
                System.exit(0);
            }
            else {
                outputs.get(joueur).println(message);
                outputs.get(joueur).flush();
            }
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
