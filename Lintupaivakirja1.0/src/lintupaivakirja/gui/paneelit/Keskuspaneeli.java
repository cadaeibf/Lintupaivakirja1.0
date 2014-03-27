/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import lintupaivakirja.ohjelmalogiikka.Havainto;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;
import lintupaivakirja.ohjelmalogiikka.Havaintopaikka;
import lintupaivakirja.ohjelmalogiikka.Lintulaji;
import lintupaivakirja.util.Pvm;

/**
 *
 * @author anterova
 */
public class Keskuspaneeli extends JPanel {
    private VasenLohko vasenLohko;
    private Havaintolistakaavake havaintolistakaavake;

    public Keskuspaneeli(JFrame frame) {
        super(new GridLayout(1,2,10,10));
        
        luoKomponentit(frame);
    }

    private void luoKomponentit(JFrame frame) {
        Havaintolista lista = new Havaintolista();
        havaintolistakaavake = new Havaintolistakaavake(frame, lista);
        vasenLohko = new VasenLohko(havaintolistakaavake);
        
        add(vasenLohko);
        add(havaintolistakaavake);
        
    }
    
    
}
