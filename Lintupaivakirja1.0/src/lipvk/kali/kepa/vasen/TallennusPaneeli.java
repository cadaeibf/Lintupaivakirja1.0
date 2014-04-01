/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.vasen;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;
import lipvk.takut.napit.Lataa;
import lipvk.takut.napit.Tallenna;

/**
 *
 * @author anterova
 */
public class TallennusPaneeli extends JPanel {
    private Tallennussijaintipalkki tspalkki;
    private Havaintolistakaavake lista;
    
    private JButton tallenna;
    private JButton lataa;

    public TallennusPaneeli() {
        super(new GridLayout(10,2));
        
        luoKomponentit(lista);
    }

    private void luoKomponentit(Havaintolistakaavake lista) {
        
        tallenna = new JButton("Tallenna");
        lataa = new JButton("Lataa");
        tspalkki = new Tallennussijaintipalkki("lintulista.xml", lataa);
        
        add(tspalkki);
        add(lataa);
        add(tallenna);
    }
    
    public void lisaaTakut(Havaintolistakaavake lista) {
        lataa.addActionListener( new Lataa(tspalkki, lista) );
        tallenna.addActionListener( new Tallenna(tspalkki, lista) );
    }
    
    public Tallennussijaintipalkki tallennussijaintipalkki() {
        return this.tspalkki;
    }
    
    public void ilmoitus(String teksti) {
        tspalkki.asetaIlmoitus(teksti);
    }
    
    
}
