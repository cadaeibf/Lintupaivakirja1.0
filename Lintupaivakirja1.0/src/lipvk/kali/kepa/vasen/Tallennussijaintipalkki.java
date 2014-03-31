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
        this.tiedostonimikentta = new JTextField(tiedostonimi.replace(".txt", ""));
        ilmoituskentta = new JLabel();
        
        tiedostonimikentta.addKeyListener( new LataaTiedostoNappaimistolta( lataaPainike ) );
        
        add(new JLabel("Tallennustiedosto:"));
        add(tiedostonimikentta);
        add(ilmoituskentta);
    }
    
    public void muutoksiaTehty() {
        ilmoituskentta.setText("Muutoksia tehty");
    }
    
    public void tiedostoTallennettu() {
        ilmoituskentta.setText("Tiedosto tallennettu");
    }
    
    public void tiedostoLadattu() {
        ilmoituskentta.setText("Tiedosto ladattu");
    }
    
    public void tiedostoaEiLoydy() {
        ilmoituskentta.setText("Annettua tiedostoa ei löytynyt");
    }
    
    public String getTiedostonimi() {
        return tiedostonimikentta.getText() + ".txt";
    }
}
