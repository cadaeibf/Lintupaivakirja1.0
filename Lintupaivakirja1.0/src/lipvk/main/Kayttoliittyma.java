/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import lipvk.gui.Keskuspaneeli;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulista;
import lipvk.takut.menu.LataaHavainnot;

/**
 *
 * @author anterova
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Keskuspaneeli keskuspaneeli;
    
    private Lintulista lintulista;
    
    public Kayttoliittyma() {
        lintulista = new Lintulista();
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
        keskuspaneeli = new Keskuspaneeli(lintulista);
        
        container.add(keskuspaneeli);
        
        // Luo menu
        JMenuBar menuBar = new JMenuBar();
        luoMenut(menuBar);
        
        frame.setJMenuBar(menuBar);
        
    }
    
    private void luoMenut(JMenuBar menuBar) {
        JMenu tiedostoMenu = luoTiedostoMenu();
        
        menuBar.add(tiedostoMenu);
    }
    
    private JMenu luoTiedostoMenu() {
        JMenu tiedostoMenu = new JMenu( "Tiedosto" );
        
        JMenuItem lataaTiedosto = new JMenuItem( "Lataa" );
        lataaTiedosto.addActionListener( new LataaHavainnot(this) );
        
        tiedostoMenu.add(lataaTiedosto);
        
        return tiedostoMenu;
    }
    
    public void lisaaHavainto(String laji, Havainto havainto) {
        lintulista.lisaaHavainto(laji, havainto);
        paivita();
    }
    
    public void lataaHavainnot(File tiedosto) {
        lintulista = Lintulista.lataaLintulista(tiedosto);
        paivita();
    }
    
    public void tallennaHavainnot() {
        
    }
    
    public void vaihdaListanakyma(int nakyma) {
        
    }
    
    public void paivita() {
        keskuspaneeli.paivitaLintulista(lintulista);
        
        frame.repaint();
    }
    
    
}
