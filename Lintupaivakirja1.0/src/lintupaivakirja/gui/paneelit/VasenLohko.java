/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author anterova
 */
public class VasenLohko extends JPanel {
    private UusiHavaintoKaavake uusiHavainto;
    private Painikekentta painikekentta;

    public VasenLohko() {
        super(new GridLayout(2,1));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        uusiHavainto = new UusiHavaintoKaavake();
        painikekentta = new Painikekentta();
        add(uusiHavainto);
        add(painikekentta);
    }
    
    
}
