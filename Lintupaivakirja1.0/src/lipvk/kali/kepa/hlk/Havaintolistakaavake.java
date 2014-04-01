/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.hlk;

import lipvk.kali.kepa.vasen.Tallennussijaintipalkki;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;
import lipvk.ohlo.save.Lataaja;
import lipvk.ohlo.save.Tallentaja;
import lipvk.rajapinnat.Paivitettava;

/**
 *
 * @author anterova
 */
public class Havaintolistakaavake extends JPanel implements Paivitettava {
    private JScrollPane scrolleri;
    private Tallennussijaintipalkki tspalkki;
    private JLabel havaintojasarake;
    private Lintulista lista;
    

    public Havaintolistakaavake(Tallennussijaintipalkki tspalkki) {
        super( new BorderLayout() );
        
        lista = new Lintulista();
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
        
        JLabel valitse = new JLabel("Valitse");
        JLabel laji = new JLabel("Laji");
        JLabel edHavainto = new JLabel("Viim. havainto");
        JLabel paikka = new JLabel("");
        JLabel lkm = new JLabel("");
        
        ylarivi.add( valitse );
        ylarivi.add( laji );
        ylarivi.add( edHavainto );
        ylarivi.add( paikka );
        ylarivi.add( lkm );
        
        return ylarivi;
    }
    
    private void lisaaScrolleri() {
        JPanel listapaneeli = skannaaLista();
        
        scrolleri = new JScrollPane(listapaneeli);
        scrolleri.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        scrolleri.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        add(scrolleri, BorderLayout.CENTER);
    }
    
    private JPanel skannaaLista() {
        int riveja = lista.koko();
        if( riveja < 26) riveja = 26;
        JPanel listapaneeli = new JPanel ( new GridLayout( riveja, 1 ) );
        
        for (Lintulaji lintulaji : lista.getLista()) {
            listapaneeli.add( lintulajiSarake(lintulaji) );
        }
        
        return listapaneeli;
    }
    
    private JPanel lintulajiSarake(Lintulaji lintulaji) {
        JPanel sarake = new JPanel( new GridLayout(1, 5) );
        
        sarake.add(new JRadioButton());
        sarake.add(new JLabel( lintulaji.getNimi() ));
        sarake.add(new JLabel( lintulaji.viimeinenHavaintoPvm() ));
        sarake.add(new JLabel( lintulaji.viimeinenHavaintoPaikka() ));
        sarake.add(new JLabel( lintulaji.viimeinenHavaintoLkm() ));
        
        
        return sarake;
    }
    
    public void lisaaHavainto(String laji, Havainto havainto) {
        lista.lisaaHavainto(laji, havainto);
        tspalkki.muutoksiaTehty();
        paivita();
    }
    
    public void tallenna(String tiedostonimi) {
        new Tallentaja().tallenna( tiedostonimi, lista);
        tspalkki.tiedostoTallennettu();
    }
    
    public void lataa(String tiedostonimi) {
        try {
            lista = new Lataaja().lataa( tiedostonimi );
            tspalkki.tiedostoLadattu();
            paivita();
        } catch(Exception ex) {
            if( ex.getClass() == FileNotFoundException.class ) tspalkki.tiedostoaEiLoydy();
            if( ex.getClass() == IOException.class ) tspalkki.virheLatauksessa();
        }
    }
    
    @Override
    public void paivita() {
        removeAll();
        
        luoKomponentit();
        
        repaint();
        revalidate();
    }
    
}
