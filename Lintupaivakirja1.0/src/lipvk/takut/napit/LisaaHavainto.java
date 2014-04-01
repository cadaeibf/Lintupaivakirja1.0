/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Havaintopaikka;

/**
 *
 * @author anterova
 */
public class LisaaHavainto implements ActionListener {
    private JTextField lajikentta;
    private JTextField paikkakentta;
    private JTextField pvmkentta;
    private JTextField lkmkentta;
    
    private Havaintolistakaavake lista;

    public LisaaHavainto(JTextField lajikentta, JTextField paikkakentta, JTextField pvmkentta, JTextField lkmkentta, Havaintolistakaavake lista) {
        this.lajikentta = lajikentta;
        this.paikkakentta = paikkakentta;
        this.pvmkentta = pvmkentta;
        this.lkmkentta = lkmkentta;
        this.lista = lista;
    }

    public LisaaHavainto(Havaintolistakaavake lista) {
        this.lista = lista;
    }
    
    public GregorianCalendar luePvm() {
        GregorianCalendar pvm = new GregorianCalendar();
        
        String[] data = pvmkentta.getText().split("\\.");
        
        pvm.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data[0]));
        pvm.set(Calendar.MONTH, (Integer.parseInt(data[1]) - 1));
        pvm.set(Calendar.YEAR, Integer.parseInt(data[2]));
        
        return pvm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista.lisaaHavainto(lajikentta.getText(), 
                new Havainto( new Havaintopaikka(paikkakentta.getText()), 
                luePvm(), 
                Integer.parseInt(lkmkentta.getText()) ));
        lajikentta.setText("");
    }
    
}
