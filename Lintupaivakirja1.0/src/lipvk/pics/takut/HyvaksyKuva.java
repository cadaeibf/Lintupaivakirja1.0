/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.pics.takut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lipvk.pics.LisaaKuvaKaavake;

/**
 *
 * @author anterova
 */
public class HyvaksyKuva implements ActionListener {
    private LisaaKuvaKaavake lisaaKuvaKaavake;

    public HyvaksyKuva(LisaaKuvaKaavake lisaaKuvaKaavake) {
        this.lisaaKuvaKaavake = lisaaKuvaKaavake;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lisaaKuvaKaavake.hyvaksy();
    }
    
}
