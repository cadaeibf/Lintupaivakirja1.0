/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lipvk.main.Kayttoliittyma;
import lipvk.takut.LisaaHavaintoNappaimistolta;
import lipvk.takut.napit.LisaaHavainto;

/**
 *
 * @author anterova
 */
public class UusiHavaintoKaavake extends JPanel {

    public UusiHavaintoKaavake( Kayttoliittyma kali ) {
        super(new GridLayout( 10,1 ));
        
        luoKomponentit(kali);
    }
    
    private void luoKomponentit( Kayttoliittyma kali ) {
        JTextField lajikentta = new JTextField();
        JTextField paikkakentta = new JTextField();
        JTextField pvmkentta = new JTextField( tulostaPvm() );
        JTextField lkmkentta = new JTextField( "1" );
        JButton lisaaPainike = new JButton( "Lisää") ;
        
        lisaaPainike.addActionListener( new LisaaHavainto(lajikentta, paikkakentta, pvmkentta, lkmkentta, kali) );
        
        lajikentta.addKeyListener( new LisaaHavaintoNappaimistolta( lisaaPainike ) );
        paikkakentta.addKeyListener( new LisaaHavaintoNappaimistolta( lisaaPainike ) );
        pvmkentta.addKeyListener( new LisaaHavaintoNappaimistolta( lisaaPainike ) );
        lkmkentta.addKeyListener( new LisaaHavaintoNappaimistolta( lisaaPainike ) );
        
        lisaaKentta( "", new JLabel("UUSI HAVAINTO:") );
        lisaaKentta( "Laji:", lajikentta );
        lisaaKentta( "Havaintopaikka:", paikkakentta );
        lisaaKentta( "Päivämäärä:", pvmkentta );
        lisaaKentta( "Lkm:", lkmkentta);
        lisaaKentta("", lisaaPainike);
    }
    
    private void lisaaKentta(String teksti, Component komponentti) {
        JPanel kentta = new JPanel( new GridLayout( 1, 3 ) );
        
        kentta.add( new JLabel( teksti ) );
        kentta.add( komponentti );
        kentta.add( new JLabel( "" ) );
        
        
        add( kentta );
    }
    
    private String tulostaPvm() {
        Calendar cal = Calendar.getInstance();
        
        return cal.get(Calendar.DAY_OF_MONTH) + "." + ( cal.get(Calendar.MONTH) + 1 ) + "." + cal.get(Calendar.YEAR);
    }
    
}
