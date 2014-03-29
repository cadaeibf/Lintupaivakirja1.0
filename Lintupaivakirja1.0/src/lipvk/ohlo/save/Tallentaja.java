/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo.save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import lipvk.ohlo.Havaintolista;

/**
 *
 * @author anterova
 */
public class Tallentaja {
    private String tiedostonimi;
    private Havaintolista lista;

    public Tallentaja(String tiedostonimi, Havaintolista lista) {
        this.tiedostonimi = tiedostonimi;
        this.lista = lista;
    }
    
    public void tallenna() {
        try {
            File tiedosto = new File(tiedostonimi);
            
            if(! tiedosto.exists() ) {
                tiedosto.createNewFile();
            }
            
            
            BufferedWriter bw = new BufferedWriter( new FileWriter( tiedosto.getAbsoluteFile() ) );
            
            for (int i = 0; i < lista.getHavaintoja(); i++) {
                bw.write( muunnaFormaatti( lista.get(i).toString() ) );
                bw.write("&");
            }
            bw.write(".");
            bw.close();
            
        } catch (Exception ex) {
            System.out.println("virhe kirjoittamisessa");
        }
    }
    
    private String muunnaFormaatti(String raaka) {
        String korjattu = raaka.toLowerCase();
        korjattu = korjattu.replace('ä', '@');
        korjattu = korjattu.replace('ö', '#');
        korjattu = korjattu.replace('\t', '/');
        
        return korjattu;
    }
    
}
