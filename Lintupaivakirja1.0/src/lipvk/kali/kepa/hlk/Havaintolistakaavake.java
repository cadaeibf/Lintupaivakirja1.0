/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.hlk;

import lipvk.kali.kepa.vasen.Tallennussijaintipalkki;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import lipvk.kali.Kayttoliittyma;
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
    private Havaintolista lista;
    private Tallennussijaintipalkki tspalkki;
    private JLabel havaintojasarake;
    private Kayttoliittyma kali;
    

    public Havaintolistakaavake(Kayttoliittyma kali, Havaintolista havaintolista, Tallennussijaintipalkki tspalkki) {
        super();
        
        lista = havaintolista;
        this.kali = kali;
        this.tspalkki = tspalkki;
        
        luoKomponentit();
    }

    private void luoKomponentit() {
        setLayout( new BorderLayout() );
        
        luoYlapaneeli();
        luoScrolleri();
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
    
    private void luoScrolleri() {
        JPanel listapaneeli = skannaaLista();
        
        scrolleri = new JScrollPane(listapaneeli);
        scrolleri.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        scrolleri.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        
        add(scrolleri, BorderLayout.CENTER);
    }
    
    private JPanel skannaaLista() {
        JPanel listapaneeli = new JPanel ( new GridLayout( lista.getHavaintoja(), 1 ) );
        
        for (int i = 0; i < lista.getHavaintoja(); i++) {
            listapaneeli.add( new Havaintopalkki( lista.get(i)) );
        }
        
        return listapaneeli;
    }
    
    private void paivitaLista() {
        remove(scrolleri);
        
        luoScrolleri();
    }
    
    public void lisaa(Havainto havainto) {
        lista.lisaa(havainto);
        tspalkki.muutoksiaTehty();
        paivita();
    }
    
    public void poistaValitut() {
        lista.poistaValitut();
        tspalkki.muutoksiaTehty();
        kali.paivita();
    }
    
    public void jarjesta(int peruste) {
        lista.vaihdaJarjestamisperuste(peruste);
        lista.jarjesta();
        
        kali.paivita();
    }

    public void tallenna() {
        new Tallentaja("/Users/anterova/Desktop/save1.txt", lista).tallenna();
        tspalkki.tiedostoTallennettu();
        kali.paivita();
    }
    
    public void lataa() {
        new Lataaja("/Users/anterova/Desktop/save1.txt", lista).lataa();
        tspalkki.tiedostoLadattu();
        kali.paivita();
    }
    
    @Override
    public void paivita() {
        paivitaHavaintoja();
        paivitaLista();
    }
    
}
