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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kwidz on 27/02/15.
 */
public class Coup {
    public ArrayList<Point> lesprises = new ArrayList<Point>();
    public Point depart = new Point();
    public Point arrivee = new Point();
    public Point dame = new Point();
    boolean isDame = false;

    public Coup(String message){





        SAXBuilder sxb = new SAXBuilder();
        Document document = null;
        try {
            document = sxb.build(new ByteArrayInputStream(message.getBytes()));
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

        Element Dame = (Element) racine.getChild("Dame");
        if(Dame.getContentSize() != 0){
            isDame = true;
            dame.y = Integer.parseInt(Dame.getChild("ligne").getText());
            dame.x = Integer.parseInt(Dame.getChild("colone").getText());
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
