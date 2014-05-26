/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;
import lipvk.ohlo.Sovellusdata;

/**
 *
 * @author anterova
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private VasenLohko vasenLohko;
    private Lajilistapaneeli llp;
    
    private Sovellusdata data;
    private Lintulista lintulista;
    
    public Kayttoliittyma() {
        data = new Sovellusdata();
        lintulista = data.lataaKirjasto();
    }

    @Override
    public void run() {
        frame = new JFrame("Lintupäiväkirja v1.0");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setJMenuBar( KaliPaneelit.menuBar(this) );
        luoKomponentit( frame.getContentPane() );
        
        frame.pack();
        frame.setMinimumSize( frame.getSize() );
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout( new GridLayout( 1, 2 ) );
        
        container.add( vasenLohko = new VasenLohko(this) );
        container.add( llp = new Lajilistapaneeli(this) );
    }
    
    public void setLintukortti(Lintulaji laji) {
        vasenLohko.setLintukortti(laji);
    }
    
    public void poistaLintukortti() {
        vasenLohko.poistaLintukortti();
    }
    
    public Dimension getKoko() {
        return frame.getSize();
    }
    
    private void paivitaLlp() {
        llp.paivita(this);
    }
    
    public void lisaaLaji(Lintulaji laji) {
        lintulista.lisaa(laji);
        data.tallennaKirjasto(lintulista);
        paivitaLlp();
    }
    
    public void lisaaHavainto(String laji, Havainto havainto) {
        lintulista.lisaaHavainto(laji, havainto);
        data.setMuutoksiaTehty(true);
        llp.paivita(this);
    }
    
    public void lataaHavainnot() {
        if( data.muutoksiaTehty() ) {
            // Lisää kysely halutaanko tallentaa muutokset
        }
        data.lataaHavainnot(lintulista);
        llp.paivita(this);
    }
    
    public void tallennaHavainnot() {
        data.tallennaHavainnot(lintulista);
    }
    
    public Lintulista getLintulista() {
        return lintulista;
    }
    
    public void lisaaKuva(String laji, File kuva) {
        lintulista.lisaaKuva(laji, kuva);
        data.tallennaKirjasto(lintulista);
        vasenLohko.paivita();
    }
    
}