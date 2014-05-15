/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.pics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lipvk.gui.Kayttoliittyma;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class LisaaKuvaKaavake implements Runnable {
    private JFrame frame;
    private Lintulaji laji;
    private Kayttoliittyma kali;
    private File valinta;
    
   public LisaaKuvaKaavake(Lintulaji laji, Kayttoliittyma kali) {
       this.laji = laji;
       this.kali = kali;
       this.valinta = null;
   }

    @Override
    public void run() {
        frame = new JFrame("Lisää Kuva");
        
        Dimension kaavakkeenKoko = new Dimension( 500, 500 );
        Dimension ruudunKoko = new Dimension( Toolkit.getDefaultToolkit().getScreenSize() );
        int x = ( ruudunKoko.width - kaavakkeenKoko.width ) / 2;
        int y = ( ruudunKoko.height - kaavakkeenKoko.height ) / 2;
        frame.setSize(kaavakkeenKoko);
        
        luoKomponentit(frame.getContentPane());
        
        
        frame.setLocation( new Point(x, y) );
        
        frame.setResizable(false);
        frame.setVisible(true);
        
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout( new BorderLayout() );
        
        container.add( new Kuvapaneeli( valinta, 400, 600 ), BorderLayout.CENTER );
        container.add( painikekentta(), BorderLayout.SOUTH );
    }
    
    private JPanel painikekentta() {
        JPanel painikekentta = new JPanel( new GridLayout(2, 2) );
        
        JButton valitseKuva = new JButton("Valitse kuva");
        valitseKuva.addActionListener( new ValitseKuva(this) );
        
        JButton hyvaksy = new JButton("Hyväksy");
        hyvaksy.addActionListener( new HyvaksyKuva(this) );
        
        painikekentta.add( new JLabel("Laji:") );
        painikekentta.add( new JLabel(laji.getNimi()) );
        painikekentta.add( valitseKuva );
        painikekentta.add( hyvaksy );
        
        return painikekentta;
    }
    
    public void paivita( File valinta ) {
        if( !valinta.getName().endsWith(".jpg") && !valinta.getName().endsWith(".png") ) return;
        this.valinta = valinta;
        Container container = frame.getContentPane();
        
        container.removeAll();
        
        container.add( new Kuvapaneeli(valinta, 400, 600), BorderLayout.CENTER );
        container.add( painikekentta(), BorderLayout.SOUTH );
        
        container.validate();
        container.repaint();
    }
    
    public void hyvaksy() {
        if(valinta == null) return;
        laji.lisaaKuvaTiedosto(valinta);
        kali.poistaLintukortti();
        kali.lisaaLintukortti(laji);
        frame.dispose();
    }
    
}
