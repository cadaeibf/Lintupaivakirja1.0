/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lipvk.takut.napit.LisaaLintulaji;
import lipvk.takut.napit.TyhjennaKentta;
import lipvk.takut.napit.ValitseAani;

/**
 * GUI-luokka uuden lintulajin lisäämiseen.
 * @author anterova
 */
public class UusiLintulajiKaavake extends JPanel {
    private JTextField nimiKentta;
    private JTextField latNimiKentta;
    private JTextField heimoKentta;
    private JTextField lahkoKentta;
    private JLabel aaniKentta;
    private JLabel kuvaKentta;
    private JLabel virheilmoitukset;

    public UusiLintulajiKaavake(Kayttoliittyma kali) {
        super(new GridLayout(10, 3));
        
        luoKomponentit(kali);
    }
    
    private void luoKomponentit(Kayttoliittyma kali) {
        add( new JLabel("Nimi:") );
        add( nimiKentta = new JTextField() );
        add( virheilmoitukset = new JLabel("") );
        add( new JLabel("Latinankielinen nimi:") );
        add( latNimiKentta = new JTextField() );
        add( new JLabel("") );
        add( new JLabel("Heimo:") );
        add( heimoKentta = new JTextField() );
        add( new JLabel("") );
        add( new JLabel("Lahko:") );
        add( lahkoKentta = new JTextField() );
        add( new JLabel("") );
        add( aaniKentta = new JLabel("") );
        
        JButton valitseAani = new JButton("Valitse ääni");
        valitseAani.addActionListener( new ValitseAani(aaniKentta) );
        add( valitseAani );
        
        JButton tyhjennaAani = new JButton("Poista ääni");
        tyhjennaAani.addActionListener( new TyhjennaKentta(aaniKentta) );
        add( tyhjennaAani );
        
        add( kuvaKentta = new JLabel("") );
        add( new JButton("Lisää kuva") );
        add( new JLabel("") );
        add( new JLabel("") );
        
        JButton valmis = new JButton("Valmis");
        valmis.addActionListener(new LisaaLintulaji(nimiKentta, latNimiKentta, 
                heimoKentta, lahkoKentta, aaniKentta, kuvaKentta, 
                virheilmoitukset, kali));
        add( valmis );
        
        for (int i = 0; i < 9; i++) {
            add( new JLabel("") );
        }
    }
    
}
