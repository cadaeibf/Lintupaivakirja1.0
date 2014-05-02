/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import lipvk.main.Kayttoliittyma;

/**
 *
 * @author anterova
 */
public class VaihdaNakyma implements ActionListener {
    private int nakyma;
    private JRadioButton painike;
    private Kayttoliittyma kali;

    public VaihdaNakyma(int nakyma, JRadioButton painike, Kayttoliittyma kali) {
        this.nakyma = nakyma;
        this.painike = painike;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kali.vaihdaListanakyma(nakyma);
    }
    
    
}
