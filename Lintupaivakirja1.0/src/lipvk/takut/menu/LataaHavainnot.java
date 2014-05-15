/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lipvk.gui.Kayttoliittyma;

/**
 * Luokka pyytää käyttäjää valitsemaan halutun havaintolistan xml-tiedoston 
 * ja käskee käyttöliittymää lataamaan havainnot.
 * @author anterova
 */
public class LataaHavainnot implements ActionListener {
    private Kayttoliittyma kali;

    public LataaHavainnot(Kayttoliittyma kali) {
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kali.lataaHavainnot();
    }
    
}
