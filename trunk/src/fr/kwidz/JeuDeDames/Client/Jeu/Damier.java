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
                        lesCases[i][j].piece = new Dame(true);
                        System.out.print("#");
                    }
                    else
                    if(i>5){
                        lesCases[i][j].piece = new Dame(false);
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

    public void TrouverCheminPossible(int casex, int casey, boolean blanc , Piece pieceCase){  //pour l'instant cette methode renvois une case aleatoire


        chemin.add(lesCases[casex][casey]);


        //chemin.add(lesCases[6][2]);


        if(blanc){
            if(pieceCase instanceof Pion){
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


                if(this.verification(casex,casey,-1,-1,blanc) == 2){
                    if(this.verification(casex,casey,-2,-2,blanc) ==1){
                        chemin.add(lesCases[casex-2][casey-2]);
                    }
                }

                if(this.verification(casex,casey,-1,1,blanc)==2){
                    if(this.verification(casex,casey,-2,2,blanc) == 1){
                        chemin.add(lesCases[casex-2][casey+2]);
                    }
                }
            }else{

                this.deplacementDame(casex,casey,blanc);
            }






        }else{
            if(pieceCase instanceof Pion){
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


                if(this.verification(casex,casey,1,-1,blanc)==2){
                    if(this.verification(casex,casey,2,-2,blanc)==1){
                        chemin.add(lesCases[casex+2][casey-2]);
                    }
                }


                if(this.verification(casex,casey,1,1,blanc)==2){
                    if(this.verification(casex,casey,2,2,blanc)==1){
                        chemin.add(lesCases[casex+2][casey+2]);
                    }
                }
            }else{
               this.deplacementDame(casex,casey,blanc);

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
        //Verif sorti du tableau + verif piece null
        if(((casex + i) < 10) && ((casex + i) > -1)  && ((casey + j) < 10) && ((casey + j) > -1)){
            if(lesCases[casex+i][casey+j].piece == null){
                return 1;
            }else{
                if(!(lesCases[casex+i][casey+j].piece.blanc) == blanc){
                    return 2;
                }else{
                    return 4;
                }

            }
        }
        return 3;

    }

    public boolean verifSortDuDamier(int casex, int casey, int i, int j){
        if(((casex + i) < 10) && ((casex + i) > -1)  && ((casey + j) < 10) && ((casey + j) > -1)){
            return true;
        }else{
            return false;
        }
    }



    public boolean possibilitePrendreEncore(int casex, int casey, boolean blanc){
        boolean continuer = false;
        if(this.verification(casex,casey,1,1,blanc)==2){
            if(this.verification(casex,casey,2,2,blanc)==1){
                chemin.add(lesCases[casex+2][casey+2]);
                continuer=true;
            }
        }



        if(this.verification(casex,casey,1,-1,blanc)==2){
            if(this.verification(casex,casey,2,-2,blanc)==1){
                chemin.add(lesCases[casex+2][casey-2]);
                continuer=true;
            }
        }


        if(this.verification(casex,casey,-1,-1,blanc) == 2){
            if(this.verification(casex,casey,-2,-2,blanc) ==1){
                chemin.add(lesCases[casex-2][casey-2]);
                continuer =true;
            }
        }

        if(this.verification(casex,casey,-1,1,blanc)==2){
            if(this.verification(casex,casey,-2,2,blanc) == 1){
                chemin.add(lesCases[casex-2][casey+2]);
                continuer=true;
            }
        }

        return continuer;
    }


    public void deplacementDame(int casex, int casey, boolean blanc){
        int caseXDebut = casex;
        int caseYDebut = casey;
        while(casey > -1 ){
            if(this.verifSortDuDamier(casex,casey,-1,-1)){
                if(lesCases[casex-1][casey-1].piece == null){
                    chemin.add(lesCases[casex-1][casey-1]);
                }else{
                    if(!(lesCases[casex-1][casey-1].piece.blanc) == blanc){
                        // ici je peux peut etre prendre
                    }else{
                        break;
                    }

                }

            }
            casex--;
            casey--;
        }
        casex = caseXDebut;
        casey = caseYDebut;
        while(casey < 10){
            if(this.verifSortDuDamier(casex,casey,1,1)){
                if(lesCases[casex+1][casey+1].piece == null){
                    chemin.add(lesCases[casex+1][casey+1]);
                }else{
                    if(!(lesCases[casex+1][casey+1].piece.blanc) == blanc){
                        // ici je peux peut etre prendre
                    }else{
                        break;
                    }

                }
            }
            casex++;
            casey++;
        }
        casex = caseXDebut;
        casey = caseYDebut;


        while(casex < 10 ){
            if(this.verifSortDuDamier(casex,casey,1,-1)){
                if(lesCases[casex+1][casey-1].piece == null){
                    chemin.add(lesCases[casex+1][casey-1]);
                }else{
                    if(!(lesCases[casex+1][casey-1].piece.blanc) == blanc){
                        // ici je peux peut etre prendre
                    }else{
                        break;
                    }

                }
            }
            casex++;
            casey--;
        }
        casex = caseXDebut;
        casey = caseYDebut;

        while(casex > -1 ){
            if(this.verifSortDuDamier(casex,casey,-1,1)){
                if(lesCases[casex-1][casey+1].piece == null){
                    chemin.add(lesCases[casex-1][casey+1]);
                }else{
                    if(!(lesCases[casex-1][casey+1].piece.blanc) == blanc){
                        // ici je peux peut etre prendre
                    }else{
                        break;
                    }

                }
            }
            casex--;
            casey++;
        }
        casex = caseXDebut;
        casey = caseYDebut;
    }


    //FONCTION A REFAIRE :
    public boolean possibilitePrendreEncoreDame(int ligne, int colonne, boolean blanc){
        boolean continuer = false;
        int ligneChangeante, colonneChangeant;

        colonneChangeant = colonne ;
        ligneChangeante = ligne ;
       while(colonneChangeant < 10){
           if(this.verification(ligneChangeante,colonneChangeant,1,1,blanc)==2){
               if(this.verification(ligneChangeante,colonneChangeant,2,2,blanc)==1){
                   chemin.add(lesCases[ligneChangeante+2][colonneChangeant+2]);
                   continuer=true;
               }
           }
           colonneChangeant++;
           ligneChangeante++;
       }

        colonneChangeant = colonne ;
        ligneChangeante = ligne ;
        while(colonneChangeant > -1 ){
            if(this.verification(ligneChangeante,colonneChangeant,-1,-1,blanc)==2){
                if(this.verification(ligneChangeante,colonneChangeant,-2,-2,blanc)==1){
                    chemin.add(lesCases[ligneChangeante-2][colonneChangeant-2]);
                    continuer=true;
                }
            }
            colonneChangeant--;
            ligneChangeante--;
        }


        colonneChangeant = colonne ;
        ligneChangeante = ligne ;
        while(ligneChangeante > -1 ){
            if(this.verification(ligneChangeante,colonneChangeant,-1,1,blanc)==2){
                if(this.verification(ligneChangeante,colonneChangeant,-2,2,blanc)==1){
                    chemin.add(lesCases[ligneChangeante-2][colonneChangeant+2]);
                    continuer=true;
                }
            }
            colonneChangeant++;
            ligneChangeante--;
        }

        colonneChangeant = colonne ;
        ligneChangeante = ligne ;
        while(ligneChangeante < 10 ){
            if(this.verification(ligneChangeante,colonneChangeant,1,-1,blanc)==2){
                if(this.verification(ligneChangeante,colonneChangeant,2,-2,blanc)==1){
                    chemin.add(lesCases[ligneChangeante+2][colonneChangeant-2]);
                    continuer=true;
                }
            }
            colonneChangeant--;
            ligneChangeante++;
        }


        return continuer;
    }

}
