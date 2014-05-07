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
import lipvk.gui.Havaintolistakaavake.Listanakyma;
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
    private Havaintolistakaavake hlk;
    
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
        
        luoVasenLohko(container, null);
        
        container.add(hlk = new Havaintolistakaavake(this));
    }
    
    private void luoVasenLohko( Container container, Lintulaji lintulaji ) {
        JPanel vasenLohko = new JPanel( new GridLayout( 2, 1 ) );
        
        // vasenLohko.add( new UusiHavaintoKaavake(this) );
        vasenLohko.add( new UusiLintulajiKaavake(this) );
        
        container.add(vasenLohko);
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
    
    public void setLintukortti(Lintulaji lintulaji) {
        Container container = frame.getContentPane();
        container.removeAll();
        
        luoVasenLohko(container, lintulaji);
        container.add(hlk);
        
        container.validate();
        container.repaint();
    }
    
    public void paivitaHavaintolistakaavake() {
        Container container = frame.getContentPane();
        container.remove(hlk);
        container.add( hlk = new Havaintolistakaavake(this) );
        
        container.validate();
        container.repaint();
    }
    
    public void paivitaHavaintolistakaavake(Listanakyma nakyma) {
        Container container = frame.getContentPane();
        container.remove(hlk);
        container.add( hlk = new Havaintolistakaavake(this, nakyma) );
        
        container.validate();
        container.repaint();
    }
    
    public void lisaaLaji(Lintulaji laji) {
        lintulista.lisaa(laji);
        paivitaHavaintolistakaavake();
    }
    
    public void lisaaHavainto(String laji, Havainto havainto) {
        lintulista.lisaaHavainto(laji, havainto);
        paivitaHavaintolistakaavake();
    }
    
    public void lataaHavainnot(File tiedosto) {
        lintulista = Lintulista.lataaHavainnot(tiedosto);
        paivitaHavaintolistakaavake();
    }
    
    public void tallennaHavainnot(File tiedosto) {
        Lintulista.tallennaHavainnot(lintulista, tiedosto);
    }
    
    public Lintulista getLintulista() {
        return lintulista;
    }
    
}
