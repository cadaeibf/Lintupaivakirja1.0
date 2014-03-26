/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lintupaivakirja.gui.tapahtumankuuntelijat.LisaaHavainto;
import lintupaivakirja.gui.tapahtumankuuntelijat.LisaaHavaintoNappaimistolla;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;
import lintupaivakirja.util.Pvm;

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
    private Havaintolista lista;

    public UusiHavaintoKaavake(Havaintolistakaavake havaintolistakaavake) {
        super(new GridLayout(6,3));
        lista = havaintolistakaavake.getLista();
        
        luoKomponentit(havaintolistakaavake);
    }

    private void luoKomponentit(Havaintolistakaavake havaintolistakaavake) {
        nimikentta = new JTextField("ankka");
        latinalainennimikentta = new JLabel("");
        paikkakentta = new JTextField("helsinki");
        
        
        Calendar cal = Calendar.getInstance();
        Pvm pvm = new Pvm(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR));
        pvmkentta = new JTextField(pvm.toString());
        lkmkentta = new JTextField("1");
        lisaaPainike = new JButton("Lisää");
        
        lisaaPainike.addActionListener(new LisaaHavainto(nimikentta, paikkakentta, pvmkentta, lkmkentta, havaintolistakaavake));
        
        LisaaHavaintoNappaimistolla avaimenKuuntelija = new LisaaHavaintoNappaimistolla(lisaaPainike);
        nimikentta.addKeyListener(avaimenKuuntelija);
        pvmkentta.addKeyListener(avaimenKuuntelija);
        paikkakentta.addKeyListener(avaimenKuuntelija);
        lkmkentta.addKeyListener(avaimenKuuntelija);
        
        add(new JLabel(""));
        add(new JLabel("UUSI HAVAINTO:"));
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
