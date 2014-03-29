/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.kali.keskuspaneeli.havaintolistakaavake;

import lintupaivakirja.kali.keskuspaneeli.vasenlohko.Tallennussijaintipalkki;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import lintupaivakirja.kali.keskuspaneeli.HavaintolistaYlarivi;
import lintupaivakirja.kali.keskuspaneeli.Havaintolistaotsikko;
import lintupaivakirja.kali.keskuspaneeli.ScrollattavaLista;
import lintupaivakirja.ohjelmalogiikka.Havainto;
import lintupaivakirja.ohjelmalogiikka.Havaintolista;
import lintupaivakirja.ohjelmalogiikka.tallennus.Lataaja;
import lintupaivakirja.ohjelmalogiikka.tallennus.Tallentaja;

/**
 *
 * @author anterova
 */
public class Havaintolistakaavake extends JPanel {
    private HavaintolistaYlarivi ylarivi;
    private ScrollattavaLista listapaneeli;
    private Havaintolista lista;
    private JFrame frame;

    public Havaintolistakaavake(JFrame frame, Havaintolista havaintolista, Tallennussijaintipalkki tspalkki) {
        super(new BorderLayout());
        
        luoKomponentit(frame, havaintolista, tspalkki);
    }

    private void luoKomponentit(JFrame frame, Havaintolista havaintolista, Tallennussijaintipalkki tspalkki) {
        ylarivi = new HavaintolistaYlarivi(this, tspalkki);
        lista = havaintolista;
        this.frame = frame;
        
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
    
    private void paivita() {
        removeAll();
        
        luoYlapaneeli();
        luoListapaneeli();
        
        repaint();
        
        frame.repaint();
        frame.pack();
        frame.setVisible(true);
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
    
}
