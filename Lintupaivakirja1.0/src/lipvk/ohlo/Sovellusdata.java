/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import lipvk.ohlo.xml.LataaHavainnotXML;
import lipvk.ohlo.xml.LataaKirjastoXML;
import lipvk.ohlo.xml.TallennaHavainnotXML;
import lipvk.ohlo.xml.TallennaKirjastoXML;

/**
 *
 * @author anterova
 */
public class Sovellusdata {
    private final File kirjasto;
    private File havainnot;
    private boolean muutoksiaTehty;

    public Sovellusdata() {
        kirjasto = new File("kirjasto/lajikirjasto.xml");
        if(!kirjasto.exists()) {
            try{
                kirjasto.createNewFile();
            } catch(Exception ex) {
                
            }
        }
        muutoksiaTehty = false;
    }
    
    public Lintulista lataaKirjasto() {
        return new LataaKirjastoXML().lataa(kirjasto);
    }
    
    public void tallennaKirjasto(Lintulista lintulista) {
        new TallennaKirjastoXML().kirjoita(lintulista, kirjasto);
    }
    
    public void tallennaHavainnot(Lintulista lintulista) {
        if(havainnot == null) valitseHavainnotTiedosto();
        new TallennaHavainnotXML().kirjoita(lintulista, havainnot);
        muutoksiaTehty = false;
    }
    
    public void lataaHavainnot(Lintulista lintulista) {
        valitseHavainnotTiedosto();
        lintulista.tyhjennaHavainnot();
        new LataaHavainnotXML().lue(havainnot, lintulista);
        muutoksiaTehty = false;
    }
    
    private void valitseHavainnotTiedosto() {
        JFileChooser fileChooser = new JFileChooser("havainnot/");
        fileChooser.setDialogTitle("Valitse tallennustiedosto");
        fileChooser.setFileFilter( new FileNameExtensionFilter("xml-tiedostot", "xml") );
        
        int returVal = fileChooser.showDialog(null, "Valitse");
        
        if(returVal == JFileChooser.APPROVE_OPTION) {
            File fSave = fileChooser.getSelectedFile();
            
            if( fSave.getName().endsWith(".xml") ) havainnot = fSave;
            else havainnot = new File( fSave + ".xml" );
        }
    }
    
    public void setMuutoksiaTehty(Boolean muutoksiaTehty) {
        this.muutoksiaTehty = muutoksiaTehty;
    }
    
    public boolean muutoksiaTehty() {
        return muutoksiaTehty;
    }
    
}
