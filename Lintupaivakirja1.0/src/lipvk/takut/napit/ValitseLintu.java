/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class ValitseLintu implements ActionListener {
    private Lintulaji lintu;
    private JRadioButton painike;

    public ValitseLintu(Lintulaji lintu, JRadioButton painike) {
        this.lintu = lintu;
        this.painike = painike;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
