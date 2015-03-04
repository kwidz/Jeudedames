package fr.kwidz.JeuDeDames.Client.Reseau;

import org.jdom2.Element;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kwidz on 25/02/15.
 */
public class CoupsXML {

    public static Document getDocument(int posDepX, int posDepY, int posArrX, int posArrY, ArrayList<Point> lesPrises){
        Element racine = new Element("coup");
        Element PionJoue, PositionDepart, ligne, colone, PositionArrive, Prises, Prise;

        PionJoue = new Element("PionJoue");

        PositionDepart = new Element("PositionDepart");
        ligne = new Element("ligne");
        colone = new Element("colone");
        colone.addContent(String.valueOf(posDepX));
        ligne.addContent(String.valueOf(posDepY));
        PositionDepart.addContent(ligne);
        PositionDepart.addContent(colone);

        PositionArrive = new Element("PositionArrive");
        ligne = new Element("ligne");
        colone = new Element("colone");
        colone.addContent(String.valueOf(posArrX));
        ligne.addContent(String.valueOf(posArrY));
        PositionArrive.addContent(ligne);
        PositionArrive.addContent(colone);

        PionJoue.addContent(PositionDepart);
        PionJoue.addContent(PositionArrive);

        Prises = new Element("Prises");

        for (int i = 0; i < lesPrises.size(); i++) {
            Prise = new Element("Prise");
            ligne = new Element("ligne");
            colone = new Element("colone");
            ligne.addContent(String.valueOf(lesPrises.get(i).y));
            colone.addContent(String.valueOf(lesPrises.get(i).x));
            Prise.addContent(ligne);
            Prise.addContent(colone);
            Prises.addContent(Prise);
        }
        racine.addContent(PionJoue);
        racine.addContent(Prises);


        Document document = new Document(racine);
        return document;

    }

    public static void main(String[] args){

        ArrayList<Point> ps = new ArrayList<Point>();
        Point p;
        p = new Point(2,5);
        ps.add(p);
        p = new Point(4,5);
        ps.add(p);
        p = new Point(6,5);
        ps.add(p);
        p = new Point(8,5);
        ps.add(p);
        Document d = getDocument(1,4,9,4,ps);
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        try {
            xmlOutputter.output(d, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Document getDocument(int posDepX, int posDepY, int posArrX, int posArrY, ArrayList<Point> lesPrises, Point dame) {
        Element racine = new Element("coup");
        Element PionJoue, PositionDepart, ligne, colone, PositionArrive, Prises, Prise, Dame;

        PionJoue = new Element("PionJoue");

        PositionDepart = new Element("PositionDepart");
        ligne = new Element("ligne");
        colone = new Element("colone");
        colone.addContent(String.valueOf(posDepX));
        ligne.addContent(String.valueOf(posDepY));
        PositionDepart.addContent(ligne);
        PositionDepart.addContent(colone);

        PositionArrive = new Element("PositionArrive");
        ligne = new Element("ligne");
        colone = new Element("colone");
        colone.addContent(String.valueOf(posArrX));
        ligne.addContent(String.valueOf(posArrY));
        PositionArrive.addContent(ligne);
        PositionArrive.addContent(colone);

        PionJoue.addContent(PositionDepart);
        PionJoue.addContent(PositionArrive);

        Prises = new Element("Prises");

        for (int i = 0; i < lesPrises.size(); i++) {
            Prise = new Element("Prise");
            ligne = new Element("ligne");
            colone = new Element("colone");
            ligne.addContent(String.valueOf(lesPrises.get(i).y));
            colone.addContent(String.valueOf(lesPrises.get(i).x));
            Prise.addContent(ligne);
            Prise.addContent(colone);
            Prises.addContent(Prise);
        }
        racine.addContent(PionJoue);
        racine.addContent(Prises);

        Dame = new Element("Dame");
        ligne = new Element("ligne");
        colone = new Element("colone");
        ligne.addContent(String.valueOf(dame.y));
        colone.addContent(String.valueOf(dame.x));
        Dame.addContent(ligne);
        Dame.addContent(colone);
        racine.addContent(Dame);

        Document document = new Document(racine);
        return document;
    }
}
