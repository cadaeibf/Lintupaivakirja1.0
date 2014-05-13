/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author anterova
 */
public class TallennaKirjastoXML {

    public TallennaKirjastoXML() {
    }
    
    public void kirjoita(Lintulista lintulista, File tiedosto) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            Document doc = (Document) docBuilder.newDocument();
            
            Element juuri = juuriElementti(doc);
            
            for (Lintulaji laji : lintulista.getLista()) {
                juuri.appendChild( lajiElementti(laji, doc) );
            }
            
            doc.appendChild(juuri);
            
            // kirjoita sisältö XML-tiedostoon
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = (Transformer) transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult( tiedosto );
            
            transformer.transform(source, result);
            
        } catch(Exception e) {
            
        }
        
    }
    
    private Element juuriElementti( Document doc ) throws ParserConfigurationException {
        Element juuri = doc.createElement( "kirjasto" );
        
        Attr xmlns = doc.createAttribute( "xmlns:xs" );
        xmlns.setValue( "http://www.w3.org/2001/XMLSchema" );

        Attr xsd = doc.createAttribute( "xs:schemaLocation" );
        xsd.setValue( "lajikirjasto.xsd" );

        juuri.setAttributeNode(xmlns);
        juuri.setAttributeNode(xsd);
        
        return juuri;
    }
    
    private Element lajiElementti( Lintulaji laji, Document doc ) {
        Element lajiE = doc.createElement("laji");
        
        Element nimiE = doc.createElement("nimi");
        nimiE.appendChild( doc.createTextNode( laji.getNimi() ) );
        
        Element latNimiE = doc.createElement("latNimi");
        latNimiE.appendChild( doc.createTextNode( laji.getLatNimi() ) );
        
        Element heimoE = doc.createElement("heimo");
        heimoE.appendChild( doc.createTextNode( laji.getHeimo() ) );
        
        Element lahkoE = doc.createElement("lahko");
        lahkoE.appendChild( doc.createTextNode( laji.getLahko()) );
        
        Element aaniE = doc.createElement("aanitiedosto");
        if(laji.getAaniTiedosto() != null) {
            aaniE.appendChild( doc.createTextNode( laji.getAaniTiedosto().getName() ) );
        } else {
            aaniE.appendChild( doc.createTextNode("") );
        }
        
        Element kuvatE = kuvatElementti( laji, doc );
        
        lajiE.appendChild(nimiE);
        lajiE.appendChild(latNimiE);
        lajiE.appendChild(heimoE);
        lajiE.appendChild(lahkoE);
        lajiE.appendChild(aaniE);
        lajiE.appendChild(kuvatE);
        
        return lajiE;
    }

    private Element kuvatElementti(Lintulaji laji, Document doc) {
        Element kuvatE = doc.createElement("kuvat");
        
        for (File kuvatiedosto : laji.getKuvat()) {
            Element kuvaE = doc.createElement("kuva");
            kuvaE.appendChild( doc.createTextNode( kuvatiedosto.getName() ) );
        }
        
        return kuvatE;
    }
    
}
