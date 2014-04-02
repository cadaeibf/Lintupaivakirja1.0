/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.vasen;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;
import lipvk.rajapinnat.Paivitettava;

/**
 *
 * @author anterova
 */
public class VasenLohko extends JPanel implements Paivitettava {
    private UusiHavaintoKaavake uhk;
    private JTabbedPane vasAl;
    private TallennusPaneeli tp;

    public VasenLohko() {
        super(new GridLayout(2,1));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        uhk = new UusiHavaintoKaavake();
        vasAl = new JTabbedPane();
        tp = new TallennusPaneeli();
        
        vasAl.add("Lataa / Tallenna", tp);
        
        add(uhk);
        add(vasAl);
    }
    
    public void lisaaTakut(Havaintolistakaavake lista) {
        uhk.luoKomponentit(lista, tp.tallennussijaintipalkki());
        tp.lisaaTakut(lista);
    }
    
    public Tallennussijaintipalkki tallennussijaintipalkki() {
        return tp.tallennussijaintipalkki();
    }
    
    public void lisaaLintukortti(String nimi, Lintukortti lintukortti) {
        while( vasAl.getTabCount() > 1 ) vasAl.remove(1);
        
        vasAl.addTab(nimi, lintukortti);
        
        vasAl.setSelectedIndex(1);
        
        vasAl.repaint();
        vasAl.revalidate();
    }

    @Override
    public void paivita() {
        removeAll();
        
        luoKomponentit();
        
        repaint();
        revalidate();
    }
    
    public void asetaIlmoitus(String ilmoitusteksti) {
        tp.ilmoitus(ilmoitusteksti);
    }
}


