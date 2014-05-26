/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.pics.takut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import lipvk.pics.LisaaKuvaKaavake;

/**
 *
 * @author anterova
 */
public class ValitseKuva implements ActionListener {
    private LisaaKuvaKaavake lisaaKuvaKaavake;

    public ValitseKuva(LisaaKuvaKaavake kuvapaneeli) {
        this.lisaaKuvaKaavake = kuvapaneeli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Valitse Kuva");
        int returVal = fileChooser.showDialog(null, null);
        
        if( returVal == JFileChooser.APPROVE_OPTION ) {
            lisaaKuvaKaavake.paivita(fileChooser.getSelectedFile());
        }
    }
    
}
