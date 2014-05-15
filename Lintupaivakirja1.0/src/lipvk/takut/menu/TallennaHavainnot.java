/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lipvk.gui.Kayttoliittyma;

/**
 * Luokka pyytää käyttäjää valitsemaan tallennuskohteen ja tallentaa session 
 * havainnot sinne.
 * @author anterova
 */
public class TallennaHavainnot implements ActionListener {
    private Kayttoliittyma kali;
    
    public TallennaHavainnot( Kayttoliittyma kali ) {
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kali.tallennaHavainnot();
    }
    
}
