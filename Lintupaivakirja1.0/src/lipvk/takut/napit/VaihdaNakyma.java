/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;

/**
 *
 * @author anterova
 */
public class VaihdaNakyma implements ActionListener {
    private int nakyma;
    private JRadioButton painike;
    private Havaintolistakaavake lista;

    public VaihdaNakyma(int nakyma, JRadioButton painike, Havaintolistakaavake lista) {
        this.nakyma = nakyma;
        this.painike = painike;
        this.lista = lista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista.vaihdaNakyma(nakyma);
    }
    
    
}
