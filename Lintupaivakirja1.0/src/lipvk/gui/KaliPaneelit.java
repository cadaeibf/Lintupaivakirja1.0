/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulaji;
import lipvk.takut.NapinpainoNappaimistolta;
import lipvk.takut.napit.LisaaHavainto;
import lipvk.takut.napit.LisaaLintulaji;
import lipvk.audio.SoitaAudio;
import lipvk.pics.Kuvapaneeli;
import lipvk.pics.takut.LisaaKuva;
import lipvk.takut.menu.LataaHavainnot;
import lipvk.takut.menu.LisaaLaji;
import lipvk.takut.menu.TallennaHavainnot;
import lipvk.util.Pvm;
import lipvk.util.TekstinFormatointi;

/**
 *
 * @author anterova
 */
public class KaliPaneelit {
    
    public static JMenuBar menuBar(Kayttoliittyma kali) {
        JMenuBar menuBar = new JMenuBar();
        
        menuBar.add( tiedostoMenu(kali) );
        menuBar.add( kirjastoMenu(kali) );
        
        return menuBar;
    }
    
    private static JMenu tiedostoMenu(Kayttoliittyma kali) {
        JMenu tiedostoMenu = new JMenu( "Tiedosto" );
        
        // JMenuItem uusi = new JMenuItem( "Uusi" );
        
        JMenuItem lataaTiedosto = new JMenuItem( "Lataa" );
        lataaTiedosto.addActionListener( new LataaHavainnot(kali) );
        
        JMenuItem tallennaNimella = new JMenuItem("Tallenna");
        tallennaNimella.addActionListener( new TallennaHavainnot(kali) );
        
        // tiedostoMenu.add(uusi);
        tiedostoMenu.add(lataaTiedosto);
        tiedostoMenu.add(tallennaNimella);
        
        return tiedostoMenu;
    }
    
    
    
    private static JMenu kirjastoMenu(Kayttoliittyma kali) {
        JMenu kirjastoMenu = new JMenu( "Kirjasto" );
        
        JMenuItem lisaaLaji = new JMenuItem( "Lisää laji" );
        lisaaLaji.addActionListener( new LisaaLaji(kali) );
        
        kirjastoMenu.add(lisaaLaji);
        
        return kirjastoMenu;
    }
    
    public static JPanel uusiHavaintoKaavake( Kayttoliittyma kali ) {
        JPanel uhk = new JPanel( new GridLayout( 10, 1 ) );
        
        JTextField lajikentta = new JTextField();
        JLabel lajivirhe = new JLabel();
        JTextField paikkakentta = new JTextField();
        JLabel paikkavirhe = new JLabel();
        JTextField pvmkentta = new JTextField( Pvm.tanaan() );
        JLabel pvmvirhe = new JLabel();
        JTextField lkmkentta = new JTextField( "1" );
        JLabel lkmvirhe = new JLabel();
        JButton lisaaPainike = new JButton( "Lisää") ;
        
        lisaaPainike.addActionListener( new LisaaHavainto(kali, lajikentta, lajivirhe, 
                paikkakentta, paikkavirhe, 
                pvmkentta, pvmvirhe, 
                lkmkentta, lkmvirhe ) );
        
        lajikentta.addKeyListener( new NapinpainoNappaimistolta( lisaaPainike ) );
        paikkakentta.addKeyListener( new NapinpainoNappaimistolta( lisaaPainike ) );
        pvmkentta.addKeyListener( new NapinpainoNappaimistolta( lisaaPainike ) );
        lkmkentta.addKeyListener( new NapinpainoNappaimistolta( lisaaPainike ) );
        
        uhk.add( kaavakeRivi("Laji:", lajikentta, lajivirhe ) );
        uhk.add( kaavakeRivi("Havaintopaikka:", paikkakentta, paikkavirhe ) );
        uhk.add( kaavakeRivi("Pvm:", pvmkentta, pvmvirhe ) );
        uhk.add( kaavakeRivi("Lkm:", lkmkentta, lkmvirhe ) );
        uhk.add( kaavakeRivi("", lisaaPainike, new JLabel() ) );
        
        return uhk;
    }
    
    public static JPanel uusiLintulajiKaavake( Kayttoliittyma kali ) {
        JPanel ulk = new JPanel( new GridLayout( 5, 1 ) );
        
        JTextField nimikentta = new JTextField();
        JTextField latNimiKentta = new JTextField();
        JTextField heimoKentta = new JTextField();
        JTextField lahkoKentta = new JTextField();
        
        JLabel aaniSijainti = new JLabel("");
        JLabel kuvaSijainti = new JLabel("");
        
        
        
        JButton lisaa = new JButton("Lisää");
        lisaa.addActionListener( new LisaaLintulaji(nimikentta, latNimiKentta, 
                heimoKentta, lahkoKentta, aaniSijainti, kuvaSijainti, kuvaSijainti, kali) );
        
        nimikentta.addKeyListener(new NapinpainoNappaimistolta(lisaa) );
        latNimiKentta.addKeyListener(new NapinpainoNappaimistolta(lisaa) );
        heimoKentta.addKeyListener(new NapinpainoNappaimistolta(lisaa) );
        lahkoKentta.addKeyListener(new NapinpainoNappaimistolta(lisaa) );
        
        ulk.add( kaavakeRivi( "Nimi:", nimikentta , new JLabel() ) );
        ulk.add( kaavakeRivi( "Tieteellinen nimi:", latNimiKentta , new JLabel() ) );
        ulk.add( kaavakeRivi( "Heimo:", heimoKentta , new JLabel() ) );
        ulk.add( kaavakeRivi( "Lahko:", lahkoKentta , new JLabel() ) );
        ulk.add( kaavakeRivi("", lisaa, new JLabel()) );
        
        return ulk;
    }
    
