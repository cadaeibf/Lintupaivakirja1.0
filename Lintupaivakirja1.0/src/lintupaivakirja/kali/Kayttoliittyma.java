/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.kali;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
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
    private Keskuspaneeli keskuspaneeli;

    public Kayttoliittyma() {
    }
    
    public void taysiRuutu() {
        frame.setResizable(true);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);
        
        frame.setResizable(false);
    }

    @Override
    public void run() {
        frame = new JFrame("Lintupäiväkirja v1.0");
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        taysiRuutu();
        
        luoKomponentit(frame.getContentPane());
        
        frame.setVisible(true);
    }
    
    @Override
    public void paivita() {
        ylapalkki.paivita();
        keskuspaneeli.paivita();
        
        frame.repaint();
        
    }

    private void luoKomponentit(Container container) {
        ylapalkki = new Ylapalkki();
        keskuspaneeli = new Keskuspaneeli();
        
        container.add(ylapalkki, BorderLayout.NORTH);
        container.add(keskuspaneeli);
    }
    
    
}