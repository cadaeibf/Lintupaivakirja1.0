/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import lipvk.gui.Kayttoliittyma;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class LisaaLintulaji implements ActionListener {
    private JTextField nimiKentta;
    private JTextField latNimiKentta;
    private JTextField heimoKentta;
    private JTextField lahkoKentta;
    private JLabel aaniKentta;
    private JLabel kuvaKentta;
    private JLabel virheilmoitukset;
    
    private Kayttoliittyma kali;

    public LisaaLintulaji(JTextField nimiKentta, JTextField latNimiKentta, JTextField heimoKentta, 
            JTextField lahkoKentta, JLabel aaniKentta, JLabel kuvaKentta, JLabel virheilmoitukset, Kayttoliittyma kali) {
        
        this.nimiKentta = nimiKentta;
        this.latNimiKentta = latNimiKentta;
        this.heimoKentta = heimoKentta;
        this.lahkoKentta = lahkoKentta;
        this.aaniKentta = aaniKentta;
        this.kuvaKentta = kuvaKentta;
        this.virheilmoitukset = virheilmoitukset;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nimi = nimiKentta.getText().toLowerCase();
        if( nimi.equals("") ) {
            virheilmoitukset.setText("Syötä lintulajin nimi");
            return;
        }
        if( kali.getLintulista().sisaltaa(nimi) ) {
            virheilmoitukset.setText("Annettu laji löytyy jo listasta");
            return;
        }
        
        Lintulaji uusi = new Lintulaji( nimi );
        if(!latNimiKentta.getText().equals("")) uusi.setLatNimi( latNimiKentta.getText().toLowerCase() );
        if(!heimoKentta.getText().equals("")) uusi.setHeimo(heimoKentta.getText().toLowerCase() );
        if(!lahkoKentta.getText().equals("")) uusi.setLahko(lahkoKentta.getText().toLowerCase() );
        kali.lisaaLaji(uusi);
        virheilmoitukset.setText("");
    }
    
}
