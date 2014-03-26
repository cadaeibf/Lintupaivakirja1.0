/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author anterova
 */
public class Havaintolistaotsikko extends JPanel {

    public Havaintolistaotsikko() {
        super(new GridLayout(1,3));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(new JLabel(""));
        add(new JLabel("HAVAINNOT"));
        add(new JLabel(""));
    }
    
    
}
