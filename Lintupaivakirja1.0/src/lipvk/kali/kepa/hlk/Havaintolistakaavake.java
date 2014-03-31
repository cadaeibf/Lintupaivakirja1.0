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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
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
    private JScrollPane scrolleri;
    private Tallennussijaintipalkki tspalkki;
    private JLabel havaintojasarake;
    private Havaintolista lista;
    private String tallennussijainti;
    

    public Havaintolistakaavake(Havaintolista havaintolista, Tallennussijaintipalkki tspalkki) {
        super( new BorderLayout() );
        
        tallennussijainti = "/Users/anterova/Desktop/";
        lista = havaintolista;
        this.tspalkki = tspalkki;
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        
        luoYlapaneeli();
        lisaaScrolleri();
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
    
    private void paivitaHavaintoja() {
        havaintojasarake.setText( lista.getHavaintoja() + "" );
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
    
    private void lisaaScrolleri() {
        JPanel listapaneeli = skannaaLista();
        System.out.println("Lista skannattu");
        
        scrolleri = new JScrollPane(listapaneeli);
        scrolleri.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        scrolleri.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        add(scrolleri, BorderLayout.CENTER);
    }
    
    private JPanel skannaaLista() {
        int riveja = lista.getHavaintoja();
        if( riveja < 24) riveja = 24;
        JPanel listapaneeli = new JPanel ( new GridLayout( riveja, 1 ) );
        
        for (int i = 0; i < lista.getHavaintoja(); i++) {
            System.out.println("Lisätään lintu " + lista.get(i).getLaji().toString() );
            listapaneeli.add( new Havaintopalkki( lista.get(i)) );
        }
        
        return listapaneeli;
    }
    
    public void lisaa(Havainto havainto) {
        lista.lisaa(havainto);
        tspalkki.muutoksiaTehty();
        paivita();
    }
    
    public void poistaValitut() {
        if( lista.poistaValitut() ) tspalkki.muutoksiaTehty();
        paivita();
    }
    
    public void jarjesta(int peruste) {
        lista.asetaJarjestamisperuste(peruste);
        lista.jarjesta();
        paivita();
    }

    public void tallenna(String tiedostonimi) {
        new Tallentaja(tallennussijainti + tiedostonimi, lista).tallenna();
        tspalkki.tiedostoTallennettu();
        paivita();
    }
    
    public void lataa(String tiedostonimi) {
        if( new Lataaja(tallennussijainti + tiedostonimi, lista).lataa() ) {
            tspalkki.tiedostoLadattu();
            paivita();
        } else {
            tspalkki.tiedostoaEiLoydy();
        }
    }
    
    @Override
    public void paivita() {
        System.out.println("päivitetään havaintolistakaavake...");
        
        removeAll();
        
        luoKomponentit();
        
        repaint();
        revalidate();
        
        System.out.println("Havaintolistakaavake päivitetty");
    }
    
}
