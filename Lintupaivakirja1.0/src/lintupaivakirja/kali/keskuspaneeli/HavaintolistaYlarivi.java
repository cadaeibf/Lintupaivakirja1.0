/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.kali.keskuspaneeli;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import lintupaivakirja.kali.keskuspaneeli.havaintolistakaavake.Havaintolistakaavake;
import lintupaivakirja.kali.keskuspaneeli.vasenlohko.Tallennussijaintipalkki;
import lintupaivakirja.tapahtumankuuntelijat.Jarjestaja;
import lintupaivakirja.tapahtumankuuntelijat.PoistaValitut;

/**
 *
 * @author anterova
 */
public class HavaintolistaYlarivi extends JPanel {

    public HavaintolistaYlarivi(Havaintolistakaavake lista, Tallennussijaintipalkki tspalkki) {
        super(new GridLayout(1,5));
        
        luoKomponentit(lista, tspalkki);
    }

    private void luoKomponentit(Havaintolistakaavake lista, Tallennussijaintipalkki tspalkki) {
        JButton poistaValitut = new JButton("Poista");
        JButton jarjestaLaji = new JButton("Laji");
        JButton jarjestaPvm = new JButton("Pvm");
        JButton jarjestaPaikka = new JButton("Paikka");
        JButton jarjestaLkm = new JButton("Lkm");
        
        
        poistaValitut.addActionListener( new PoistaValitut(lista, tspalkki) );
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
