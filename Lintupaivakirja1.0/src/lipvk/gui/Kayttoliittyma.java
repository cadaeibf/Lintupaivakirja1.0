/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;
import lipvk.takut.menu.LataaHavainnot;
import lipvk.takut.menu.TallennaHavainnotNimella;

/**
 *
 * @author anterova
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;
    private Lajilistapaneeli llp;
    
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
        
        JMenuBar menuBar = new JMenuBar();
        luoMenut(menuBar);
        
        frame.setJMenuBar(menuBar);
        
        luoKomponentit(frame.getContentPane());
    }

    private void luoKomponentit(Container container) {
        container.setLayout( new GridLayout( 1, 2 ) );
        
        JPanel vasenLohko = new JPanel( new GridLayout( 2, 1 ) );
        
        vasenLohko.add( KaliPaneelit.uusiHavaintoKaavake(this) );
        
        container.add(vasenLohko);
        container.add( llp = new Lajilistapaneeli(this) );
    }
    
    private void luoMenut(JMenuBar menuBar) {
        JMenu tiedostoMenu = luoTiedostoMenu();
        
        menuBar.add(tiedostoMenu);
    }
    
    private JMenu luoTiedostoMenu() {
        JMenu tiedostoMenu = new JMenu( "Tiedosto" );
        
        JMenuItem lataaTiedosto = new JMenuItem( "Lataa" );
        lataaTiedosto.addActionListener( new LataaHavainnot(this) );
        
        JMenuItem tallennaNimella = new JMenuItem("Tallenna nimellä...");
        tallennaNimella.addActionListener( new TallennaHavainnotNimella(this) );
        
        tiedostoMenu.add(lataaTiedosto);
        tiedostoMenu.add(tallennaNimella);
        
        return tiedostoMenu;
    }
    
    public void lisaaLintukortti(Lintulaji laji) {
        
    }
    
    public void poistaLintukortti() {
        
    }
    
    public void lisaaLaji(Lintulaji laji) {
        
    }
    
    public void lisaaHavainto(String laji, Havainto havainto) throws NullPointerException {
        lintulista.lisaaHavainto(laji, havainto);
        llp.paivita(this);
    }
    
    public void lataaHavainnot(File tiedosto) {
        lintulista = Lintulista.lataaHavainnot(tiedosto);
        llp.paivita(this);
    }
    
    public void tallennaHavainnot(File tiedosto) {
        Lintulista.tallennaHavainnot(lintulista, tiedosto);
    }
    
    public Lintulista getLintulista() {
        return lintulista;
    }
    
    private void paivitaLlp() {
        Container container = frame.getContentPane();
        container.remove(llp);
        
        container.add(llp = new Lajilistapaneeli(this));
        
        frame.validate();
        frame.repaint();
    }
    
}
