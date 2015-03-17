package fr.kwidz.JeuDeDames.Client.Reseau;


import fr.kwidz.JeuDeDames.Client.Graphisme.Affichage;
import fr.kwidz.JeuDeDames.Client.Graphisme.Panneau;
import fr.kwidz.JeuDeDames.Client.Graphisme.PanneauGagne;
import fr.kwidz.JeuDeDames.Client.Graphisme.PanneauPerdu;
import fr.kwidz.JeuDeDames.Serveur.Jeu.Coup;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
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

    @Override
    public void run() {

        while (tourne) {
            System.out.println(tourne);
            String message = "";
            try {



                String tmp = "";
                message = "";

                    char[] buffer = new char[5000];
                    input.read(buffer);
                    for (int i = 0;( i < buffer.length ); i++) {
                        if (buffer[i + 1] == '\0')
                            break;
                        message += buffer[i];

                    }


                System.out.println("message : " + message);
                if(message.equals("joueur1")){
                    jetonDeJeu.setJeton(false);
                    jetonDeJeu.setJoueur1(true);
                    jetonDeJeu.setMessageFenetre("Vous êtes le joueur 1");
                    System.out.println("joueur1 Thead"+jetonDeJeu.isJoueur1());
                    System.out.println("Vous êtes le joueur 1 attendez qu'un autre joueur se connecte pour pouvoir jouer !");
                    dialogue.joueur1.setJeton(true);
                }else
                if(message.equals("joueur2")){
                    jetonDeJeu.setJeton(false);
                    jetonDeJeu.setJoueur1(false);
                    jetonDeJeu.setMessageFenetre("Vous êtes le joueur 2");
                    System.out.println("Vous êtes le joueur 2 attendez que le J1 commence la partie !");
                    dialogue.joueur1.setJeton(false);
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
                else if(message.equals("gagne")){
                    jetonDeJeu.setJeton(false);
                    System.out.println("vous avez gagné !");
                    PanneauGagne p = new PanneauGagne();
                    p.repaint();
                    f.fenetre.setContentPane(p);
                    p.repaint();
                    f.fingame =true;
                    dialogue.deconexion();
                }
                else if(message.equals("perdu")){
                    jetonDeJeu.setJeton(false);
                    System.out.println("vous avez Perdu :( !");
                    PanneauPerdu p = new PanneauPerdu();
                    p.repaint();
                    f.fenetre.setContentPane(p);
                    p.repaint();
                    f.fingame =true;
                    dialogue.deconexion();
                }
                else{


                    System.out.println("Lu: " + message);
                    Coup coup = new Coup(message);

                    int xDepart, yDepart, xArrive, yArrive;

                    xDepart = coup.depart.x;
                    yDepart = coup.depart.y;
                    yArrive = coup.arrivee.y;
                    xArrive = coup.arrivee.x;

                    ArrayList prises = coup.lesprises;

                    if(coup.isDame){
                        Point dame = new Point(coup.dame);
                        f.interfacePaneau.jouerUnCoup(xDepart,yDepart,xArrive,yArrive, prises, dame);
                    }
                    else {
                        f.interfacePaneau.jouerUnCoup(xDepart, yDepart, xArrive, yArrive, prises);
                    }
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
