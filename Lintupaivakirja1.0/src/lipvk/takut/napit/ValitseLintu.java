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
    private JRadioButton painike;
    private Kayttoliittyma kali;
    private Lintulaji laji;

    public ValitseLintu(JRadioButton painike, Kayttoliittyma kali, Lintulaji laji) {
        this.painike = painike;
        this.kali = kali;
        this.laji = laji;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(painike.isSelected()) {
            kali.poistaLintukortti();
            painike.setSelected(false);
        } else {
            kali.lisaaLintukortti(laji);
            painike.setSelected(true);
        }
    }
    
}
