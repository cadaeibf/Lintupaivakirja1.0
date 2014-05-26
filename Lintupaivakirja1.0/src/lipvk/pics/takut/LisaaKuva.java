/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.pics.takut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import lipvk.gui.Kayttoliittyma;
import lipvk.pics.LisaaKuvaKaavake;

/**
 *
 * @author anterova
 */
public class LisaaKuva implements ActionListener {
    private String laji;
    private Kayttoliittyma kali;
    
    public LisaaKuva(String laji, Kayttoliittyma kali) {
        this.laji = laji;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater( new LisaaKuvaKaavake(laji, kali) );
    }
    
}
