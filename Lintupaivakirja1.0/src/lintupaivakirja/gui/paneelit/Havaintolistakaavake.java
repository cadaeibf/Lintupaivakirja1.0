/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.gui.paneelit;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
    private Havaintolista lista;
    private Havaintolistaotsikko otsikko;
    private JFrame frame;

    public Havaintolistakaavake(JFrame frame, Havaintolista havaintolista) {
        super(new GridLayout(20,1));
        
        luoKomponentit(frame, havaintolista);
    }

    private void luoKomponentit(JFrame frame, Havaintolista havaintolista) {
        this.frame = frame;
        lista = havaintolista;
        ylarivi = new HavaintolistaYlarivi(this);
        
        add(new Havaintolistaotsikko(lista.getHavaintoja()));
        add(ylarivi);
        
        
        lisaaHavainnot();
        
        
    }
    
    private void paivita() {
        removeAll();
        add(new Havaintolistaotsikko(lista.getHavaintoja()));
        add(ylarivi);
        
        lisaaHavainnot();
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
    
    private void lisaaHavainnot() {
        for (int i = 0; i < lista.getHavaintoja(); i++) {
            add(new Havaintopaneeli(lista.get(i)));
        }
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
