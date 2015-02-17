package fr.kwidz.JeuDeDames.Jeu;

import fr.kwidz.JeuDeDames.Graphisme.CaseDrawable;
import fr.kwidz.JeuDeDames.Reseau.Client.DialogueAvecServeur;
import fr.kwidz.JeuDeDames.Reseau.Client.GestionaireDeTours;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by morgane on 06/02/15.
 */
public class EcouteCase implements MouseListener{
    public Case lacase;
    public Damier leDamier;
    public CaseDrawable contenuCase;
    public Case caseDepart;
    public GestionaireDeTours jeton;
    public DialogueAvecServeur dialogue;
    public Boolean joueur1;
    ArrayList chemin = new ArrayList();

    public  EcouteCase(Case unecase, Damier undamier, GestionaireDeTours jeton, DialogueAvecServeur dialogue){
        this.lacase = unecase;
        this.leDamier = undamier;
        this.contenuCase = unecase.caseDrawableContenu;
        this.dialogue=dialogue;
        this.jeton=jeton;
        this.joueur1 = jeton.isJoueur1();
    }
    @Override
    public void mouseClicked(MouseEvent e) {


     /*   if(jeton.isJeton()){  // si c'est a son tour de jouer
            if(this.lacase.pion != null){
                if( (joueur1 && this.lacase.pion.blanc)  || (!joueur1 && (this.lacase.pion.blanc)==false) ){   //si il clique sur son le bon pion
                    if(this.lacase.estSelectionne) {
                        this.lacase.DeSelectionner();
                        chemin = leDamier.getChemin();
                        for (int i = 0; i < chemin.size(); i++) {
                            Case c = (Case) chemin.get(i);
                            c.choisissable = false;
                            c.DeSelectionner();
                        }
                        leDamier.EffacerChemin();
                    }else{
                        leDamier.EffacerChemin();
                        this.leDamier.TrouverCheminPossible(this.contenuCase.caseX, this.contenuCase.caseY);
                        this.lacase.Selectionner();
                        chemin = this.leDamier.getChemin();
                        for(int i=1 ; i < chemin.size() ; i++){
                            Case c = (Case)chemin.get(i);
                            c.choisissable = true;
                            c.Selectionner();
                        }
                    }




                    }else{

                }
            }else{
                if(this.lacase.estSelectionne && this.lacase.choisissable){
                    jouerUnCoups();
                }
                this.lacase.DeSelectionner();
                chemin = leDamier.getChemin();
                for(int i=0 ; i < chemin.size() ; i++){
                    Case c = (Case)chemin.get(i);
                    c.choisissable = false;
                    c.DeSelectionner();
                }
                leDamier.EffacerChemin();
            }

        }*/









       if(this.lacase.pion != null){
            System.out.print("test");
            if(this.lacase.estSelectionne){
                this.lacase.DeSelectionner();
                chemin = leDamier.getChemin();
                for(int i=0 ; i < chemin.size() ; i++){
                    Case c = (Case)chemin.get(i);
                    c.choisissable = false;
                    c.DeSelectionner();
                }
                leDamier.EffacerChemin();






            }else{
                if(!this.leDamier.getChemin().isEmpty()){
                    chemin = leDamier.getChemin();
                    for(int i=0 ; i < chemin.size() ; i++){
                        Case c = (Case)chemin.get(i);
                        c.choisissable = false;
                        c.DeSelectionner();
                    }
                    leDamier.EffacerChemin();
                }
                this.leDamier.TrouverCheminPossible(this.contenuCase.caseX, this.contenuCase.caseY);
                this.lacase.Selectionner();
                chemin = this.leDamier.getChemin();
                for(int i=1 ; i < chemin.size() ; i++){
                    Case c = (Case)chemin.get(i);
                    c.choisissable = true;
                    c.Selectionner();
                }
            }
        }else{
            if(this.lacase.estSelectionne && this.lacase.choisissable){
                jouerUnCoups();



            }
            this.lacase.DeSelectionner();
            chemin = leDamier.getChemin();
            for(int i=0 ; i < chemin.size() ; i++){
                Case c = (Case)chemin.get(i);
                c.choisissable = false;
                c.DeSelectionner();
            }
            leDamier.EffacerChemin();
        }





    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void jouerUnCoups(){
        if(jeton.isJoueur1()){
            System.out.println("HERE IS JOUEUR1");
        }else{
            System.out.println("HERE IS JOUEUR2");
        }
        if(jeton.isJeton()) {
            Case caseDepart = (Case) this.leDamier.getChemin().get(0);
            this.lacase.pion = new Pion(caseDepart.pion.blanc);
            this.lacase.caseDrawableContenu.dessinerPion(caseDepart.caseDrawableContenu.pionPosX, caseDepart.caseDrawableContenu.pionPosY, caseDepart.caseDrawableContenu.pionWidth, caseDepart.caseDrawableContenu.pionHeight, caseDepart.caseDrawableContenu.couleurPion);
            caseDepart.EffacerPion();
            String mouvement = new String("caseDepart=" + caseDepart.caseDrawableContenu.caseX + "," + caseDepart.caseDrawableContenu.caseY + ";caseArrivee=" + this.lacase.caseDrawableContenu.caseX + "," + this.lacase.caseDrawableContenu.caseY);
            System.out.println(mouvement);
            dialogue.jouerUnCoups(caseDepart.caseDrawableContenu.caseX,caseDepart.caseDrawableContenu.caseY,this.lacase.caseDrawableContenu.caseX,this.lacase.caseDrawableContenu.caseY);
            jeton.setJeton(false);
        }
    }
}
