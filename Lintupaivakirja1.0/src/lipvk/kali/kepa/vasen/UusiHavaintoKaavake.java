/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.vasen;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lipvk.dom.Pvm;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;
import lipvk.takut.napit.LisaaHavainto;
import lipvk.takut.LisaaHavaintoNappaimistolta;

/**
 *
 * @author anterova
 */
public class UusiHavaintoKaavake extends JPanel {

    public UusiHavaintoKaavake() {
        super(new GridLayout( 10,1 ));
    }
    
    public void luoKomponentit(Havaintolistakaavake havaintolistakaavake, Tallennussijaintipalkki tspalkki) {
        JTextField lajikentta = new JTextField();
        JTextField paikkakentta = new JTextField();
        JTextField pvmkentta = new JTextField( new Pvm().toString() );
        JTextField lkmkentta = new JTextField( "1" );
        JButton lisaaPainike = new JButton( "Lisää") ;
        
        lisaaPainike.addActionListener( new LisaaHavainto(lajikentta, paikkakentta, pvmkentta, lkmkentta, havaintolistakaavake) );
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
    
}
