package fr.kwidz.JeuDeDames.Jeu;

import fr.kwidz.JeuDeDames.Graphisme.CaseDrawable;

import java.awt.*;
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
    ArrayList chemin = new ArrayList();

    public  EcouteCase(Case unecase, Damier undamier){
        this.lacase = unecase;
        this.leDamier = undamier;
        this.contenuCase = unecase.caseDrawableContenu;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        //chemin.addAll( this.leDamier.TrouverCheminPossible(this.contenuCase.caseX, this.contenuCase.caseY));
        if(this.lacase.pion != null){
            System.out.print("test");
            if(this.lacase.estSelectionne){
                if(this.lacase.choisissable) {
                    Case caseDepart = (Case) this.leDamier.getChemin().get(0);
                    Color c = caseDepart.caseDrawableContenu.couleurPion;
                    caseDepart.EffacerPion();
                    this.lacase.caseDrawableContenu.modifierCouleurPion(c);

                }
                this.lacase.DeSelectionner();
                chemin = leDamier.getChemin();
                for(int i=0 ; i < chemin.size() ; i++){
                    Case c = (Case)chemin.get(i);
                    c.choisissable = false;
                    c.DeSelectionner();
                }
                leDamier.EffacerChemin();






            }else{
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
            System.out.print("je rentre ici");
            if(this.lacase.estSelectionne && this.lacase.choisissable){
                Case caseDepart = (Case) this.leDamier.getChemin().get(0);
                this.lacase.pion = new Pion(caseDepart.pion.blanc);
                this.lacase.caseDrawableContenu.dessinerPion(caseDepart.caseDrawableContenu.pionPosX, caseDepart.caseDrawableContenu.pionPosY,caseDepart.caseDrawableContenu.pionWidth, caseDepart.caseDrawableContenu.pionHeight, caseDepart.caseDrawableContenu.couleurPion);
                caseDepart.EffacerPion();



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
}
