/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.kali.kepa.hlk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import lipvk.kali.kepa.vasen.VasenLohko;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;
import lipvk.ohlo.xml.KirjoitaXML;
import lipvk.ohlo.xml.LueXML;
import lipvk.rajapinnat.Paivitettava;
import lipvk.takut.napit.VaihdaNakyma;
import lipvk.takut.napit.ValitseLintu;

/**
 *
 * @author anterova
 */
public class Havaintolistakaavake extends JPanel implements Paivitettava {
    private JLabel havaintojasarake;
    private VasenLohko vl;
    private Lintulista lista;
    private int nakyma;
    

    public Havaintolistakaavake(VasenLohko vl) {
        super( new BorderLayout() );
        
        this.vl = vl;
        lista = new Lintulista();
        
        luoKomponentit( nakyma );
    }

    private void luoKomponentit( int nakyma ) {
        luoYlapaneeli( nakyma );
        lisaaScrolleri( nakyma );
    }
    
    private void luoYlapaneeli(int nakyma) {
        JPanel ylapaneeli = new JPanel( new GridLayout(3,1) );
        
        ylapaneeli.add( luoOtsikko() );
        ylapaneeli.add( nakymatPaneeli(nakyma) );
        ylapaneeli.add( luoYlarivi( nakyma ) );
        
        paivitaHavaintoja();
        
        add(ylapaneeli, BorderLayout.NORTH);
    }
    
    private JPanel luoOtsikko() {
        JPanel otsikko = new JPanel( new GridLayout( 1, 3 ) );
        havaintojasarake = new JLabel();
        
        otsikko.add(new JLabel(""));
        otsikko.add(new JLabel("HAVAINNOT YHTEENSÄ:"));
        otsikko.add( havaintojasarake );
        
        return otsikko;
    }
    
    private JPanel nakymatPaneeli(int nakyma) {
        JPanel paneeli = new JPanel(  );
        BoxLayout layout = new BoxLayout(paneeli, BoxLayout.X_AXIS);
        paneeli.setLayout(layout);
        
        JRadioButton vhsp = new JRadioButton( "Viimeinen havainto" );
        JRadioButton vvvhsp = new JRadioButton( "Viimeiset 5 vuotta" );
        
        if( nakyma == 0 ) vhsp.setSelected(true);
        else if( nakyma == 1 ) vvvhsp.setSelected(true);
        
        vhsp.addActionListener( new VaihdaNakyma(0, vhsp, this) );
        vvvhsp.addActionListener( new VaihdaNakyma(1, vvvhsp, this) );
        
        ButtonGroup bg = new ButtonGroup();
        
        bg.add( vhsp );
        bg.add( vvvhsp );
        
        paneeli.add( new JLabel("Näytä:") );
        paneeli.add(vhsp);
        paneeli.add( vvvhsp );
        
        return paneeli;
    }
    
    private JPanel luoYlarivi(int nakyma) {
        JPanel ylarivi = new JPanel( new GridLayout( 1, 7 ) );
        
        if(nakyma == 0) {
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
        
        if(nakyma == 1) {
            int vuosi = Calendar.getInstance().get( Calendar.YEAR );
            
            ylarivi.add( new JLabel("Valitse") );
            ylarivi.add( new JLabel("Laji") );
            ylarivi.add( new JLabel( (vuosi - 4) + "" ) );
            ylarivi.add( new JLabel( (vuosi - 3) + "" ) );
            ylarivi.add( new JLabel( (vuosi - 2) + "" ) );
            ylarivi.add( new JLabel( (vuosi - 1) + "" ) );
            ylarivi.add( new JLabel( vuosi + "") );
        }
        return ylarivi;
    }
    
    private void lisaaScrolleri(int nakyma) {
        JPanel listapaneeli = lajiLista(nakyma);
        
        JScrollPane scrolleri = new JScrollPane(listapaneeli);
        scrolleri.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        scrolleri.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        add(scrolleri, BorderLayout.CENTER);
    }
    
    private JPanel lajiLista(int nakyma) {
        int riveja = lista.koko();
        if( riveja < 25) riveja = 25;
        JPanel listapaneeli = new JPanel ( new GridLayout( riveja, 1 ) );
        ButtonGroup bg = new ButtonGroup();
        
        for (Lintulaji lintulaji : lista.getLista()) {
            if(nakyma == 0) listapaneeli.add( viimeinenHavaintoSarake(lintulaji, bg) );
            if(nakyma == 1) listapaneeli.add( viimViisiVuottaHavainnotSarake(lintulaji, bg) );
        }
        
        return listapaneeli;
    }
    
    private JPanel viimeinenHavaintoSarake(Lintulaji lintulaji, ButtonGroup bg) {
        JPanel sarake = new JPanel( new GridLayout(1, 7) );
        JRadioButton valitse = new JRadioButton();
        
        valitse.addActionListener( new ValitseLintu(lintulaji, vl, valitse) );
        
        bg.add(valitse);
        
        sarake.add( valitse );
        sarake.add(new JLabel( lintulaji.getNimi() ));
        sarake.add(new JLabel( lintulaji.viimeinenHavaintoPvm() ));
        sarake.add(new JLabel( lintulaji.viimeinenHavaintoPaikka() ));
        sarake.add(new JLabel( lintulaji.viimeinenHavaintoLkm() ));
        
        
        return sarake;
    }
    
    private JPanel viimViisiVuottaHavainnotSarake(Lintulaji lintulaji, ButtonGroup bg) {
        JPanel sarake = new JPanel(new GridLayout(1,7));
        JRadioButton valitse = new JRadioButton();
        
        valitse.addActionListener( new ValitseLintu(lintulaji, vl, valitse) );
        
        bg.add(valitse);
        
        sarake.add( valitse );
        sarake.add(new JLabel( lintulaji.getNimi() ));
        
        for (int i = 4; i >= 0; i--) {
            sarake.add( new JLabel( lintulaji.havaintojaVuonna( Calendar.getInstance().get( Calendar.YEAR ) - i ) ) );
        }
        
        return sarake;
    }
    
    private void paivitaHavaintoja() {
        havaintojasarake.setText( lista.getHavaintoja() + "" );
    }
    
    public void lisaaHavainto(String laji, Havainto havainto) {
        lista.lisaaHavainto(laji, havainto);
        vl.asetaIlmoitus("Muutoksia tehty");
        paivita();
    }
    
    public void tallenna(String tiedostonimi) {
        new KirjoitaXML().kirjoita(lista);
        vl.asetaIlmoitus("Tiedosto tallennettu");
    }
    
    public void lataa(String tiedostonimi) {
        try {
            lista = new LueXML().lue();
            vl.asetaIlmoitus("Tiedosto ladattu");
            paivita();
        } catch(Exception ex) {
            if( ex.getClass() == FileNotFoundException.class ) vl.asetaIlmoitus("Annettua tiedostoa ei löytynyt");
            if( ex.getClass() == IOException.class ) vl.asetaIlmoitus("Virhe latauksessa");
        }
    }
    
    public void vaihdaNakyma(int nakyma) {
        this.nakyma = nakyma;
        paivita();
    }
    
    @Override
    public void paivita() {
        removeAll();
        
        luoKomponentit(nakyma);
        
        repaint();
        revalidate();
    }
    
}
