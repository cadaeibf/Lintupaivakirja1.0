/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.vasen;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lipvk.takut.LataaTiedostoNappaimistolta;

/**
 *
 * @author anterova
 */
public class Tallennussijaintipalkki extends JPanel {
    private JTextField tiedostonimikentta;
    private JLabel ilmoituskentta;

    public Tallennussijaintipalkki(String tiedostonimi, JButton lataaPainike) {
        super( new GridLayout(1,3) );
        
        luoKomponentit(tiedostonimi, lataaPainike);
    }
    
    private void luoKomponentit(String tiedostonimi, JButton lataaPainike) {
        this.tiedostonimikentta = new JTextField(tiedostonimi.replace(".xml", ""));
        ilmoituskentta = new JLabel();
        
        tiedostonimikentta.addKeyListener( new LataaTiedostoNappaimistolta( lataaPainike ) );
        
        add(new JLabel("Tallennustiedosto:"));
        add(tiedostonimikentta);
        add(ilmoituskentta);
    }
    
    public void asetaIlmoitus(String ilmoitusteksti) {
        ilmoituskentta.setText(ilmoitusteksti);
    }
    
    public String getTiedostonimi() {
        return tiedostonimikentta.getText() + ".xml";
    }
}
