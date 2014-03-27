/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lintupaivakirja.gui.paneelit.Havaintolistakaavake;

/**
 *
 * @author anterova
 */
public class Jarjestaja implements ActionListener {
    private Havaintolistakaavake lista;
    private int jarjestamisperuste;

    public Jarjestaja(Havaintolistakaavake lista, int jarjestamisperuste) {
        this.lista = lista;
        this.jarjestamisperuste = jarjestamisperuste;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista.vaihdaJarjestamisperuste(jarjestamisperuste);
    }
    
}
