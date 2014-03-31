/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

/**
 *
 * @author anterova
 */
public class LataaTiedostoNappaimistolta implements KeyListener {
    private JButton lataaPainike;

    public LataaTiedostoNappaimistolta(JButton lataaPainike) {
        this.lataaPainike = lataaPainike;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if( e.getKeyCode() == KeyEvent.VK_ENTER )lataaPainike.doClick();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
