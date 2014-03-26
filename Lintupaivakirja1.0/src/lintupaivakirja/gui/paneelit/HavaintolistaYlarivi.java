/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import lintupaivakirja.gui.tapahtumankuuntelijat.PoistaValitut;

/**
 *
 * @author anterova
 */
public class HavaintolistaYlarivi extends JPanel {

    public HavaintolistaYlarivi(Havaintolistakaavake lista) {
        super(new GridLayout(1,5));
        
        luoKomponentit(lista);
    }

    private void luoKomponentit(Havaintolistakaavake lista) {
        JButton poistaValitut = new JButton("Poista Valitut");
        poistaValitut.addActionListener(new PoistaValitut(lista));
        
        add(poistaValitut);
        add(new JButton("Laji"));
        add(new JButton("Pvm"));
        add(new JButton("Paikka"));
        add(new JButton("Lkm"));
    }
    
    
}
