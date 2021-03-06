/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo.xml;

import java.io.File;
import java.util.Calendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Havaintopaikka;
import lipvk.ohlo.Lintulista;
import lipvk.util.Pvm;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author anterova
 */
public class LataaHavainnotXML {

    public LataaHavainnotXML() {
    }
    
    public void lue(File tiedosto, Lintulista lintulista) {
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document doc = db.parse( tiedosto );
            
            doc.normalize();
            
            NodeList lajit = doc.getElementsByTagName( "laji" );
            
            if( lajit.getLength() == 0 ) return;
            
            lueLajit(lintulista, lajit);
            
        } catch( Exception ex ) {
        }
    }
    
    private void lueLajit( Lintulista lintulista, NodeList lajit ) {

        for (int i = 0; i < lajit.getLength(); i++) {
            Node laji = lajit.item(i);
            if( laji.getNodeType() != Node.ELEMENT_NODE ) continue;
            Element e = (Element) laji;
            
            // Lisää lintulaji listaan
            Element nimiE =  (Element) e.getElementsByTagName( "nimi" ).item(0);
            String nimi = nimiE.getChildNodes().item(0).getNodeValue();
            
            // Lisää lintulajin havainnot
            
            Element havainnotE = (Element) e.getElementsByTagName( "havainnot" ).item(0);
            NodeList havainnot = havainnotE.getChildNodes();
            for (int j = 0; j < havainnot.getLength(); j++) {
                if(lintulista.sisaltaa(nimi)) lintulista.lisaaHavainto(nimi, lueHavainto( (Element) havainnot.item(j) ) );
            }
            
        }
    }
    
    private Havainto lueHavainto( Element havaintoE ) {
        NodeList tiedot = havaintoE.getChildNodes();
        
        // Lue havaintopaikka
        Element paikkaE = (Element) tiedot.item(0);
        String paikka = paikkaE.getChildNodes().item(0).getNodeValue();
        
        Havaintopaikka havaintopaikka = new Havaintopaikka(paikka);
        
        // Lue päivämäärä
        Element pvmE = (Element) tiedot.item(1);
        String[] pvmData = pvmE.getChildNodes().item(0).getNodeValue().split("-");
        
        int vuosi = Integer.parseInt( pvmData[0] );
        int kuukausi = Integer.parseInt( pvmData[1] );
        int paiva = Integer.parseInt( pvmData[2] );
        
        Calendar pvm = new Pvm().uusi(vuosi, kuukausi, paiva);
        
        // Lue lukumäärä
        Element lkmE = (Element) tiedot.item( 2 );
        int lkm = Integer.parseInt( lkmE.getChildNodes().item(0).getNodeValue() );
        
        Havainto havainto = new Havainto(havaintopaikka, pvm, lkm);
        System.out.println("\tHavainto " + havainto + " lisätty");
        return havainto;
    }
    
}
