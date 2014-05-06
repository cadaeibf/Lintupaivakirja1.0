package lipvk.gui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import lipvk.main.Kayttoliittyma;

/**
 * GUI-luokka käsiteltävän lintukirjaton ja siihen liittyvien havaintojen 
 * esittämiseen.
 * @author anterova
 */
public class Havaintolistakaavake extends JPanel {
    
    public enum Listanakyma {
        VIIMEINEN_HAVAINTO, VIIMEISET_VIISI_VUOTTA
    }
    
    public Havaintolistakaavake(Kayttoliittyma kali) {
        super( new BorderLayout() );
        
        luoKomponentit( kali, Listanakyma.VIIMEISET_VIISI_VUOTTA );
    }
    
    public Havaintolistakaavake(Kayttoliittyma kali, Listanakyma nakyma) {
        super( new BorderLayout() );
        
        luoKomponentit( kali, nakyma );
    }

    private void luoKomponentit( Kayttoliittyma kali, Listanakyma nakyma ) {
        JPanel ylapaneeli = HlkPaneelit.ylapaneeli(kali, nakyma);
        JScrollPane listaScrolleri = HlkPaneelit.listaScrolleri(kali.getLintulista(), nakyma);
        
        add(ylapaneeli, BorderLayout.NORTH);
        add(listaScrolleri, BorderLayout.CENTER);
        
    }
}
