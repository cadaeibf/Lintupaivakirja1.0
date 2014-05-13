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
        boolean virhe = false;
        
        String laji = lajikentta.getText().toLowerCase();
        if( !kali.getLintulista().sisaltaa(laji) ) {
            lajivirhe.setText("Annettua lajia ei löydy listasta");
            virhe = true;
        } else {
            lajivirhe.setText("");
        }
        
        String paikka = paikkakentta.getText().toLowerCase();
        if( paikka.equals("") ) {
            paikkavirhe.setText("Syötä paikkatiedot");
            virhe = true;
        } else  {
            paikkavirhe.setText("");
        }
        
        Calendar pvm = Calendar.getInstance();
        try{
            pvm = Pvm.luePvm( pvmkentta.getText() );
        } catch (Exception ex) {
            pvmvirhe.setText("Päivämäärä muodossa pp.kk.vvvv");
            virhe = true;
        }
        
        int lkm = 0;
        try {
            lkm = Integer.parseInt( lkmkentta.getText() );
            lkmvirhe.setText("");
        } catch (Exception ex) {
            lkmvirhe.setText("Virheellinen lukumäärä");
            virhe = true;
        }
        
        if(lkm < 1) {
            lkmvirhe.setText("Virheellinen lukumäärä");
            virhe = true;
        }
        
        if(virhe) return;
        
        kali.lisaaHavainto( laji, new Havainto( new Havaintopaikka( paikka ), 
                pvm, lkm ) );
        lajikentta.setText("");
        
        pvmvirhe.setText("");
    }
    
}
