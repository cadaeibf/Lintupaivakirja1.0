package lipvk.gui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.TreeSet;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import lipvk.ohlo.Lintulaji;
import lipvk.takut.napit.VaihdaNakyma;
import lipvk.takut.napit.ValitseLintu;
import lipvk.util.TekstinFormatointi;

/**
 * GUI-luokka käsiteltävän lintukirjaston ja siihen liittyvien havaintojen 
 * esittämiseen.
 * @author anterova
 */
public class Lajilistapaneeli extends JPanel {
    private Listanakyma nakyma;
    
    public enum Listanakyma {
        VIIMEINEN_HAVAINTO, VIIMEISET_VIISI_VUOTTA
    }

    public Lajilistapaneeli(Kayttoliittyma kali) {
        super( new BorderLayout() );
        
        nakyma = Listanakyma.VIIMEISET_VIISI_VUOTTA;
        
        luoKomponentit(kali);
    }
    
    private void luoKomponentit(Kayttoliittyma kali) {
        JPanel ylapaneeli = new JPanel( new GridLayout(2,1) );
        
        ylapaneeli.add( nakymatPaneeli(kali) );
        ylapaneeli.add( ylarivi() );
        add( new JScrollPane( lajiLista(kali), 
                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, 
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ), 
                BorderLayout.CENTER );
        add( ylapaneeli, BorderLayout.NORTH);
    }
    
    private JPanel nakymatPaneeli(Kayttoliittyma kali) {
        JPanel paneeli = new JPanel(  );
        BoxLayout layout = new BoxLayout(paneeli, BoxLayout.X_AXIS);
        paneeli.setLayout(layout);
        
        JRadioButton vhsp = new JRadioButton( "Viimeinen havainto" );
        JRadioButton vvvhsp = new JRadioButton( "Viimeiset 5 vuotta" );
        
        switch(nakyma) {
            case VIIMEINEN_HAVAINTO: 
                vhsp.setSelected(true);
                break;
            case VIIMEISET_VIISI_VUOTTA: 
                vvvhsp.setSelected(true);
                break;
        }
        
        vhsp.addActionListener( new VaihdaNakyma( Listanakyma.VIIMEINEN_HAVAINTO, this, kali ) );
        vvvhsp.addActionListener( new VaihdaNakyma( Listanakyma.VIIMEISET_VIISI_VUOTTA, this, kali ) );
        
        ButtonGroup bg = new ButtonGroup();
        
        bg.add( vhsp );
        bg.add( vvvhsp );
        
        paneeli.add( new JLabel("Näytä:") );
        paneeli.add(vhsp);
        paneeli.add( vvvhsp );
        
        return paneeli;
    }
    
    private JPanel ylarivi( ) {
        JPanel ylarivi = new JPanel( new GridLayout( 1, 7 ) );
        
        switch(nakyma) {
            case VIIMEINEN_HAVAINTO:
                ylarivi.add( new JLabel("Valitse") );
                ylarivi.add( new JLabel("Laji") );
                ylarivi.add( new JLabel("Viim. havainto") );
                ylarivi.add( new JLabel("Havaintopaikka") );
                ylarivi.add( new JLabel("Lkm") );
                break;
            case VIIMEISET_VIISI_VUOTTA:
                int vuosi = Calendar.getInstance().get( Calendar.YEAR );

                ylarivi.add( new JLabel("Valitse") );
                ylarivi.add( new JLabel("Laji") );
                ylarivi.add( new JLabel( (vuosi - 4) + "" ) );
                ylarivi.add( new JLabel( (vuosi - 3) + "" ) );
                ylarivi.add( new JLabel( (vuosi - 2) + "" ) );
                ylarivi.add( new JLabel( (vuosi - 1) + "" ) );
                ylarivi.add( new JLabel( vuosi + "") );
                break;
        }
        return ylarivi;
    }
    
    private JPanel lajiLista(Kayttoliittyma kali) {
        TreeSet<Lintulaji> lintulista = kali.getLintulista().getLista();
        if(lintulista.isEmpty()) return new JPanel();
        
        int riveja = lintulista.size();
        if( riveja < 25) riveja = 25;
        JPanel lajilista = new JPanel ( new GridLayout( riveja, 1 ) );
        
        ButtonGroup bg = new ButtonGroup();
        
        for (Lintulaji laji : lintulista) {
            lajilista.add( lajiRivi(laji, kali, bg) );
        }
        return lajilista;
    }
    
    private JPanel lajiRivi(Lintulaji laji, Kayttoliittyma kali, ButtonGroup bg) {
        JPanel rivi = new JPanel( new GridLayout( 1, 7 ) );
        
        JRadioButton valitse = new JRadioButton();
        valitse.addActionListener( new ValitseLintu(valitse, kali, laji) );
        bg.add(valitse);
        
        rivi.add(valitse);
        rivi.add( new JLabel( TekstinFormatointi.isoAlkukirjain(laji.getNimi()) ) );
        
        switch(nakyma) {
            case VIIMEINEN_HAVAINTO:
                rivi.add( new JLabel( laji.viimeinenHavaintoPvm() ) );
                rivi.add( new JLabel( TekstinFormatointi.isoAlkukirjain( laji.viimeinenHavaintoPaikka() ) ) );
                rivi.add( new JLabel( laji.viimeinenHavaintoLkm() ) );
                break;
            case VIIMEISET_VIISI_VUOTTA:
                for (int i = 4; i >= 0; i--) {
                    rivi.add( new JLabel( laji.havaintojaVuonna( Calendar.getInstance().get( Calendar.YEAR ) - i ) ) );
                }
                break;
        }
        
        return rivi;
    }
    
    public void vaihdaNakyma(Listanakyma nakyma, Kayttoliittyma kali) {
        this.nakyma = nakyma;
        paivita(kali);
    }
    
    public void paivita(Kayttoliittyma kali) {
        removeAll();
        
        luoKomponentit(kali);
        
        validate();
        repaint();
    }
}
