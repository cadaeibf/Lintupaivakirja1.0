/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.vasen;

import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;
import lipvk.takut.napit.LisaaHavainto;
import lipvk.takut.LisaaHavaintoNappaimistolla;
import lipvk.dom.Pvm;

/**
 *
 * @author anterova
 */
public class UusiHavaintoKaavake extends JPanel {

    public UusiHavaintoKaavake() {
        super(new GridLayout(6,3));
    }
    
    public void luoKomponentit(Havaintolistakaavake havaintolistakaavake, Tallennussijaintipalkki tspalkki) {
        JButton lisaa = new JButton("Lisää");
        JTextField nimikentta = new JTextField("");
        JLabel latinalainennimikentta = new JLabel("");
        JTextField paikkakentta = new JTextField("");
        
        Calendar cal = Calendar.getInstance();
        Pvm pvm = new Pvm( cal.get(Calendar.DAY_OF_MONTH),
                    cal.get(Calendar.MONTH)+1,
                    cal.get(Calendar.YEAR)
                );
        
        JTextField pvmkentta = new JTextField(pvm.toString());
        JTextField lkmkentta = new JTextField("1");
        
        LisaaHavaintoNappaimistolla avaimenKuuntelija = new LisaaHavaintoNappaimistolla(lisaa);
        
        nimikentta.addKeyListener(avaimenKuuntelija);
        pvmkentta.addKeyListener(avaimenKuuntelija);
        paikkakentta.addKeyListener(avaimenKuuntelija);
        lkmkentta.addKeyListener(avaimenKuuntelija);
        
        lisaa.addActionListener(new LisaaHavainto(nimikentta, paikkakentta, pvmkentta, lkmkentta, havaintolistakaavake));
        
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
        add(lisaa);
    }
    
}
