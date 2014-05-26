/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author anterova
 */
public class LataaKirjastoXML {

    public LataaKirjastoXML() {
    }
    
    public Lintulista lataa(File tiedosto) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document doc = db.parse( tiedosto );
            
            doc.normalize();
            
            NodeList lajit = doc.getElementsByTagName("laji");
            
            if(lajit.getLength() == 0) return new Lintulista();
            
            return lueLajit(lajit);
            
        } catch(Exception ex) {
            
        }
        
        return new Lintulista();
    }
    
    private Lintulista lueLajit( NodeList lajit ) {
        Lintulista lintulista = new Lintulista();

        for (int i = 0; i < lajit.getLength(); i++) {
            Node laji = lajit.item(i);
            if( laji.getNodeType() != Node.ELEMENT_NODE ) continue;
            Element e = (Element) laji;
            
            // Lisää lintulaji listaan
            Element nimiE =  (Element) e.getElementsByTagName( "nimi" ).item(0);
            String nimi = nimiE.getChildNodes().item(0).getNodeValue();
            Lintulaji uusi = new Lintulaji( nimi );
            
            // Lisää lintulajin tiedot
            Element latNimiE = (Element) e.getElementsByTagName("latNimi").item(0);
            String latNimi = latNimiE.getChildNodes().item(0).getNodeValue();
            uusi.setLatNimi(latNimi);
            
            Element heimoE = (Element) e.getElementsByTagName("heimo").item(0);
            String heimo = heimoE.getChildNodes().item(0).getNodeValue();
            
            Element lahkoE = (Element) e.getElementsByTagName("lahko").item(0);
            String lahko = lahkoE.getChildNodes().item(0).getNodeValue();
            
            Element kuvatE = (Element) e.getElementsByTagName("kuvat").item(0);
            if(kuvatE.hasChildNodes()) {
                Element kuvaE = (Element) e.getElementsByTagName("kuva").item(0);
                String tiedostonimi = kuvaE.getChildNodes().item(0).getNodeValue();
                
                File kuvatiedosto = new File("kirjasto/kuvat/" + tiedostonimi);
                if( kuvatiedosto.exists() ) uusi.lisaaKuva(kuvatiedosto);
            }
            
            uusi.setLatNimi(latNimi);
            uusi.setHeimo(heimo);
            uusi.setLahko(lahko);
            
            lintulista.lisaa(uusi);
        }
        
        return lintulista;
    }
    
}
