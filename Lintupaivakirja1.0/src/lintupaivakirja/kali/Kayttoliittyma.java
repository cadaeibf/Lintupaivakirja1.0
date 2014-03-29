/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.kali;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import lintupaivakirja.kali.keskuspaneeli.Keskuspaneeli;
import lintupaivakirja.rajapinnat.Paivitettava;

/**
 *
 * @author anterova
 */
public class Kayttoliittyma implements Runnable, Paivitettava {
    private JFrame frame;
    private Ylapalkki ylapalkki;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Lintupäiväkirja v1.0");
        frame.setPreferredSize(new Dimension(1000,600));
        frame.setResizable(false);
        
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    @Override
    public void paivita() {
        ylapalkki.paivita();
        
    }

    private void luoKomponentit(Container container) {
        ylapalkki = new Ylapalkki();
        
        container.add(ylapalkki, BorderLayout.NORTH);
        container.add(new Keskuspaneeli(frame));
    }
    
    
}
