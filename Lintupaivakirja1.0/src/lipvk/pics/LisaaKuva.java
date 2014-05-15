/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.pics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import lipvk.gui.Kayttoliittyma;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class LisaaKuva implements ActionListener {
    private Lintulaji laji;
    private Kayttoliittyma kali;
    
    public LisaaKuva(Lintulaji laji, Kayttoliittyma kali) {
        this.laji = laji;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater( new LisaaKuvaKaavake(laji, kali) );
    }
    
}
