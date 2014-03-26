/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JPanel;
import lintupaivakirja.ohjelmalogiikka.Havainto;
import lintupaivakirja.ohjelmalogiikka.Havaintopaikka;
import lintupaivakirja.ohjelmalogiikka.Lintulaji;
import lintupaivakirja.util.Pvm;

/**
 *
 * @author anterova
 */
public class Havaintolistakaavake extends JPanel {

    public Havaintolistakaavake() {
        super(new GridLayout(0,1));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(new Havaintolistaotsikko());
        add(new HavaintolistaYlarivi());
        
        add(new Havaintopaneeli(new Havainto(new Lintulaji("Ankka"), new Havaintopaikka("Brändö"), new Pvm(26,3,2012))));
        add(new Havaintopaneeli(new Havainto(new Lintulaji("Kotka"), new Havaintopaikka("Santtio"), new Pvm(26,6,2013))));
        add(new Havaintopaneeli(new Havainto(new Lintulaji("Joutsen"), new Havaintopaikka("Otaniemi"), new Pvm(17,5,2012))));
        add(new Havaintopaneeli(new Havainto(new Lintulaji("Lokki"), new Havaintopaikka("Helsinki"), new Pvm(17,5,2012))));
        add(new Havaintopaneeli(new Havainto(new Lintulaji("Rastas"), new Havaintopaikka("Brändö"), new Pvm(20,4,2013))));
    }
    
    
    
}
