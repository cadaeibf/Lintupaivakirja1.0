/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import lipvk.kali.kepa.Keskuspaneeli;
import lipvk.rajapinnat.Paivitettava;

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
        
        frame.setResizable(true);
    }

    @Override
    public void run() {
        frame = new JFrame("Lintupäiväkirja v1.0");
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        taysiRuutu();
        
        luoKomponentit(frame.getContentPane());
    }

    private void luoKomponentit(Container container) {
        ylapalkki = new Ylapalkki();
        keskuspaneeli = new Keskuspaneeli();
        
        container.add(ylapalkki, BorderLayout.NORTH);
        container.add(keskuspaneeli);
    }
    
    @Override
    public void paivita() {
        ylapalkki.paivita();
        keskuspaneeli.paivita();
    }
    
    
}
