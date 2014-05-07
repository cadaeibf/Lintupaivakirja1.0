/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import lipvk.gui.Havaintolistakaavake.Listanakyma;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;
import lipvk.takut.napit.VaihdaNakyma;
import lipvk.takut.napit.ValitseLintu;
import lipvk.util.TekstinFormatointi;

/**
 * Luokka määrittelee Havaintolistakaavakkeessa käytettävien paneelien 
 * näkymät.
 * @author anterova
 */
public class HlkPaneelit {
    
    public static JPanel ylapaneeli( Kayttoliittyma kali, Listanakyma nakyma ) {
        JPanel ylapaneeli = new JPanel( new GridLayout(2,1) );
        
        ylapaneeli.add( nakymatPaneeli(kali, nakyma) );
        ylapaneeli.add( ylarivi( nakyma ) );
        
        return ylapaneeli;
    }
    
    public static JScrollPane listaScrolleri( Kayttoliittyma kali, Listanakyma nakyma ) {
        JPanel listapaneeli = lajiLista(kali, nakyma);
        
        JScrollPane scrolleri = new JScrollPane(listapaneeli);
        scrolleri.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        scrolleri.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        
        return scrolleri;
    }
    
    private static JPanel nakymatPaneeli( Kayttoliittyma kali, Listanakyma nakyma ) {
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
        
        vhsp.addActionListener( new VaihdaNakyma( kali, Listanakyma.VIIMEINEN_HAVAINTO ) );
        vvvhsp.addActionListener( new VaihdaNakyma( kali, Listanakyma.VIIMEISET_VIISI_VUOTTA ) );
        
        ButtonGroup bg = new ButtonGroup();
        
        bg.add( vhsp );
        bg.add( vvvhsp );
        
        paneeli.add( new JLabel("Näytä:") );
        paneeli.add(vhsp);
        paneeli.add( vvvhsp );
        
        return paneeli;
    }
    
    private static JPanel ylarivi( Listanakyma nakyma ) {
        JPanel ylarivi = new JPanel( new GridLayout( 1, 7 ) );
        
        if(nakyma == Listanakyma.VIIMEINEN_HAVAINTO) {
            ylarivi.add( new JLabel("Valitse") );
            ylarivi.add( new JLabel("Laji") );
            ylarivi.add( new JLabel("Viim. havainto") );
            ylarivi.add( new JLabel("Havaintopaikka") );
            ylarivi.add( new JLabel("Lkm") );

            return ylarivi;
        }
        
        if(nakyma == Listanakyma.VIIMEISET_VIISI_VUOTTA) {
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
    
    private static JPanel lajiLista(Kayttoliittyma kali, Listanakyma nakyma) {
        Lintulista lintulista = kali.getLintulista();
        if(lintulista == null) return new JPanel();
        int riveja = lintulista.koko();
        if( riveja < 25) riveja = 25;
        JPanel listapaneeli = new JPanel ( new GridLayout( riveja, 1 ) );
        ButtonGroup bg = new ButtonGroup();
        
        for (Lintulaji lintulaji : lintulista.getLista()) {
            if(nakyma == Listanakyma.VIIMEINEN_HAVAINTO) listapaneeli.add( viimeinenHavaintoSarake(kali, lintulaji, bg) );
            if(nakyma == Listanakyma.VIIMEISET_VIISI_VUOTTA) listapaneeli.add( viimViisiVuottaHavainnotSarake(kali, lintulaji, bg) );
        }
        
        return listapaneeli;
    }
    
    private static JPanel viimeinenHavaintoSarake(Kayttoliittyma kali, Lintulaji lintulaji, ButtonGroup bg) {
        JPanel sarake = new JPanel( new GridLayout(1, 7) );
        JRadioButton valitse = new JRadioButton();
        
        valitse.addActionListener( new ValitseLintu(kali, valitse, lintulaji) );
        
        bg.add(valitse);
        
        sarake.add( valitse );
        sarake.add(new JLabel( TekstinFormatointi.isoAlkukirjain( lintulaji.getNimi() ) ));
        sarake.add(new JLabel( lintulaji.viimeinenHavaintoPvm() ));
        sarake.add(new JLabel( TekstinFormatointi.isoAlkukirjain( lintulaji.viimeinenHavaintoPaikka() ) ));
        sarake.add(new JLabel( lintulaji.viimeinenHavaintoLkm() ));
        
        
        return sarake;
    }
    
    private static JPanel viimViisiVuottaHavainnotSarake(Kayttoliittyma kali, Lintulaji lintulaji, ButtonGroup bg) {
        JPanel sarake = new JPanel(new GridLayout(1,7));
        JRadioButton valitse = new JRadioButton();
        
        valitse.addActionListener( new ValitseLintu(kali, valitse, lintulaji) );
        
        bg.add(valitse);
        
        sarake.add( valitse );
        sarake.add(new JLabel( TekstinFormatointi.isoAlkukirjain( lintulaji.getNimi() ) ));
        
        for (int i = 4; i >= 0; i--) {
            sarake.add( new JLabel( lintulaji.havaintojaVuonna( Calendar.getInstance().get( Calendar.YEAR ) - i ) ) );
        }
        
        return sarake;
    }
    
}
