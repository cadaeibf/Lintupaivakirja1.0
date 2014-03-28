/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.ohjelmalogiikka.tallennus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import lintupaivakirja.ohjelmalogiikka.Havainto;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;
import lintupaivakirja.ohjelmalogiikka.Havaintopaikka;
import lintupaivakirja.ohjelmalogiikka.Lintulaji;
import lintupaivakirja.util.Pvm;

/**
 *
 * @author anterova
 */
public class Lataaja  {
    private String tiedostonimi;
    private Havaintolista lista;

    public Lataaja(String tiedostonimi, Havaintolista lista) {
        this.tiedostonimi = tiedostonimi;
        this.lista = lista;
    }
    
    public void lataa() {
        lista.tyhjenna();
        
        File tiedosto = new File(tiedostonimi);
        
        if( !tiedosto.exists() ) {
            return;
        }
        
        // Luetaan tiedosto
        String teksti = "";
        try {
            BufferedReader br = new BufferedReader( new FileReader( tiedosto ) );
            String s = "";
            
            while( (s = br.readLine()) != null ) {
                teksti += s;
            }
            
            br.close();
        
        } catch(Exception ex) {
            
        }
        
        teksti = muunnaFormaatti(teksti);
        
        String[] linnut = teksti.split("&");
        
        for (int i = 0; i < linnut.length - 1; i++) {
            lista.lisaa( lueHavainto(linnut[i]) );
            
        }
        
        
    }
    
    private Havainto lueHavainto(String teksti) {
        
        
        String[] attribuutit = teksti.split("/");
        
        attribuutit[0] = attribuutit[0].substring(0,1).toUpperCase() + attribuutit[0].substring(1, attribuutit[0].length() );
        
        Lintulaji laji = new Lintulaji(attribuutit[0]);
        
        String[] pvmtiedot = attribuutit[1].split("\\.");
        
        
        Pvm pvm = new Pvm( Integer.parseInt( pvmtiedot[0] ), Integer.parseInt( pvmtiedot[1] ),
                Integer.parseInt( pvmtiedot[2] ));
        
        String[] paikkaJaLkm = attribuutit[2].split("\\(");
        
        paikkaJaLkm[0] = paikkaJaLkm[0].substring(0,1).toUpperCase() + paikkaJaLkm[0].substring(1, paikkaJaLkm[0].length() );
        Havaintopaikka paikka = new Havaintopaikka( paikkaJaLkm[0] );
        
        String lkm = paikkaJaLkm[1];
        lkm = lkm.substring(0, lkm.length()-1);
        
        System.out.println(lkm);
        return new Havainto( laji, pvm, paikka, Integer.parseInt(lkm) );
        
    }
    
    private String muunnaFormaatti(String raaka) {
        String korjattu = raaka.replace('@', 'ä');
        korjattu = korjattu.replace('#', 'ö');
        
        return korjattu;
    }
    
}
