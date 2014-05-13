/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        valitseKirjasto();
    }
    
    public Lintulista luoLintulista() {
        Lintulista lintulista = new LataaKirjastoXML().lataa(kirjasto);
        
        return lintulista;
    }
    
    public void tallennaKirjasto(Lintulista lintulista) {
        new TallennaKirjastoXML().kirjoita(lintulista, kirjasto);
    }

    private void valitseKirjasto() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Valitse kirjasto");
        fileChooser.setFileFilter( new FileNameExtensionFilter("xml tiedostot", "xml") );
        
        int returVal = fileChooser.showDialog(null , "Valitse");
        
        if (returVal == JFileChooser.APPROVE_OPTION) {
            kirjasto = fileChooser.getSelectedFile();
            
        }
        
        
    }
}
