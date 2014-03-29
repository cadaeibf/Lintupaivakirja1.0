/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.kali.keskuspaneeli.vasenlohko;

import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lintupaivakirja.kali.keskuspaneeli.havaintolistakaavake.Havaintolistakaavake;
import lintupaivakirja.tapahtumankuuntelijat.LisaaHavainto;
import lintupaivakirja.tapahtumankuuntelijat.LisaaHavaintoNappaimistolla;
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

    public UusiHavaintoKaavake() {
        super(new GridLayout(6,3));
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        nimikentta = new JTextField("");
        latinalainennimikentta = new JLabel("");
        paikkakentta = new JTextField("");
        
        
        Calendar cal = Calendar.getInstance();
        Pvm pvm = new Pvm(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH)+1, cal.get(Calendar.YEAR));
        pvmkentta = new JTextField(pvm.toString());
        lkmkentta = new JTextField("1");
        lisaaPainike = new JButton("Lisää");
        
        
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
        
        add(new JLabel("Havaintopaikka:"));
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
    
    public void lisaaPainikkeet(Havaintolistakaavake havaintolistakaavake, Tallennussijaintipalkki tspalkki) {
        lisaaPainike.addActionListener(new LisaaHavainto(nimikentta, paikkakentta, pvmkentta, lkmkentta, havaintolistakaavake, tspalkki));
    }
    
    
}
