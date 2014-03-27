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

    public VasenLohko(Havaintolistakaavake havaintolistakaavake) {
        super(new GridLayout(2,1));
        
        luoKomponentit(havaintolistakaavake);
    }

    private void luoKomponentit(Havaintolistakaavake havaintolistakaavake) {
        uusiHavainto = new UusiHavaintoKaavake(havaintolistakaavake);
        painikekentta = new Painikekentta(havaintolistakaavake);
        add(uusiHavainto);
        add(painikekentta);
    }
    
    
}
