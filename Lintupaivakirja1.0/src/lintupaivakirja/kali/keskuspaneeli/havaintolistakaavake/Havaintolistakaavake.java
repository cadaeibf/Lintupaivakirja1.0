/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.kali.keskuspaneeli.havaintolistakaavake;

import lintupaivakirja.kali.keskuspaneeli.vasenlohko.Tallennussijaintipalkki;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import lintupaivakirja.ohjelmalogiikka.Havainto;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;
import lintupaivakirja.ohjelmalogiikka.tallennus.Lataaja;
import lintupaivakirja.ohjelmalogiikka.tallennus.Tallentaja;
import lintupaivakirja.rajapinnat.Paivitettava;

/**
 *
 * @author anterova
 */
public class Havaintolistakaavake extends JPanel implements Paivitettava {
    private HavaintolistaYlarivi ylarivi;
    private ScrollattavaLista listapaneeli;
    private Havaintolista lista;

    public Havaintolistakaavake(Havaintolista havaintolista, Tallennussijaintipalkki tspalkki) {
        super(new BorderLayout());
        
        luoKomponentit(havaintolista, tspalkki);
    }

    private void luoKomponentit(Havaintolista havaintolista, Tallennussijaintipalkki tspalkki) {
        ylarivi = new HavaintolistaYlarivi(this, tspalkki);
        lista = havaintolista;
        
        luoYlapaneeli();
        luoListapaneeli();
        
    }
    
    private void luoYlapaneeli() {
        JPanel ylapaneeli = new JPanel( new GridLayout(2,1) );
        
        ylapaneeli.add(new Havaintolistaotsikko(lista.getHavaintoja()));
        ylapaneeli.add(ylarivi);
        
        add(ylapaneeli, BorderLayout.NORTH);
    }
    
    private void luoListapaneeli() {
        listapaneeli = new ScrollattavaLista(lista);
        add(listapaneeli, BorderLayout.CENTER);
    }
    
    public void lisaa(Havainto havainto) {
        lista.lisaa(havainto);
        paivita();
    }
    
   public Havaintolista getLista() {
       return lista;
   }
    
    public void poistaValitut() {
        lista.poistaValitut();
        paivita();
    }
    
    public void vaihdaJarjestamisperuste(int peruste) {
        lista.vaihdaJarjestamisperuste(peruste);
        paivita();
    }

    public void tallenna() {
        new Tallentaja("/Users/anterova/Desktop/save1.txt", lista).tallenna();
        paivita();
    }
    
    public void lataa() {
        new Lataaja("/Users/anterova/Desktop/save1.txt", lista).lataa();
        paivita();
    }
    
    @Override
    public void paivita() {
        removeAll();
        
        luoYlapaneeli();
        luoListapaneeli();
        
        repaint();
    }
    
}
