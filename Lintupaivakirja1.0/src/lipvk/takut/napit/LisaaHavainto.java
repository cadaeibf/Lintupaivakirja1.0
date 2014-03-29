/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Havaintopaikka;
import lipvk.ohlo.Lintulaji;
import lipvk.dom.Pvm;

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
        Lintulaji laji;
        Havaintopaikka paikka;
        try {
            laji = new Lintulaji(nimikentta.getText());
            paikka = new Havaintopaikka(paikkakentta.getText());
        } catch (Exception ex) {
            return;
        }
        
        Havainto uusi = new Havainto(laji, luePvm(pvmkentta.getText()), 
                paikka, Integer.parseInt(lkmkentta.getText()));
        
        havaintolistakaavake.lisaa(uusi);
        
        nimikentta.setText("");
        
        System.out.println("");
    }
    
    private Pvm luePvm(String teksti) {
        String[] tekstit = teksti.split("\\.");
        
        int pv = Integer.parseInt(tekstit[0]);
        int kk = Integer.parseInt(tekstit[1]);
        int vvvv = Integer.parseInt(tekstit[2]);
        
        return new Pvm(pv,kk,vvvv);
    }
    
}
