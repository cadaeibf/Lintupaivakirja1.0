/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author anterova
 */
public class TyhjennaKentta implements ActionListener {
    private JLabel kentta;

    public TyhjennaKentta(JLabel kentta) {
        this.kentta = kentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kentta.setText("");
    }
    
    
    
}
