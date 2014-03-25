/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.ohjelmalogiikka;

import java.util.ArrayList;

/**
 *
 * @author anterova
 */
public class Havaintolista {
    ArrayList<Havainto> havaintolista;

    public Havaintolista() {
        havaintolista = new ArrayList();
    }
    
    public void lisaa(Havainto havainto) {
        havaintolista.add(havainto);
    }
    
    public void poista(Havainto havainto) {
        if(havaintolista.contains(havainto)) {
            havaintolista.remove(havainto);
        }
    }
    
    public void jarjestaNimi() {
        
    }
}
