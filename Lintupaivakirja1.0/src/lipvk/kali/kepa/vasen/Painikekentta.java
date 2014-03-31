/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.vasen;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;
import lipvk.takut.napit.Lataa;
import lipvk.takut.napit.Tallenna;

/**
 *
 * @author anterova
 */
public class Painikekentta extends JPanel {
    private Tallennussijaintipalkki tallennussijaintipalkki;
    private String tiedostonimi;
    
    private JButton vaihdaTiedosto;
    private JButton tallenna;
    private JButton lataa;
    private JButton tuo;
    private JButton vie;

    public Painikekentta() {
        super(new GridLayout(10,1));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        tiedostonimi = "save1.txt";
        
        tallenna = new JButton("Tallenna");
        lataa = new JButton("Lataa");
        tuo = new JButton("Tuo...");
        vie = new JButton("Vie...");
        tallennussijaintipalkki = new Tallennussijaintipalkki(tiedostonimi, lataa);
        
        
        add(tallennussijaintipalkki);
        add(lataa);
        add(tallenna);
        add(tuo);
        add(vie);
    }
    
    public Tallennussijaintipalkki tallennussijaintipalkki() {
        return tallennussijaintipalkki;
    }
    
    public void lisaaTakut(Havaintolistakaavake lista) {
        tallenna.addActionListener( new Tallenna( tallennussijaintipalkki, lista ) );
        lataa.addActionListener( new Lataa( tallennussijaintipalkki, lista ) );
    }
    
    
}
