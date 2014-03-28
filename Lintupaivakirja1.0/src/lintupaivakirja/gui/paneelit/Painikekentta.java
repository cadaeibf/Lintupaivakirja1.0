/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import lintupaivakirja.gui.tapahtumankuuntelijat.Lataa;
import lintupaivakirja.gui.tapahtumankuuntelijat.Tallenna;

/**
 *
 * @author anterova
 */
public class Painikekentta extends JPanel {
    private String tiedostonimi;
    private Tallennussijaintipalkki tallennussijaintipalkki;
    private JButton vaihdaSijainti;
    private JButton tallenna;
    private JButton lataa;
    private JButton tuo;
    private JButton vie;

    public Painikekentta() {
        super(new GridLayout(10,1));
        
        luoKomponentit();
    }
    
    public Tallennussijaintipalkki tallennussijaintipalkki() {
        return tallennussijaintipalkki;
    }

    private void luoKomponentit() {
        tiedostonimi = "save1.txt";
        
        tallennussijaintipalkki = new Tallennussijaintipalkki(tiedostonimi);
        vaihdaSijainti = new JButton("Vaihda sijainti");
        tallenna = new JButton("Tallenna");
        lataa = new JButton("Lataa");
        tuo = new JButton("Tuo...");
        vie = new JButton("Vie...");
        
        
        
        add(tallennussijaintipalkki);
        add(vaihdaSijainti);
        add(tallenna);
        add(lataa);
        add(tuo);
        add(vie);
    }
    
    public void lisaaPainikkeet(Havaintolistakaavake lista) {
        tallenna.addActionListener( new Tallenna(lista, tallennussijaintipalkki) );
        lataa.addActionListener( new Lataa(lista, tallennussijaintipalkki) );
    }
    
    
}
