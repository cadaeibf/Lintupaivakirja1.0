/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lipvk.gui.Kayttoliittyma;
import lipvk.gui.Lajilistapaneeli.Listanakyma;
import lipvk.gui.Lajilistapaneeli;

/**
 *
 * @author anterova
 */
public class VaihdaNakyma implements ActionListener {
    private Listanakyma nakyma;
    private Lajilistapaneeli llp;
    private Kayttoliittyma kali;

    public VaihdaNakyma(Listanakyma nakyma, Lajilistapaneeli llp, Kayttoliittyma kali) {
        this.nakyma = nakyma;
        this.llp = llp;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        llp.vaihdaNakyma(nakyma, kali);
    }
    
    
}
