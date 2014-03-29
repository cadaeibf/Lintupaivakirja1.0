/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.hlk;

import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lipvk.takut.HavainnonValinta;
import lipvk.ohlo.Havainto;

/**
 *
 * @author anterova
 */
public class Havaintopaneeli extends JPanel {
    private JCheckBox valintaruutu;
    private Havainto havainto;

    public Havaintopaneeli(Havainto havainto) {
        super(new GridLayout(1,5));
        this.havainto = havainto;
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        valintaruutu = new JCheckBox();
        valintaruutu.addActionListener(new HavainnonValinta(valintaruutu, havainto));
        
        add(valintaruutu);
        add(new JLabel(havainto.getLaji().toString()));
        add(new JLabel(havainto.getPvm().toString()));
        add(new JLabel(havainto.getPaikka().toString()));
        add(new JLabel(havainto.getLkm() + ""));
    }
    
    
}
