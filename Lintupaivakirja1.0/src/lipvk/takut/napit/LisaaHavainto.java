/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import lipvk.gui.Kayttoliittyma;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Havaintopaikka;
import lipvk.util.Pvm;

/**
 *
 * @author anterova
 */
public class LisaaHavainto implements ActionListener {
    private Kayttoliittyma kali;
    
    private JTextField lajikentta;
    private JLabel lajivirhe;
    private JTextField paikkakentta;
    private JLabel paikkavirhe;
    private JTextField pvmkentta;
    private JLabel pvmvirhe;
    private JTextField lkmkentta;
    private JLabel lkmvirhe;
    

    public LisaaHavainto(Kayttoliittyma kali, 
            JTextField lajikentta, JLabel lajivirhe, 
            JTextField paikkakentta, JLabel paikkavirhe, 
            JTextField pvmkentta, JLabel pvmvirhe, 
            JTextField lkmkentta, JLabel lkmvirhe ) {
        this.lajikentta = lajikentta;
        this.lajivirhe = lajivirhe;
        this.paikkakentta = paikkakentta;
        this.paikkavirhe = paikkavirhe;
        this.pvmkentta = pvmkentta;
        this.pvmvirhe = pvmvirhe;
        this.lkmkentta = lkmkentta;
        this.lkmvirhe = lkmvirhe;
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Calendar pvm = Pvm.luePvm( pvmkentta.getText() );
            kali.lisaaHavainto( lajikentta.getText().toLowerCase(), 
                    new Havainto( new Havaintopaikka( paikkakentta.getText().toLowerCase() ), 
                        pvm, 
                        Integer.parseInt(lkmkentta.getText()) ));
            lajikentta.setText("");
            lajivirhe.setText("");
            pvmvirhe.setText("");
        } catch(NullPointerException npe) {
            lajivirhe.setText("Annettua lajia ei löytynyt listasta");
        } catch(IllegalArgumentException iae) {
            pvmvirhe.setText("Virheellinen päivämäärä");
            System.out.println("virhe");
        }
    }
    
}
