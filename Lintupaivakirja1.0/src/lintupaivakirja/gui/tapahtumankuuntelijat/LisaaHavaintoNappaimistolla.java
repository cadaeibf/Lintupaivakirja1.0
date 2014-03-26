/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.tapahtumankuuntelijat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

/**
 *
 * @author anterova
 */
public class LisaaHavaintoNappaimistolla implements KeyListener {
    private JButton lisaaPainike;

    public LisaaHavaintoNappaimistolla(JButton lisaaPainike) {
        this.lisaaPainike = lisaaPainike;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) lisaaPainike.doClick();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
    
}
