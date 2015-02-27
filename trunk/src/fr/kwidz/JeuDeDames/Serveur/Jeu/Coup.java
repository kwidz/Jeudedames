package fr.kwidz.JeuDeDames.Serveur.Jeu;
import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.output.XMLOutputter;
import org.jdom2.output.Format;
import org.jdom2.input.SAXBuilder;

import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kwidz on 27/02/15.
 */
public class Coup {
    public ArrayList<Point> lesprises = new ArrayList<Point>();
    public Point depart = new Point();
    public Point arrivee = new Point();

    public Coup(String message){

       File f = new File("/home/kwidz/Matane/Session6/JeuDeDames/src/fr/kwidz/JeuDeDames/Serveur/Jeu/test.xml");

        SAXBuilder sxb = new SAXBuilder();
        Document document = null;
        try {
            document = sxb.build(f);
        } catch(JDOMException e){
            System.err.println("Erreur lors de la lecture : " + e);
            System.exit(-1);
        } catch(IOException e) {
            System.err.println("Erreur lors de la lecture : " + e);
            System.exit(-1);
        }

        Element racine = document.getRootElement();
        Element PionJoue = (Element) racine.getChild("PionJoue");
        Element PositionDepart = (Element) PionJoue.getChild("PositionDepart");
        depart.y = Integer.parseInt(PositionDepart.getChild("ligne").getText());
        depart.x = Integer.parseInt(PositionDepart.getChildText("colone"));
        Element PositionArrive = (Element)  PionJoue.getChild("PositionArrive");
        arrivee.y = Integer.parseInt(PositionArrive.getChildText("ligne"));
        arrivee.x = Integer.parseInt(PositionArrive.getChildText("colone"));
        Element prises = (Element) racine.getChild("Prises");

        ArrayList listeDePrises = new ArrayList(prises.getChildren("Prise"));
        Iterator i = listeDePrises.iterator();
        while(i.hasNext()){
            Element courant = (Element)i.next();
            Point p = new Point(Integer.parseInt(courant.getChild("colone").getText()),Integer.parseInt(courant.getChild("ligne").getText()));
            lesprises.add(p);
        }

    }

    public String toString(){
        String chaine =  "PointDeDepart : "+depart.x+" , "+depart.y+"\n"+
                "PointDArrivee : "+arrivee.x+" , "+arrivee.y+"\n"+"Les prises : \n"
        ;
        for (int i = 0; i < lesprises.size(); i++) {
            chaine+=lesprises.get(i).x+" , "+lesprises.get(i).y+"\n";
        }
        return chaine;
    }


}
