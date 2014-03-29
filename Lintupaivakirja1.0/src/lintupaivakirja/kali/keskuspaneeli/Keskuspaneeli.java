/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.kali.keskuspaneeli;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import lintupaivakirja.kali.keskuspaneeli.havaintolistakaavake.Havaintolistakaavake;
import lintupaivakirja.kali.keskuspaneeli.vasenlohko.VasenLohko;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;

/**
 *
 * @author anterova
 */
public class Keskuspaneeli extends JPanel {
    private VasenLohko vasenLohko;
    private Havaintolistakaavake havaintolistakaavake;

    public Keskuspaneeli(JFrame frame) {
        super(new GridLayout(1,2));
        
        luoKomponentit(frame);
    }

    private void luoKomponentit(JFrame frame) {
        vasenLohko = new VasenLohko();
        havaintolistakaavake = new Havaintolistakaavake(frame, new Havaintolista(), vasenLohko.tallennussijaintipalkki());
        
        vasenLohko.lisaaPainikkeet(havaintolistakaavake);
        
        add(vasenLohko);
        add(havaintolistakaavake);
        
    }
    
    
}
