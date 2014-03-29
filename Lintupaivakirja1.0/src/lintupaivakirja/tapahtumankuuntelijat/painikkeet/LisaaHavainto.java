/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.tapahtumankuuntelijat.painikkeet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import lintupaivakirja.kali.keskuspaneeli.havaintolistakaavake.Havaintolistakaavake;
import lintupaivakirja.kali.keskuspaneeli.vasenlohko.Tallennussijaintipalkki;
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
    private Tallennussijaintipalkki tspalkki;

    public LisaaHavainto(JTextField nimikentta, JTextField paikkakentta, JTextField pvmkentta, 
            JTextField lkmkentta, Havaintolistakaavake havaintolistakaavake, Tallennussijaintipalkki tspalkki) {
        this.nimikentta = nimikentta;
        this.paikkakentta = paikkakentta;
        this.pvmkentta = pvmkentta;
        this.lkmkentta = lkmkentta;
        this.havaintolistakaavake = havaintolistakaavake;
        this.tspalkki = tspalkki;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Lintulaji laji;
        Havaintopaikka paikka;
        try {
            laji = new Lintulaji(nimikentta.getText());
            paikka = new Havaintopaikka(paikkakentta.getText());
        } catch (Exception ex) {
            return;
        }
        
        
        Havainto uusi = new Havainto(laji, luePvm(pvmkentta.getText()), 
                new Havaintopaikka(paikkakentta.getText()), Integer.parseInt(lkmkentta.getText()));
        havaintolistakaavake.lisaa(uusi);
        tspalkki.muutoksiaTehty();
        
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
