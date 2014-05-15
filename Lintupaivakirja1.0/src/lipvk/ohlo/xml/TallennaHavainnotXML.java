/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo.xml;

import lipvk.ohlo.Lintulaji;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulista;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author anterova
 */
public class TallennaHavainnotXML {

    public TallennaHavainnotXML() {
    }
    
    public void kirjoita(Lintulista lintulista, File tiedosto) {
        
        try {
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            Document doc = (Document) docBuilder.newDocument();
            
            Element juuri = luoJuuriElementti( doc );
            
            for (Lintulaji lintulaji : lintulista.getLista()) {
                if(lintulaji.eiHavaintoja()) continue;
                Element laji = luoLajiElementti( doc, lintulaji );

                Element havainnot = doc.createElement( "havainnot" );
                
                for (Havainto havainto : lintulaji.getHavainnot()) {
                    
                    Element havaintoE = luoHavaintoElementti( doc, havainto );
                    havainnot.appendChild( havaintoE );
                    
                    laji.appendChild( havainnot );
                }

                juuri.appendChild( laji );
            }
            
            doc.appendChild( juuri );
            
            
            
            // kirjoita sisältö XML-tiedostoon
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = (Transformer) transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult( tiedosto );
            
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException | DOMException | TransformerException ex) {
            ex.printStackTrace();
        }
        
    }
    
    private Element luoJuuriElementti( Document doc ) throws ParserConfigurationException {
        Element juuri = doc.createElement( "lista" );
        
        Attr xmlns = doc.createAttribute( "xmlns:xs" );
        xmlns.setValue( "http://www.w3.org/2001/XMLSchema" );

        Attr xsd = doc.createAttribute( "xs:schemaLocation" );
        xsd.setValue( "havaintolista.xsd" );

        juuri.setAttributeNode(xmlns);
        juuri.setAttributeNode(xsd);
        
        return juuri;
    }
    
    private Element luoLajiElementti( Document doc, Lintulaji lintulaji ) {
        Element laji = doc.createElement( "laji" );
        
        Element nimi = doc.createElement( "nimi" );
        
        nimi.appendChild( doc.createTextNode( lintulaji.getNimi() ) );
        
        laji.appendChild( nimi );
        
        return laji;
    }

    private Element luoHavaintoElementti(Document doc, Havainto havainto) {
        Element havaintoE = doc.createElement( "havainto" );
        
        Element paikka = doc.createElement( "paikka" );
        paikka.appendChild( doc.createTextNode( havainto.getPaikka().toString() ) );
        havaintoE.appendChild( paikka );
        
        Element pvm = doc.createElement( "pvm" );
        pvm.appendChild( doc.createTextNode( havainto.formatoiPvmXML() ) );
        havaintoE.appendChild( pvm );

        Element lkm = doc.createElement( "lkm" );
        lkm.appendChild( doc.createTextNode( havainto.getLkm() + "" ) );
        havaintoE.appendChild( lkm );
        
        return havaintoE;
    }
    
    
}
