package fr.kwidz.JeuDeDames.Client.Jeu;

import fr.kwidz.JeuDeDames.Client.Graphisme.CaseDrawable;
import fr.kwidz.JeuDeDames.Client.Reseau.DialogueAvecServeur;
import fr.kwidz.JeuDeDames.Client.Reseau.GestionaireDeTours;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by morgane on 06/02/15.
 */
public class EcouteCase implements MouseListener {
    public Case lacase;
    public Damier leDamier;
    public CaseDrawable contenuCase;
    public Case caseDepart;
    public GestionaireDeTours jeton;
    public DialogueAvecServeur dialogue;
    public Boolean joueur1;
    ArrayList chemin = new ArrayList();


    public EcouteCase(Case unecase, Damier undamier, GestionaireDeTours jeton, DialogueAvecServeur dialogue) {
        this.lacase = unecase;
        this.leDamier = undamier;
        this.contenuCase = unecase.caseDrawableContenu;
        this.dialogue = dialogue;
        this.jeton = jeton;

    }

    @Override
    public void mouseClicked(MouseEvent e) {


        System.out.println("dans ecoute case :" + this.jeton.isJoueur1());


        if (jeton.isJeton()) {
            if (this.peutJoueur()) {
                this.pionPris();
                jouerUnCoups();
                this.lacase.DeSelectionner();
                chemin = leDamier.getChemin();
                for (int i = 0; i < chemin.size(); i++) {
                    Case c = (Case) chemin.get(i);
                    c.choisissable = false;
                    c.DeSelectionner();
                }
                leDamier.EffacerChemin();
            } else{
                if (this.estSelectionnable()) {
                    chemin = leDamier.getChemin();
                    for (int i = 0; i < chemin.size(); i++) {
                        Case c = (Case) chemin.get(i);
                        c.choisissable = false;
                        c.DeSelectionner();
                    }
                    leDamier.EffacerChemin();
                    this.leDamier.TrouverCheminPossible(this.contenuCase.caseX, this.contenuCase.caseY, this.jeton.isJoueur1(), this.lacase.piece);
                    this.lacase.Selectionner();
                    chemin = this.leDamier.getChemin();
                    for (int i = 1; i < chemin.size(); i++) {
                        Case c = (Case) chemin.get(i);
                        c.choisissable = true;
                        c.Selectionner();
                    }
                } else {
                    this.lacase.DeSelectionner();
                    chemin = leDamier.getChemin();
                    for (int i = 0; i < chemin.size(); i++) {
                        Case c = (Case) chemin.get(i);
                        c.choisissable = false;
                        c.DeSelectionner();
                    }
                    leDamier.EffacerChemin();
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

    private void jouerUnCoups() {
        if (jeton.isJeton()) {
            Case caseDepart = (Case) this.leDamier.getChemin().get(0);
            if(verificationDame(this.lacase.caseDrawableContenu.caseX)){
                this.lacase.piece = new Dame(caseDepart.piece.blanc);
                Coups.dameFaite = true;
                Coups.coordonneeDame = new Point(this.lacase.caseDrawableContenu.caseX, this.lacase.caseDrawableContenu.caseY);
            }else{
                this.lacase.piece = caseDepart.piece;
                        //new Pion(caseDepart.piece.blanc);
            }

            this.lacase.caseDrawableContenu.dessinerPion(caseDepart.caseDrawableContenu.pionPosX, caseDepart.caseDrawableContenu.pionPosY, caseDepart.caseDrawableContenu.pionWidth, caseDepart.caseDrawableContenu.pionHeight, caseDepart.caseDrawableContenu.couleurPion, this.lacase.piece);
            caseDepart.effacerPiece();
            if(this.lacase.piece instanceof Dame){
                Coups.coordonneeDame = new Point(this.lacase.caseDrawableContenu.caseX, this.lacase.caseDrawableContenu.caseY);
                System.out.print("Coordonnee Dame = "+Coups.coordonneeDame.x+"et le y"+Coups.coordonneeDame.y);
            }


            System.out.println("pions pris : ");
            for(int i = 0 ; i< Coups.pionPris.size() ; i++){
                Point p = (Point)Coups.pionPris.get(i);
                System.out.println("pX="+p.x+"pY"+p.y);
                this.leDamier.lesCases[p.x][p.y].effacerPiece();
            }

            String mouvement = new String("caseDepart=" + caseDepart.caseDrawableContenu.caseX + "," + caseDepart.caseDrawableContenu.caseY + ";caseArrivee=" + this.lacase.caseDrawableContenu.caseX + "," + this.lacase.caseDrawableContenu.caseY);
            System.out.println(mouvement);


// Attention le joueur peut jouer une deuxieme fois sans prendre forcement le pion
            if(Coups.pionPris.size()>0 && this.leDamier.possibilitePrendreEncore(this.lacase.caseDrawableContenu.caseX, this.lacase.caseDrawableContenu.caseY, jeton.isJoueur1())){
                this.lacase.Selectionner();
                chemin = this.leDamier.getChemin();
                for (int i = 1; i < chemin.size(); i++) {
                    Case c = (Case) chemin.get(i);
                    c.choisissable = true;
                    c.Selectionner();
                }
                if(Coups.caseDepart == null){
                    Coups.caseDepart = caseDepart;
                }
                if(this.lacase.piece instanceof Dame){
                    Coups.coordonneeDame = new Point(this.lacase.caseDrawableContenu.caseX, this.lacase.caseDrawableContenu.caseY);
                }

                System.out.print("Possibilte encore!");
            }else{
                if(Coups.caseDepart != null){
                    System.out.println("case DepartX :" + Coups.caseDepart.caseDrawableContenu.caseX + "case departY" + Coups.caseDepart.caseDrawableContenu.caseY+"case arrive x"+this.lacase.caseDrawableContenu.caseX+"case arrive y"+this.lacase.caseDrawableContenu.caseY);
                    dialogue.jouerUnCoups(Coups.caseDepart.caseDrawableContenu.caseX, Coups.caseDepart.caseDrawableContenu.caseY, this.lacase.caseDrawableContenu.caseX, this.lacase.caseDrawableContenu.caseY, Coups.pionPris);
                    Coups.caseDepart = null;
                }else{
                    System.out.println("case DepartX :" + caseDepart.caseDrawableContenu.caseX + "case departY" + caseDepart.caseDrawableContenu.caseY+"case arrive x"+this.lacase.caseDrawableContenu.caseX+"case arrive y"+this.lacase.caseDrawableContenu.caseY);

                    if(Coups.dameFaite){
                        dialogue.jouerUnCoups(caseDepart.caseDrawableContenu.caseX, caseDepart.caseDrawableContenu.caseY, this.lacase.caseDrawableContenu.caseX, this.lacase.caseDrawableContenu.caseY, Coups.pionPris, Coups.coordonneeDame);
                    }else{
                        dialogue.jouerUnCoups(caseDepart.caseDrawableContenu.caseX, caseDepart.caseDrawableContenu.caseY, this.lacase.caseDrawableContenu.caseX, this.lacase.caseDrawableContenu.caseY, Coups.pionPris);
                    }
                    Coups.dameFaite = false;
                    Coups.caseDepart = null;
                }

                Coups.pionPris.clear();
                jeton.setJeton(false);
            }

        }
    }


    public boolean peutJoueur() {
        if (this.lacase.estSelectionne && this.lacase.choisissable && (this.lacase.piece == null)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estSelectionnable() {

        if (lacase.piece != null) {
            if (jeton.isJoueur1()) {
                if (lacase.piece.blanc) {
                    if (this.lacase.estSelectionne == false) {
                        return true;
                    }
                }
            } else {
                if (lacase.piece.blanc == false) {
                    if (this.lacase.estSelectionne == false) {
                        return true;
                    }
                }
            }
        }
        return false;


    }

    public void pionPris() {
        Case caseDepart = (Case) this.leDamier.getChemin().get(0);
        if(((caseDepart.caseDrawableContenu.caseX + 2)  == (this.lacase.caseDrawableContenu.caseX))  && ((caseDepart.caseDrawableContenu.caseY + 2)  == (this.lacase.caseDrawableContenu.caseY)) ){
            Point p = new Point((caseDepart.caseDrawableContenu.caseX + 1),(caseDepart.caseDrawableContenu.caseY + 1));
            Coups.pionPris.add(p);
        }

        if(((caseDepart.caseDrawableContenu.caseX + 2)  == (this.lacase.caseDrawableContenu.caseX))  && ((caseDepart.caseDrawableContenu.caseY - 2)  == (this.lacase.caseDrawableContenu.caseY)) ){
            Point p = new Point((caseDepart.caseDrawableContenu.caseX + 1),(caseDepart.caseDrawableContenu.caseY - 1));
            Coups.pionPris.add(p);
        }

        if(((caseDepart.caseDrawableContenu.caseX - 2)  == (this.lacase.caseDrawableContenu.caseX))  && ((caseDepart.caseDrawableContenu.caseY - 2)  == (this.lacase.caseDrawableContenu.caseY)) ){
            Point p = new Point((caseDepart.caseDrawableContenu.caseX - 1),(caseDepart.caseDrawableContenu.caseY - 1));
            Coups.pionPris.add(p);
        }

        if(((caseDepart.caseDrawableContenu.caseX - 2)  == (this.lacase.caseDrawableContenu.caseX))  && ((caseDepart.caseDrawableContenu.caseY + 2)  == (this.lacase.caseDrawableContenu.caseY)) ){
            Point p = new Point((caseDepart.caseDrawableContenu.caseX - 1),(caseDepart.caseDrawableContenu.caseY + 1));
            Coups.pionPris.add(p);
        }
    }

    public boolean verificationDame(int x){
        if(jeton.isJoueur1()){
            if(x>8){
                return true;
            }
        }else{
            if(x<1){
                return true;
            }
        }
        return false;
    }
}
