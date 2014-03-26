/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import lintupaivakirja.gui.paneelit.Havaintolistakaavake;
import lintupaivakirja.ohjelmalogiikka.Havainto;
import lintupaivakirja.ohjelmalogiikka.Havaintopaikka;
import lintupaivakirja.ohjelmalogiikka.Lintulaji;
import lintupaivakirja.util.Pvm;

/**
 *
 * @author anterova
 */
public class LisaaHavainto implements ActionListener {
    private JTextField nimikentta;
    private JTextField paikkakentta;
    private JTextField pvmkentta;
    private JTextField lkmkentta;
    private Havaintolistakaavake havaintolistakaavake;

    public LisaaHavainto(JTextField nimikentta, JTextField paikkakentta, JTextField pvmkentta, 
            JTextField lkmkentta, Havaintolistakaavake havaintolistakaavake) {
        this.nimikentta = nimikentta;
        this.paikkakentta = paikkakentta;
        this.pvmkentta = pvmkentta;
        this.lkmkentta = lkmkentta;
        this.havaintolistakaavake = havaintolistakaavake;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Havainto uusi = new Havainto(new Lintulaji(nimikentta.getText()), luePvm(pvmkentta.getText()), 
                new Havaintopaikka(paikkakentta.getText()));
        havaintolistakaavake.lisaa(uusi);
        
        nimikentta.setText("");
        
    }
    
    private Pvm luePvm(String teksti) {
        String[] tekstit = teksti.split("\\.");
        
        int pv = Integer.parseInt(tekstit[0]);
        int kk = Integer.parseInt(tekstit[1]);
        int vvvv = Integer.parseInt(tekstit[2]);
        
        return new Pvm(pv,kk,vvvv);
    }
    
}