    private static JPanel kaavakeRivi( String nimi, Component component, Component virheilmoitukset ) {
        JPanel rivi = new JPanel( new GridLayout(1,3) );
        
        rivi.add( new JLabel(nimi) );
        if(component != null) rivi.add( component );
        if(virheilmoitukset != null) rivi.add( virheilmoitukset );
        
        return rivi;
    }
    
    public static JPanel lintukortti( Lintulaji laji, Kayttoliittyma kali ) {
        if(laji == null) return new JPanel();
        
        JPanel lintukortti = new JPanel( new GridLayout(1, 2) );
        
        lintukortti.add( lintufaktat(laji, kali) );
        lintukortti.add( havainnot(laji) );
        
        return lintukortti;
    }
    
    private static JPanel lintufaktat(Lintulaji laji, Kayttoliittyma kali) {
        JPanel paneeli = new JPanel( new GridLayout(2,1) );
        
        JPanel lintufaktat = new JPanel(new GridLayout(7, 1));
        
        JButton aaniNappi = new JButton("Lauluääni");
        aaniNappi.addActionListener(new SoitaAudio(null));
        
        lintufaktat.add( kentta( "Laji:", TekstinFormatointi.isoAlkukirjain( laji.getNimi() ) ) );
        lintufaktat.add( kentta( "Latinankielinen nimi:", TekstinFormatointi.isoAlkukirjain(laji.getLatNimi()) ) );
        lintufaktat.add( kentta( "Heimo:", TekstinFormatointi.isoAlkukirjain( laji.getHeimo() )) );
        lintufaktat.add( kentta( "Lahko:", TekstinFormatointi.isoAlkukirjain( laji.getLahko() ) ) );
        lintufaktat.add( kentta( "Havaintoja:", laji.getHavaintoja() + "" ) );
        lintufaktat.add(aaniNappi);
        
        paneeli.add(lintufaktat);
        paneeli.add(kuva(laji, kali));
        
        return paneeli;
    }
    
    private static Component kuva(Lintulaji laji, Kayttoliittyma kali) {
        if(laji.getKuvat().isEmpty()) {
            JButton lisaaKuva = new JButton("Lisää kuva");
            lisaaKuva.addActionListener(new LisaaKuva(laji.getNimi(), kali));
            return lisaaKuva;
        }
        Dimension ikkunanKoko = kali.getKoko();
        
        return new Kuvapaneeli( laji.getKuvat().get(0), (int) ikkunanKoko.getWidth() / 4, (int) ikkunanKoko.getHeight() / 4 );
        
    }
    
    private static JPanel kentta(String nimi, String tiedot) {
        JPanel nimikentta = new JPanel( new GridLayout(1,2) );
        
        nimikentta.add( new JLabel(nimi) );
        nimikentta.add( new JLabel(tiedot) );
        
        return nimikentta;
    }
    
    private static JPanel havainnot( Lintulaji laji ) {
        JPanel havaintokortti = new JPanel( new BorderLayout() );
        
        JPanel ylasarake = new JPanel(new GridLayout(2,1));
        
        GridLayout layout = new GridLayout(1, 3);
        
        JPanel otsikko = new JPanel( layout );
        JPanel ylarivi = new JPanel( layout );
        
        otsikko.add( new JLabel("") );
        otsikko.add( new JLabel("HAVAINNOT:") );
        otsikko.add( new JLabel("") );
        
        ylarivi.add( new JLabel("Pvm") );
        ylarivi.add( new JLabel("Paikka") );
        ylarivi.add( new JLabel("Lkm") );
        
        ylasarake.add( otsikko );
        ylasarake.add( ylarivi );
        
        int riveja = laji.getHavaintoja();
        if(riveja < 14) riveja = 14;
        JPanel havainnot = new JPanel( new GridLayout(riveja, 1) );
        
        JPanel havaintosarake;
        
        for (Havainto havainto : laji.getHavainnot()) {
            havaintosarake = new JPanel( layout );
            
            havaintosarake.add( new JLabel( havainto.formatoiPvm() ));
            havaintosarake.add( new JLabel( TekstinFormatointi.isoAlkukirjain( havainto.getPaikka().toString() )) );
            havaintosarake.add( new JLabel( havainto.getLkm() + "" ) );
            
            havainnot.add(havaintosarake);
        }
        
        JScrollPane scroller = new JScrollPane(havainnot, 
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        havaintokortti.add(ylasarake, BorderLayout.NORTH);
        havaintokortti.add(scroller, BorderLayout.CENTER);
        
        return havaintokortti;
    }
    
}
