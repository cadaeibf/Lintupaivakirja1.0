/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author anterova
 */
public class UusiHavaintoKaavake extends JPanel {
    private JTextField nimikentta;
    private JLabel latinalainennimikentta;
    private JTextField paikkakentta;
    private JTextField pvmkentta;
    private JTextField lkmkentta;
    private JButton lisaaPainike;

    public UusiHavaintoKaavake() {
        super(new GridLayout(6,3));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        nimikentta = new JTextField();
        latinalainennimikentta = new JLabel("");
        paikkakentta = new JTextField();
        pvmkentta = new JTextField();
        lkmkentta = new JTextField("1");
        lisaaPainike = new JButton("Lisää");
        
        add(new JLabel(""));
        add(new JLabel("UUSI HAVAINTO"));
        add(new JLabel(""));
        
        add(new JLabel("Laji:"));
        add(nimikentta);
        add(latinalainennimikentta);
        
        add(new JLabel("Paikka"));
        add(paikkakentta);
        add(new JLabel(""));
        
        add(new JLabel("Pvm:"));
        add(pvmkentta);
        add(new JLabel(""));
        
        add(new JLabel("Lkm:"));
        add(lkmkentta);
        add(new JLabel(""));
        
        add(new JLabel(""));
        add(new JLabel(""));
        add(lisaaPainike);
    }
    
    
    
    
}
