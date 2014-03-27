/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.ohjelmalogiikka.tallennus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;

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
                bw.write( lista.get(i).toString().replace('\t', '/') );
                bw.write("&");
            }
            bw.write(".");
            bw.close();
            
        } catch (Exception ex) {
            System.out.println("virhe kirjoittamisessa");
        }
    }
    
}
