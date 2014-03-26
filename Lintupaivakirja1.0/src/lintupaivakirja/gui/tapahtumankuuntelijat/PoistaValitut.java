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
public class PoistaValitut implements ActionListener {
    private Havaintolistakaavake lista;

    public PoistaValitut(Havaintolistakaavake lista) {
        this.lista = lista;
        System.out.println("");
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        lista.poistaValitut();
    }
    
}
