/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lipvk.kali.kepa.hlk.Havaintolistakaavake;
import lipvk.kali.kepa.vasen.Tallennussijaintipalkki;

/**
 *
 * @author anterova
 */
public class Lataa implements ActionListener {
    private Tallennussijaintipalkki tspalkki;
    private Havaintolistakaavake lista;

    public Lataa(Tallennussijaintipalkki tspalkki, Havaintolistakaavake lista) {
        this.tspalkki = tspalkki;
        this.lista = lista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista.lataa( tspalkki.getTiedostonimi() );
    }
    
}
