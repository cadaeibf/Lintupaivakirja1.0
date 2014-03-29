/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;

/**
 *
 * @author anterova
 */
public class PoistaValitut implements ActionListener {
    private Havaintolistakaavake lista;

    public PoistaValitut(Havaintolistakaavake lista) {
        this.lista = lista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        lista.poistaValitut();
    }
    
}
