/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JPanel;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;

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
        Havaintolista lista = new Havaintolista();
        havaintolistakaavake = new Havaintolistakaavake(lista);
        vasenLohko = new VasenLohko(havaintolistakaavake);
        
        add(vasenLohko);
        add(havaintolistakaavake);
    }
    
    
}
