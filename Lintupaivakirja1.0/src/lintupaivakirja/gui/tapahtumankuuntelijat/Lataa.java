/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lintupaivakirja.gui.paneelit.Havaintolistakaavake;
import lintupaivakirja.gui.paneelit.Tallennussijaintipalkki;

/**
 *
 * @author anterova
 */
public class Lataa implements ActionListener {
    private Havaintolistakaavake lista;
    private Tallennussijaintipalkki tspalkki;

    public Lataa(Havaintolistakaavake lista, Tallennussijaintipalkki tspalkki) {
        this.lista = lista;
        this.tspalkki = tspalkki;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista.lataa();
        tspalkki.tiedostoLadattu();
    }
    
}
