/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lipvk.gui.Havaintolistakaavake.Listanakyma;
import lipvk.gui.Kayttoliittyma;

/**
 *
 * @author anterova
 */
public class VaihdaNakyma implements ActionListener {
    private Listanakyma nakyma;
    private Kayttoliittyma kali;

    public VaihdaNakyma(Kayttoliittyma kali, Listanakyma nakyma) {
        this.nakyma = nakyma;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kali.paivitaHavaintolistakaavake(nakyma);
    }
    
    
}
