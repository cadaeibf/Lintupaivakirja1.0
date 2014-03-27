/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import lintupaivakirja.gui.tapahtumankuuntelijat.Jarjestaja;
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
        JButton poistaValitut = new JButton("Poista");
        JButton jarjestaLaji = new JButton("Laji");
        JButton jarjestaPvm = new JButton("Pvm");
        JButton jarjestaPaikka = new JButton("Paikka");
        JButton jarjestaLkm = new JButton("Lkm");
        
        
        poistaValitut.addActionListener( new PoistaValitut(lista) );
        jarjestaLaji.addActionListener( new Jarjestaja(lista, 0) );
        jarjestaPvm.addActionListener( new Jarjestaja(lista, 1) );
        jarjestaPaikka.addActionListener( new Jarjestaja( lista, 2 ) );
        jarjestaLkm.addActionListener( new Jarjestaja( lista, 3 ) );
        
        add( poistaValitut );
        add( jarjestaLaji );
        add( jarjestaPvm );
        add( jarjestaPaikka );
        add( jarjestaLkm );
    }
    
    
}
