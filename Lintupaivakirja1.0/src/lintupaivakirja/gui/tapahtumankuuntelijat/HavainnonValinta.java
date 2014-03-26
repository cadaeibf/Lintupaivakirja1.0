/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import lintupaivakirja.ohjelmalogiikka.Havainto;

/**
 *
 * @author anterova
 */
public class HavainnonValinta implements ActionListener {
    private JCheckBox ruutu;
    private Havainto havainto;

    public HavainnonValinta(JCheckBox ruutu, Havainto havainto) {
        this.ruutu = ruutu;
        this.havainto = havainto;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!ruutu.isSelected()) {
            ruutu.setSelected(false);
            ruutu.setBorderPaintedFlat(false);
            havainto.poistaValinta();
        } else {
            ruutu.setSelected(true);
            ruutu.setBorderPaintedFlat(true);
            havainto.valitse();
        }
    }
    
    
    
}
