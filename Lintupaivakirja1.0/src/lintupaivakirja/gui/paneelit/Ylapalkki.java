/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author anterova
 */
public class Ylapalkki extends JPanel {
    private Date pvm;
    private JLabel pvmKentta;

    public Ylapalkki() {
        super(new GridLayout(1,3));
        pvm = new Date();
        luoKomponentit();
    }
    
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
