/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author anterova
 */
public class Painikekentta extends JPanel {
    private JLabel tallennuspolku;
    private JButton vaihdaSijainti;
    private JButton tuo;
    private JButton vie;

    public Painikekentta() {
        super(new GridLayout(10,1));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        tallennuspolku = new JLabel("Tallennuskohde: "+"./kotihakemisto/Sijaintipolku");
        vaihdaSijainti = new JButton("Vaihda sijainti");
        tuo = new JButton("Tuo...");
        vie = new JButton("Vie...");
        
        add(tallennuspolku);
        add(vaihdaSijainti);
        add(tuo);
        add(vie);
    }
    
    
}
