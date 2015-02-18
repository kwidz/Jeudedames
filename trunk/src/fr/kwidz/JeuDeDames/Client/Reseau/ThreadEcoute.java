package fr.kwidz.JeuDeDames.Client.Reseau;


import fr.kwidz.JeuDeDames.Client.Graphisme.Affichage;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.StringTokenizer;

/**
 * Created by kwidz on 23/01/15.
 */
public class ThreadEcoute extends Thread{

    BufferedReader input;
    public GestionaireDeTours jetonDeJeu;
    public Affichage f;
    private DialogueAvecServeur dialogue;
    private boolean tourne = true;

    public void setTourne(boolean tourne) {
        this.tourne = tourne;
    }

    public ThreadEcoute(BufferedReader input, GestionaireDeTours jetonDeJeu, Affichage f, DialogueAvecServeur dialogue) {
        this.input=input;this.jetonDeJeu=jetonDeJeu;
        this.f = f;
        this.dialogue=dialogue;
    }
/*
*
* TODO : Améliorer le mvc pour éviter de changer le texte de la fenetre directement dans cette classe.
*
* */
    @Override
    public void run() {

        while (tourne) {
            System.out.println(tourne);
            String message = "";
            try {
                message = input.readLine();
                System.out.println("message : " + message);
                if(message.equals("joueur1")){
                    jetonDeJeu.setJeton(false);
                    jetonDeJeu.setJoueur1(true);
                    System.out.println("joueur1 Thead"+jetonDeJeu.isJoueur1());
                    System.out.println("Vous êtes le joueur 1 attendez qu'un autre joueur se connecte pour pouvoir jouer !");
                }else
                if(message.equals("joueur2")){
                    jetonDeJeu.setJeton(false);
                    jetonDeJeu.setJoueur1(false);
                    System.out.println("Vous êtes le joueur 2 attendez que le J1 commence la partie !");
                }else
                if(message.equals("connectionJ2")){
                    jetonDeJeu.setJeton(true);
                    System.out.println("Un joueur s'est connecté a vous de jouer !");
                }else
                if(message.equals("deconexion")){
                    jetonDeJeu.setJeton(true);
                    System.out.println("L'adversaire s'est déconecté ! vous avez gagné !");
                    dialogue.deconexion();
                }
                else{
                    System.out.println("Lu: " + message);
                    StringTokenizer coordonnees = new StringTokenizer(message,";");
                    int xDepart, yDepart, xArrive, yArrive;
                    StringTokenizer xyDepart = new StringTokenizer(coordonnees.nextToken(),",");
                    StringTokenizer xyArrive = new StringTokenizer(coordonnees.nextToken(),",");
                    xDepart = Integer.parseInt(xyDepart.nextToken());
                    yDepart = Integer.parseInt(xyDepart.nextToken());
                    xArrive = Integer.parseInt(xyArrive.nextToken());
                    yArrive = Integer.parseInt(xyArrive.nextToken());

                    f.interfacePaneau.jouerUnCoup(xDepart,yDepart,xArrive,yArrive);
                    jetonDeJeu.setJeton(true);
                    System.out.println("l'adversaire a joué, c'est a vous !");
                }
            } catch (SocketException e){
                System.err.println("Erreur lors de la lecture : " + e);
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture : " + e);
                System.exit(-1);

            }

        }
        System.out.print("##########################");
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
