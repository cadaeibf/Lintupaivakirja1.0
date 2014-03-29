/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.tapahtumankuuntelijat.painikkeet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lintupaivakirja.kali.keskuspaneeli.havaintolistakaavake.Havaintolistakaavake;

/**
 *
 * @author anterova
 */
public class JarjestaPaikka implements ActionListener {
    private Havaintolistakaavake lista;

    public JarjestaPaikka(Havaintolistakaavake lista) {
        this.lista = lista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        lista.vaihdaJarjestamisperuste(2);
    }
    
}
