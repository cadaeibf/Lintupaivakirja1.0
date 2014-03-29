/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.kali.keskuspaneeli.vasenlohko;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anterova
 */
public class Tallennussijaintipalkki extends JPanel {
    private JTextField sijaintikentta;
    private JLabel ilmoituskentta;

    public Tallennussijaintipalkki(String tiedostonimi) {
        super( new GridLayout(1,3) );
        
        sijaintikentta = new JTextField(tiedostonimi);
        ilmoituskentta = new JLabel();
        
        add(new JLabel("Tallennuskohde:"));
        add(sijaintikentta);
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
