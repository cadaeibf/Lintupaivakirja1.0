/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JPanel;
import lintupaivakirja.ohjelmalogiikka.Havainto;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;

/**
 *
 * @author anterova
 */
public class Havaintolistakaavake extends JPanel {
    private HavaintolistaYlarivi ylarivi;
    private Havaintolista lista;

    public Havaintolistakaavake(Havaintolista havaintolista) {
        super(new GridLayout(0,1));
        lista = havaintolista;
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        ylarivi = new HavaintolistaYlarivi();
        
        add(new Havaintolistaotsikko());
        add(ylarivi);
        
        lisaaHavainnot();
    }
    
    private void paivita() {
        removeAll();
        add(new Havaintolistaotsikko());
        add(ylarivi);
        
        lisaaHavainnot();
    }
    
    public void lisaa(Havainto havainto) {
        lista.lisaa(havainto);
        paivita();
    }
    
   public Havaintolista getLista() {
       return lista;
   }
    
    private void lisaaHavainnot() {
        for (int i = 0; i < lista.getHavaintoja(); i++) {
            add(new Havaintopaneeli(lista.get(i)));
        }
    }
    
}
