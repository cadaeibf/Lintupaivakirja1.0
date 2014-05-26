/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class VasenLohko extends JPanel {
    private Kayttoliittyma kali;
    private Lintulaji valittu;
    private JPanel lintukortti;

    public VasenLohko(Kayttoliittyma kali) {
        super( new GridLayout(2, 1) );
        this.kali = kali;
        
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        add( KaliPaneelit.uusiHavaintoKaavake(kali) );
        add( lintukortti = new JPanel() );
    }
    
    public void poistaLintukortti() {
        valittu = null;
        paivita();
    }
    
    public void setLintukortti(Lintulaji laji) {
        valittu = laji;
        paivita();
        
    }
    
    public void paivita() {
        remove( lintukortti );
        add( lintukortti = KaliPaneelit.lintukortti(valittu, kali) );
        
        validate();
        repaint();
    }
    
}
