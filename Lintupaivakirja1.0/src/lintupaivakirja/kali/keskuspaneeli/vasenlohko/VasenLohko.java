/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.kali.keskuspaneeli.vasenlohko;

import java.awt.GridLayout;
import javax.swing.JPanel;
import lintupaivakirja.kali.keskuspaneeli.havaintolistakaavake.Havaintolistakaavake;

/**
 *
 * @author anterova
 */
public class VasenLohko extends JPanel {
    private UusiHavaintoKaavake uusiHavainto;
    private Painikekentta painikekentta;

    public VasenLohko() {
        super(new GridLayout(2,1));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        painikekentta = new Painikekentta();
        uusiHavainto = new UusiHavaintoKaavake();
        
        add(uusiHavainto);
        add(painikekentta);
    }
    
    public void lisaaPainikkeet(Havaintolistakaavake lista) {
        uusiHavainto.lisaaPainikkeet(lista, painikekentta.tallennussijaintipalkki());
        painikekentta.lisaaPainikkeet(lista);
    }
    
    public Tallennussijaintipalkki tallennussijaintipalkki() {
        return painikekentta.tallennussijaintipalkki();
    }
    
    
}
