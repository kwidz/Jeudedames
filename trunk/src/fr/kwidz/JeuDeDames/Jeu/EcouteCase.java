package fr.kwidz.JeuDeDames.Jeu;

import fr.kwidz.JeuDeDames.Graphisme.CaseDrawable;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        if(this.lacase.pion != null){
            System.out.print("test");
            if(this.lacase.estSelectionne){
                this.lacase.DeSelectionner();
                this.contenuCase.setBackground(Color.black);
            }else{
                this.lacase.Selectionner();
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
