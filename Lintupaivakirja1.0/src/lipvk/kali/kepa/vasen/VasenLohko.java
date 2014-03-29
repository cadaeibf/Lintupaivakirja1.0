/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.vasen;

import java.awt.GridLayout;
import javax.swing.JPanel;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;

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
    
    public void lisaaTakut(Havaintolistakaavake lista) {
        uusiHavainto.luoKomponentit(lista, painikekentta.tallennussijaintipalkki());
        painikekentta.lisaaTakut(lista);
    }
    
    public Tallennussijaintipalkki tallennussijaintipalkki() {
        return painikekentta.tallennussijaintipalkki();
    }
    
    
}
