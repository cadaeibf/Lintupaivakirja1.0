/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo.save;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;



/**
 *
 * @author anterova
 */
public class Lataaja  {

    public Lataaja() {
    }
    
    public Lintulista lataa( String tiedostonimi ) throws FileNotFoundException, IOException {
        String tallennuspolku = System.getProperty("user.home") + "/Documents/" + tiedostonimi;
        
        File tiedosto = new File(tallennuspolku);

        if(! tiedosto.exists() ) {
            throw new FileNotFoundException();
        }

        BufferedReader br = new BufferedReader( new FileReader( tiedosto.getAbsoluteFile() ) );

        String newLine = "";
        String text = "";
        while( (newLine = br.readLine()) != null ) {
            text += newLine;
        }

        Lintulista lista = lueXml( text );

        br.close();

        return lista;
    }

    private Lintulista lueXml(String text) {
        XStream stream = new XStream();
        stream.alias( "Lintulista", Lintulista.class );
        stream.alias( "Lintulaji", Lintulaji.class );
        stream.alias( "Havainto", Havainto.class );
        
        return (Lintulista) stream.fromXML(text);
    }
    
}
