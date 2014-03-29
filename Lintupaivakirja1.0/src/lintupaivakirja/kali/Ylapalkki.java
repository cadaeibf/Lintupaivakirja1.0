package lintupaivakirja.kali;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lintupaivakirja.rajapinnat.Paivitettava;

/**
 *
 * @author anterova
 */
public class Ylapalkki extends JPanel implements Paivitettava {
    private Date pvm;
    private JLabel pvmKentta;

    public Ylapalkki() {
        super(new GridLayout(1,3));
        pvm = new Date();
        luoKomponentit();
    }
    
    @Override
    public void paivita() {
        pvm = new Date();
        pvmKentta.setText(pvm.toString());
        
    }

    private void luoKomponentit() {
        for (int i = 0; i < 2; i++) {
            add(new JLabel(""));
        }
        pvmKentta = new JLabel(pvm.toString());
        add(pvmKentta);
    }
    
}
