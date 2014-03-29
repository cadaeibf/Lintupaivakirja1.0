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
import lintupaivakirja.rajapinnat.Paivitettava;

/**
 *
 * @author anterova
 */
public class Keskuspaneeli extends JPanel implements Paivitettava {
    private VasenLohko vasenLohko;
    private Havaintolistakaavake havaintolistakaavake;

    public Keskuspaneeli() {
        super(new GridLayout(1,2));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        vasenLohko = new VasenLohko();
        havaintolistakaavake = new Havaintolistakaavake(new Havaintolista(), vasenLohko.tallennussijaintipalkki());
        
        vasenLohko.lisaaPainikkeet(havaintolistakaavake);
        
        add(vasenLohko);
        add(havaintolistakaavake);
        
    }

    @Override
    public void paivita() {
        havaintolistakaavake.paivita();
        
        repaint();
    }
    
    
}
