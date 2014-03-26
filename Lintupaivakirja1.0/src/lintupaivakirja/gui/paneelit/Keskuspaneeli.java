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
public class Keskuspaneeli extends JPanel {
    private VasenLohko vasenLohko;
    private Havaintolistakaavake havaintolistakaavake;

    public Keskuspaneeli() {
        super(new GridLayout(1,2,10,10));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        vasenLohko = new VasenLohko();
        havaintolistakaavake = new Havaintolistakaavake();
        
        add(vasenLohko);
        add(havaintolistakaavake);
    }
    
    
}
