/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lipvk.takut.LisaaHavaintoNappaimistolta;
import lipvk.takut.napit.LisaaHavainto;
import lipvk.util.Pvm;

/**
 *
 * @author anterova
 */
public class KaliPaneelit {
    
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
        
        lajikentta.addKeyListener( new LisaaHavaintoNappaimistolta( lisaaPainike ) );
        paikkakentta.addKeyListener( new LisaaHavaintoNappaimistolta( lisaaPainike ) );
        pvmkentta.addKeyListener( new LisaaHavaintoNappaimistolta( lisaaPainike ) );
        lkmkentta.addKeyListener( new LisaaHavaintoNappaimistolta( lisaaPainike ) );
        
        uhk.add( kaavakeRivi("Laji:", lajikentta, lajivirhe ) );
        uhk.add( kaavakeRivi("Havaintopaikka:", paikkakentta, paikkavirhe ) );
        uhk.add( kaavakeRivi("Pvm:", pvmkentta, pvmvirhe ) );
        uhk.add( kaavakeRivi("Lkm:", lkmkentta, lkmvirhe ) );
        uhk.add( kaavakeRivi("", lisaaPainike, new JLabel() ) );
        
        return uhk;
    }
    
    public static JPanel uusiLintulajiKaavake( Kayttoliittyma kali ) {
        JPanel ulk = new JPanel( new GridLayout( 10, 1 ) );
        
        JTextField nimikentta = new JTextField();
        JTextField latNimiKentta = new JTextField();
        JTextField heimoKentta = new JTextField();
        JTextField lahkoKentta = new JTextField();
        
        JLabel aaniSijainti = new JLabel("");
        JLabel kuvaSijainti = new JLabel("");
        
        ulk.add( kaavakeRivi( "Nimi:", nimikentta , new JLabel() ) );
        ulk.add( kaavakeRivi( "Tieteellinen nimi:", latNimiKentta , new JLabel() ) );
        ulk.add( kaavakeRivi( "Heimo:", heimoKentta , new JLabel() ) );
        ulk.add( kaavakeRivi( "Lahko:", lahkoKentta , new JLabel() ) );
        
        return ulk;
    }
    
    private static JPanel kaavakeRivi( String nimi, Component component, Component virheilmoitukset ) {
        JPanel rivi = new JPanel( new GridLayout(1,3) );
        
        rivi.add( new JLabel(nimi) );
        if(component != null) rivi.add( component );
        if(virheilmoitukset != null) rivi.add( virheilmoitukset );
        
        return rivi;
    }
    
}
