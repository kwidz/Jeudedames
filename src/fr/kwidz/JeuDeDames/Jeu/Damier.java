package fr.kwidz.JeuDeDames.Jeu;



/**
 * Created by kwidz on 27/01/15.
 */
public class Damier {
    Case[][] lesCases = new Case[10][10]; //Le dammier contient un tableau de 10*10 cases
    public Damier(){
        boolean white=true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (white) {
                    lesCases[i][j] = new CaseBlanche();
                    white = !white;
                }
                else {
                    lesCases[i][j] = new CaseNoire();
                    white = !white;
                }


            }
        }
    }
}
