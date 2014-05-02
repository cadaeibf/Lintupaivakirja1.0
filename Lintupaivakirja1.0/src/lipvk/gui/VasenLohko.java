/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author anterova
 */
public class VasenLohko extends JPanel {
    private UusiHavaintoKaavake uhk;
    private JTabbedPane vasAl;

    public VasenLohko() {
        super(new GridLayout(2,1));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        uhk = new UusiHavaintoKaavake();
        vasAl = new JTabbedPane();
        
        add(uhk);
        add(vasAl);
    }
    
    public void lisaaTakut() {
        uhk.luoKomponentit();
    }
    
    public void lisaaLintukortti(String nimi, Lintukortti lintukortti) {
        poistaLintukortit();
        
        vasAl.addTab(nimi, lintukortti);
        
        vasAl.setSelectedIndex(1);
        
        vasAl.repaint();
        vasAl.revalidate();
    }
    
    public void poistaLintukortit() {
        while( vasAl.getTabCount() > 1 ) vasAl.remove(1);
    }

    public void paivita() {
        removeAll();
        
        luoKomponentit();
        
        repaint();
        revalidate();
    }
}


