/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.hlk;

import lipvk.kali.kepa.vasen.Tallennussijaintipalkki;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Havaintolista;
import lipvk.ohlo.save.Lataaja;
import lipvk.ohlo.save.Tallentaja;
import lipvk.rajapinnat.Paivitettava;
import lipvk.takut.Jarjestaja;
import lipvk.takut.napit.PoistaValitut;

/**
 *
 * @author anterova
 */
public class Havaintolistakaavake extends JPanel implements Paivitettava {
    private Havaintolista lista;
    private Tallennussijaintipalkki tspalkki;
    private JLabel havaintojasarake;

    public Havaintolistakaavake(Havaintolista havaintolista, Tallennussijaintipalkki tspalkki) {
        super(new BorderLayout());
        this.tspalkki = tspalkki;
        
        luoKomponentit(havaintolista);
    }

    private void luoKomponentit(Havaintolista havaintolista) {
        lista = havaintolista;
        
        luoYlapaneeli();
        luoListapaneeli();
    }
    
    private void luoYlapaneeli() {
        JPanel ylapaneeli = new JPanel( new GridLayout(2,1) );
        
        ylapaneeli.add( luoOtsikko() );
        ylapaneeli.add( luoYlarivi() );
        
        paivitaHavaintoja();
        
        add(ylapaneeli, BorderLayout.NORTH);
    }
    
    private JPanel luoOtsikko() {
        JPanel otsikko = new JPanel( new GridLayout( 1, 3 ) );
        havaintojasarake = new JLabel();
        
        otsikko.add(new JLabel(""));
        otsikko.add(new JLabel("HAVAINNOT:"));
        otsikko.add( havaintojasarake );
        
        return otsikko;
    }
    
    private JPanel luoYlarivi() {
        JPanel ylarivi = new JPanel( new GridLayout( 1, 5 ) );
        
        JButton poistaValitut = new JButton("Poista");
        JButton jarjestaLaji = new JButton("Laji");
        JButton jarjestaPvm = new JButton("Pvm");
        JButton jarjestaPaikka = new JButton("Paikka");
        JButton jarjestaLkm = new JButton("Lkm");
        
        
        poistaValitut.addActionListener( new PoistaValitut(this) );
        jarjestaLaji.addActionListener( new Jarjestaja(this, 0) );
        jarjestaPvm.addActionListener( new Jarjestaja(this, 1) );
        jarjestaPaikka.addActionListener( new Jarjestaja( this, 2 ) );
        jarjestaLkm.addActionListener( new Jarjestaja( this, 3 ) );
        
        ylarivi.add( poistaValitut );
        ylarivi.add( jarjestaLaji );
        ylarivi.add( jarjestaPvm );
        ylarivi.add( jarjestaPaikka );
        ylarivi.add( jarjestaLkm );
        
        return ylarivi;
    }
    
    private void luoListapaneeli() {
        add(new ScrollattavaLista(lista), BorderLayout.CENTER);
    }
    
    private void paivitaHavaintoja() {
        havaintojasarake.setText( lista.getHavaintoja() + "" );
    }
    
    public void lisaa(Havainto havainto) {
        lista.lisaa(havainto);
        tspalkki.muutoksiaTehty();
        paivita();
    }
    
    public void poistaValitut() {
        lista.poistaValitut();
        tspalkki.muutoksiaTehty();
        paivita();
    }
    
    public void jarjesta(int peruste) {
        lista.vaihdaJarjestamisperuste(peruste);
        lista.jarjesta();
        
        paivita();
    }

    public void tallenna() {
        new Tallentaja("/Users/anterova/Desktop/save1.txt", lista).tallenna();
        tspalkki.tiedostoTallennettu();
        paivita();
    }
    
    public void lataa() {
        new Lataaja("/Users/anterova/Desktop/save1.txt", lista).lataa();
        tspalkki.tiedostoLadattu();
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
