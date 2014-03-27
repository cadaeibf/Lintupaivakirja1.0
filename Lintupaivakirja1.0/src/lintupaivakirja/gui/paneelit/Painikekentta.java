/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lintupaivakirja.gui.tapahtumankuuntelijat.Lataa;
import lintupaivakirja.gui.tapahtumankuuntelijat.Tallenna;

/**
 *
 * @author anterova
 */
public class Painikekentta extends JPanel {
    private String tiedostonimi;
    private JLabel tallennuspolkukentta;
    private JButton vaihdaSijainti;
    private JButton tallenna;
    private JButton lataa;
    private JButton tuo;
    private JButton vie;

    public Painikekentta(Havaintolistakaavake lista) {
        super(new GridLayout(10,1));
        
        luoKomponentit(lista);
    }

    private void luoKomponentit(Havaintolistakaavake lista) {
        tiedostonimi = "save1.txt";
        
        tallennuspolkukentta = new JLabel("Tallennuskohde: "+ tiedostonimi );
        vaihdaSijainti = new JButton("Vaihda sijainti");
        tallenna = new JButton("Tallenna");
        lataa = new JButton("Lataa");
        tuo = new JButton("Tuo...");
        vie = new JButton("Vie...");
        
        tallenna.addActionListener( new Tallenna(lista) );
        lataa.addActionListener( new Lataa(lista) );
        
        add(tallennuspolkukentta);
        add(vaihdaSijainti);
        add(tallenna);
        add(lataa);
        add(tuo);
        add(vie);
    }
    
    
}
