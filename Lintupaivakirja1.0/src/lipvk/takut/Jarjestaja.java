/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;

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
        lista.jarjesta(jarjestamisperuste);
    }
    
}
