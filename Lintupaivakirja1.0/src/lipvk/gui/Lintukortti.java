/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import lipvk.ohlo.Havainto;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class Lintukortti extends JPanel {

    public Lintukortti(Lintulaji lintu) {
        super( new GridLayout(1,2) );
        
        luoKomponentit(lintu);
    }

    private void luoKomponentit(Lintulaji lintu) {
        add( lintufaktat(lintu) );
        add( havainnot(lintu) );
    }
    
    private JPanel lintufaktat(Lintulaji lintu) {
        JPanel lintufaktat = new JPanel( new GridLayout(10,1) );
        
        lintufaktat.add( kentta( "Laji:", lintu.getNimi()) );
        lintufaktat.add( kentta( "Havaintoja:", lintu.getHavaintoja() + "" ) );
        
        return lintufaktat;
    }
    
    private JPanel kentta(String nimi, String tiedot) {
        JPanel nimikentta = new JPanel( new GridLayout(1,2) );
        
        nimikentta.add( new JLabel(nimi) );
        nimikentta.add( new JLabel(tiedot) );
        
        return nimikentta;
    }
    
    private JPanel havainnot( Lintulaji laji ) {
        JPanel havaintokortti = new JPanel( new BorderLayout() );
        
        JPanel ylasarake = new JPanel(new GridLayout(2,1));
        
        GridLayout kolmisarakkeinenrivi = new GridLayout(1,3);
        
        JPanel otsikko = new JPanel( kolmisarakkeinenrivi );
        JPanel ylarivi = new JPanel( kolmisarakkeinenrivi );
        
        otsikko.add(new JLabel());
        otsikko.add(new JLabel("HAVAINNOT:"));
        otsikko.add(new JLabel());
        
        ylarivi.add( new JLabel("Pvm") );
        ylarivi.add( new JLabel("Paikka") );
        ylarivi.add( new JLabel("Lkm") );
        
        ylasarake.add( otsikko );
        ylasarake.add( ylarivi );
        
        int riveja = laji.getHavaintoja();
        if(riveja < 14) riveja = 14;
        JPanel havainnot = new JPanel( new GridLayout(riveja, 1) );
        
        JPanel havaintosarake;
        
        for (Havainto havainto : laji.getHavainnot()) {
             havaintosarake = new JPanel(kolmisarakkeinenrivi);
            
            havaintosarake.add( new JLabel( havainto.formatoiPvm() ) );
            havaintosarake.add( new JLabel( havainto.getPaikka().toString() ) );
            havaintosarake.add( new JLabel( havainto.getLkm() + "" ) );
            
            havainnot.add(havaintosarake);
        }
        
        JScrollPane scroller = new JScrollPane(havainnot);
        
        havaintokortti.add(ylasarake, BorderLayout.NORTH);
        havaintokortti.add(scroller, BorderLayout.CENTER);
        
        return havaintokortti;
    }
    
    
    
    
}
