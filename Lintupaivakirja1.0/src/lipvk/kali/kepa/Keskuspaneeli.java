/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa;

import java.awt.GridLayout;
import javax.swing.JPanel;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;
import lipvk.kali.kepa.vasen.VasenLohko;
import lipvk.rajapinnat.Paivitettava;

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
        havaintolistakaavake = new Havaintolistakaavake(vasenLohko.tallennussijaintipalkki());
        
        vasenLohko.lisaaTakut(havaintolistakaavake);
        
        add(vasenLohko);
        add(havaintolistakaavake);
        
    }

    @Override
    public void paivita() {
        havaintolistakaavake.paivita();
    }
    
    
}
