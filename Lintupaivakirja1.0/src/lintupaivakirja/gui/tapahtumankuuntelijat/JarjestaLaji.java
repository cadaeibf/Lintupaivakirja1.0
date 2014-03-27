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
public class JarjestaLaji implements ActionListener {
    private Havaintolistakaavake lista;

    public JarjestaLaji(Havaintolistakaavake lista) {
        this.lista = lista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista.vaihdaJarjestamisperuste(0);
    }
}
