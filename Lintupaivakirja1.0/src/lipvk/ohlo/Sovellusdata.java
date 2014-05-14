/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo;

import java.io.File;
import lipvk.ohlo.xml.LataaKirjastoXML;
import lipvk.ohlo.xml.TallennaKirjastoXML;

/**
 *
 * @author anterova
 */
public class Sovellusdata {
    private File kirjasto;

    public Sovellusdata() {
    }
    
    public void lataa() {
        kirjasto = new File("kirjasto/lajikirjasto.xml");
    }
    
    public Lintulista luoLintulista() {
        Lintulista lintulista = new LataaKirjastoXML().lataa(kirjasto);
        
        return lintulista;
    }
    
    public void tallennaKirjasto(Lintulista lintulista) {
        new TallennaKirjastoXML().kirjoita(lintulista, kirjasto);
    }
    
    public String kirjastoSijainti() {
        return kirjasto.getAbsolutePath();
    }
    
}
