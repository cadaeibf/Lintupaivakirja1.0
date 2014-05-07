/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import lipvk.gui.Kayttoliittyma;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class ValitseLintu implements ActionListener {
    private Kayttoliittyma kali;
    private JRadioButton painike;
    
    private Lintulaji lintu;

    public ValitseLintu(Kayttoliittyma kali, JRadioButton painike, Lintulaji lintu) {
        this.kali = kali;
        this.painike = painike;
        this.lintu = lintu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!painike.isSelected()) {
            kali.setLintukortti(lintu);
            painike.setSelected(true);
        }
    }
    
}
