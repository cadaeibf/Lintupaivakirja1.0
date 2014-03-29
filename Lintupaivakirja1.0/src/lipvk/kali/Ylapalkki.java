package lipvk.kali;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lipvk.rajapinnat.Paivitettava;

/**
 *
 * @author anterova
 */
public class Ylapalkki extends JPanel implements Paivitettava {
    private JLabel pvmKentta;

    public Ylapalkki() {
        super(new GridLayout(1,6));
        luoKomponentit();
    }

    private void luoKomponentit() {
        for (int i = 0; i < 5; i++) {
            add(new JLabel(""));
        }
        pvmKentta = new JLabel();
        
        add(pvmKentta);
        
        paivita();
    }
    
    @Override
    public void paivita() {
        Calendar cal;
        cal = Calendar.getInstance();
        
        String tunnit = cal.get( Calendar.HOUR_OF_DAY ) + "";
        if(tunnit.length() == 1) tunnit = "0" + tunnit;
        
        String minuutit = cal.get( Calendar.MINUTE ) + "";
        if( minuutit.length() == 1 ) minuutit = "0" + minuutit;
        
        pvmKentta.setText( tunnit + ":" + minuutit + " " 
                + cal.get( Calendar.DAY_OF_MONTH ) + "." 
                + ( cal.get( Calendar.MONTH ) + 1 ) + "." 
                + cal.get( Calendar.YEAR ) );
        
        repaint();
    }
    
}
