/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.vasen;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anterova
 */
public class Tallennussijaintipalkki extends JPanel {
    private JTextField tiedostonimikentta;
    private JLabel ilmoituskentta;

    public Tallennussijaintipalkki(String tiedostonimi) {
        super( new GridLayout(1,3) );
        
        this.tiedostonimikentta = new JTextField(tiedostonimi);
        ilmoituskentta = new JLabel();
        
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
}
