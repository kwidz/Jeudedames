package fr.kwidz.JeuDeDames.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by kwidz on 23/01/15.
 */
public class ThreadEcoute extends Thread{

    BufferedReader input;

    public ThreadEcoute(BufferedReader input) {
        this.input=input;
    }

    @Override
    public void run() {

        while (true) {
            String message = "";
            try {
                message = input.readLine();
                System.out.println("Lu: " + message);
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture : " + e);
                System.exit(-1);

            }

        }
    }
}
