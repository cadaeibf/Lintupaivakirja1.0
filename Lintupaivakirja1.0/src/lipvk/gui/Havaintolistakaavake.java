package lipvk.gui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import lipvk.ohlo.Lintulaji;
import lipvk.ohlo.Lintulista;
import lipvk.takut.napit.VaihdaNakyma;
import lipvk.takut.napit.ValitseLintu;

/**
 *
 * @author anterova
 */
public class Havaintolistakaavake extends JPanel {
    private JLabel havaintojasarake;
    private int nakyma;
    

    public Havaintolistakaavake(Lintulista lintulista) {
        super( new BorderLayout() );
        
        luoKomponentit( lintulista, nakyma );
    }

    private void luoKomponentit( Lintulista lintulista, int nakyma ) {
        luoYlapaneeli( nakyma );
        lisaaScrolleri( lintulista, nakyma );
    }
    
    private void luoYlapaneeli(int nakyma) {
        JPanel ylapaneeli = new JPanel( new GridLayout(3,1) );
        
        ylapaneeli.add( luoOtsikko() );
        ylapaneeli.add( nakymatPaneeli(nakyma) );
        ylapaneeli.add( luoYlarivi( nakyma ) );
        
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
        
        // vhsp.addActionListener( new VaihdaNakyma(0, vhsp, kali) );
        // vvvhsp.addActionListener( new VaihdaNakyma(1, vvvhsp, kali) );
        
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
    
    private void lisaaScrolleri(Lintulista lintulista, int nakyma) {
        JPanel listapaneeli = lajiLista(lintulista, nakyma);
        
        JScrollPane scrolleri = new JScrollPane(listapaneeli);
        scrolleri.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        scrolleri.setVerticalScrollBarPolicy( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        add(scrolleri, BorderLayout.CENTER);
    }
    
    private JPanel lajiLista(Lintulista lintulista, int nakyma) {
        int riveja = lintulista.koko();
        if( riveja < 25) riveja = 25;
        JPanel listapaneeli = new JPanel ( new GridLayout( riveja, 1 ) );
        ButtonGroup bg = new ButtonGroup();
        
        for (Lintulaji lintulaji : lintulista.getLista()) {
            if(nakyma == 0) listapaneeli.add( viimeinenHavaintoSarake(lintulaji, bg) );
            if(nakyma == 1) listapaneeli.add( viimViisiVuottaHavainnotSarake(lintulaji, bg) );
        }
        
        return listapaneeli;
    }
    
    private JPanel viimeinenHavaintoSarake(Lintulaji lintulaji, ButtonGroup bg) {
        JPanel sarake = new JPanel( new GridLayout(1, 7) );
        JRadioButton valitse = new JRadioButton();
        
        valitse.addActionListener( new ValitseLintu(lintulaji, valitse) );
        
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
        
        valitse.addActionListener( new ValitseLintu(lintulaji, valitse) );
        
        bg.add(valitse);
        
        sarake.add( valitse );
        sarake.add(new JLabel( lintulaji.getNimi() ));
        
        for (int i = 4; i >= 0; i--) {
            sarake.add( new JLabel( lintulaji.havaintojaVuonna( Calendar.getInstance().get( Calendar.YEAR ) - i ) ) );
        }
        
        return sarake;
    }
    
    public void paivitaLintulista(Lintulista lintulista) {
        removeAll();
        
        luoKomponentit(lintulista, nakyma);
        
        repaint();
        revalidate();
    }
    
}
