/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import lintupaivakirja.gui.paneelit.Keskuspaneeli;
import lintupaivakirja.gui.paneelit.Ylapalkki;

/**
 *
 * @author anterova
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Lintupäiväkirja v1.0");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(new Ylapalkki(), BorderLayout.NORTH);
        container.add(new Keskuspaneeli(frame));
    }
    
    
}
