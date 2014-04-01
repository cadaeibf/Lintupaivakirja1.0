/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo.save;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;

/**
 *
 * @author anterova
 */
public class Tallentaja {

    public Tallentaja() {
    }
    
    private String muunnaXml(Lintulista lista) {
        XStream stream = new XStream();
        stream.alias( "Lintulista", Lintulista.class );
        stream.alias( "Lintulaji", Lintulaji.class );
        stream.alias( "Havainto", Havainto.class );
        
        return stream.toXML( lista );
    }
    
    public void tallenna(String tiedostonimi, Lintulista lista) {
        String tallennuspolku = System.getProperty("user.home") + "/Documents/" + tiedostonimi;
        
        try {
            File tiedosto = new File(tallennuspolku);
            
            if(! tiedosto.exists() ) {
                tiedosto.createNewFile();
            }
            
            
            BufferedWriter bw = new BufferedWriter( new FileWriter( tiedosto.getAbsoluteFile() ) );
            
            bw.write( muunnaXml(lista) );
            bw.close();
            
        } catch (Exception ex) {
            System.out.println("Virhe kirjoittamisessa: " + ex.getMessage());
      }
    }
    
}
