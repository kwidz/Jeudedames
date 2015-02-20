package fr.kwidz.JeuDeDames.Client.Jeu;


import java.util.ArrayList;

/**
 * Created by kwidz on 27/01/15.
 */
public class Damier {
    public Case[][] lesCases = new Case[10][10]; //Le dammier contient un tableau de 10*10 cases
    ArrayList<Case> chemin = new ArrayList<Case>();
    public Damier(){
        boolean white=true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (white) {
                    lesCases[i][j] = new CaseBlanche();
                    white = !white;
                    System.out.print("O");
                }
                else {
                    lesCases[i][j] = new CaseNoire();
                    if(i<4){
                        lesCases[i][j].pion = new Pion(true);
                        System.out.print("#");
                    }
                    else
                    if(i>5){
                        lesCases[i][j].pion = new Pion(false);
                        System.out.print("#");
                    }
                    else{
                        System.out.print("0");
                    }

                    white = !white;
                }


            }
            System.out.println();
            white=!white;
        }
    }

    public void TrouverCheminPossible(int casex, int casey, boolean blanc){  //pour l'instant cette methode renvois une case aleatoire

      /*  chemin.add(lesCases[casex][casey]);
        chemin.add(lesCases[casex+1][casey+1]);
        chemin.add(lesCases[casex-1][casey+1]);
        chemin.add(lesCases[casex-1][casey-1]);
        chemin.add(lesCases[casex+1][casey-1]);*/
        chemin.add(lesCases[casex][casey]);

        //chemin.add(lesCases[0][1]);
        //System.out.print("dammier"+blanc);

        if(blanc){




            if(this.verification(casex,casey,1,1,blanc)==1){
                chemin.add(lesCases[casex+1][casey+1]);
            }else if(this.verification(casex,casey,1,1,blanc)==2){
                if(this.verification(casex,casey,2,2,blanc)==1){
                    chemin.add(lesCases[casex+2][casey+2]);
                }
            }



            if(this.verification(casex,casey,1,-1,blanc)==1){
                chemin.add(lesCases[casex+1][casey-1]);
            }else if(this.verification(casex,casey,1,-1,blanc)==2){
                if(this.verification(casex,casey,2,-2,blanc)==1){
                    chemin.add(lesCases[casex+2][casey-2]);
                }
            }


        }else{





            if(this.verification(casex,casey,-1,-1,blanc) == 1){
                chemin.add(lesCases[casex-1][casey-1]);
            }else if(this.verification(casex,casey,-1,-1,blanc) == 2){
                if(this.verification(casex,casey,-2,-2,blanc) ==1){
                    chemin.add(lesCases[casex-2][casey-2]);
                }
            }



            if(this.verification(casex,casey,-1,1,blanc)==1){
                chemin.add(lesCases[casex-1][casey+1]);
            }else  if(this.verification(casex,casey,-1,1,blanc)==2){
                if(this.verification(casex,casey,-2,2,blanc) == 1){
                    chemin.add(lesCases[casex-2][casey+2]);
                }
            }


        }




    }

    public ArrayList<Case> getChemin(){
        return this.chemin;
    }

    public void EffacerChemin(){
        this.chemin = new ArrayList<Case>();
    }

    public int verification(int casex, int casey, int i, int j, boolean blanc){
        //Verif sorti du tableau + verif pion null
        if(((casex + i) < 10) && ((casex + i) > -1)  && ((casey + j) < 10) && ((casey + j) > -1)){
            if(lesCases[casex+i][casey+j].pion == null){
                return 1;
            }else{
                if(!(lesCases[casex+i][casey+j].pion.blanc) == blanc)
                return 2;
            }
        }
        return 3;

    }

}
