/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo.xml;

import lipvk.ohlo.Lintulaji;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Havaintopaikka;
import lipvk.ohlo.Lintulista;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author anterova
 */
public class KirjoitaXML {
    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;

    public KirjoitaXML() {
    }
    
    public void kirjoita(Lintulista lintulista) {
        
        try {
            
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();
            
            Document doc = (Document) docBuilder.newDocument();
            
            Element juuri = luoJuuriElementti( doc );
            
            for (Lintulaji lintulaji : lintulista.getLista()) {
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
            StreamResult result = new StreamResult( new File( "/Users/anterova/Lintupaivakirja1.0/xml/havaintolista.xml" ) );
            
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException | DOMException | TransformerException ex) {
            ex.printStackTrace();
        }
        
    }
    
    private Element luoJuuriElementti( Document doc ) throws ParserConfigurationException {
        Element juuri = doc.createElement( "lista" );
        
        Attr xmlns = doc.createAttribute( "xmlns:xs" );
        xmlns.setValue( "http://www.w3.org/2001/XMLSchema" );

        Attr xsd = doc.createAttribute( "xs:noNamespaceSchemaLocation" );
        xsd.setValue( "havaintolista.xsd" );

        juuri.setAttributeNode(xmlns);
        juuri.setAttributeNode(xsd);
        
        return juuri;
    }
    
    private Element luoLajiElementti( Document doc, Lintulaji lintulaji ) {
        Element laji = doc.createElement( "laji" );
        
        laji.appendChild( doc.createTextNode( lintulaji.getNimi().toLowerCase() ) );
        
        return laji;
    }

    private Element luoHavaintoElementti(Document doc, Havainto havainto) {
        Element havaintoE = doc.createElement( "havainto" );
        
        Element paikka = doc.createElement( "paikka" );
        paikka.appendChild( doc.createTextNode( havainto.getPaikka().toString().toLowerCase() ) );
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