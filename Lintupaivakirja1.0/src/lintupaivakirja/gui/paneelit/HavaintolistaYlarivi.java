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
public class HavaintolistaYlarivi extends JPanel {

    public HavaintolistaYlarivi() {
        super(new GridLayout(1,5));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(new JLabel("Valitse"));
        add(new JButton("Laji"));
        add(new JButton("Pvm"));
        add(new JButton("Paikka"));
        add(new JButton("Lkm"));
    }
    
    
}
