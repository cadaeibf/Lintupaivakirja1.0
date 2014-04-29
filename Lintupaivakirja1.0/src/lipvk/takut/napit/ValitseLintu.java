/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import lipvk.kali.kepa.vasen.Lintukortti;
import lipvk.kali.kepa.vasen.VasenLohko;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class ValitseLintu implements ActionListener {
    private Lintulaji lintu;
    private VasenLohko vl;
    private JRadioButton painike;

    public ValitseLintu(Lintulaji lintu, VasenLohko vl, JRadioButton painike) {
        this.lintu = lintu;
        this.vl = vl;
        this.painike = painike;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        vl.lisaaLintukortti(lintu.getNimi(), new Lintukortti(lintu));
    }
    
}