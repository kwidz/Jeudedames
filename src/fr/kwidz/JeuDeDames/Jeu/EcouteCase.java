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

    public  EcouteCase(Case unecase, Damier undamier){
        this.lacase = unecase;
        this.leDamier = undamier;
        this.contenuCase = unecase.caseDrawableContenu;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        ArrayList chemin = new ArrayList();
        chemin.addAll( this.leDamier.TrouverCheminPossible(this.contenuCase.caseX, this.contenuCase.caseY));
        if(this.lacase.pion != null){
            System.out.print("test");
            if(this.lacase.estSelectionne){
                this.lacase.DeSelectionner();
               for(int i=0 ; i < chemin.size() ; i++){
                   Case c = (Case)chemin.get(i);
                   c.choisissable = false;
                   c.DeSelectionner();
               }


            }else{
                this.lacase.Selectionner();
                for(int i=0 ; i < chemin.size() ; i++){
                    Case c = (Case)chemin.get(i);
                    c.choisissable = true;
                    c.Selectionner();
                }
            }
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
