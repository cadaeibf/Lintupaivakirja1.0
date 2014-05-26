/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.pics;

import lipvk.pics.takut.HyvaksyKuva;
import lipvk.pics.takut.ValitseKuva;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lipvk.gui.Kayttoliittyma;
import lipvk.util.TekstinFormatointi;

/**
 *
 * @author anterova
 */
public class LisaaKuvaKaavake implements Runnable {
    private JFrame frame;
    private String laji;
    private Kayttoliittyma kali;
    private File valinta;
    
    private final int x = 500; 
    
   public LisaaKuvaKaavake(String laji, Kayttoliittyma kali) {
       this.laji = laji;
       this.kali = kali;
       this.valinta = null;
   }

    @Override
    public void run() {
        frame = new JFrame("Lisää Kuva");
        
        Dimension ruudunKoko = kali.getKoko();
        int x = ( ruudunKoko.width - this.x ) / 2;
        int y = ( ruudunKoko.height - this.x ) / 2;
        frame.setSize( new Dimension( this.x, this.x ) );
        
        luoKomponentit(frame.getContentPane());
        
        
        frame.setLocation( new Point(x, y) );
        
        frame.setResizable(false);
        frame.setVisible(true);
        
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout( new BorderLayout() );
        
        container.add( new Kuvapaneeli( valinta, x, x ), BorderLayout.CENTER );
        container.add( painikekentta(), BorderLayout.SOUTH );
    }
    
    private JPanel painikekentta() {
        JPanel painikekentta = new JPanel( new GridLayout(2, 2) );
        
        JButton valitseKuva = new JButton("Valitse kuva");
        valitseKuva.addActionListener( new ValitseKuva(this) );
        
        JButton hyvaksy = new JButton("Hyväksy");
        hyvaksy.addActionListener( new HyvaksyKuva(this) );
        
        painikekentta.add( new JLabel("Laji:") );
        painikekentta.add( new JLabel( laji ) );
        painikekentta.add( valitseKuva );
        painikekentta.add( hyvaksy );
        
        return painikekentta;
    }
    
    public void paivita( File valinta ) {
        if( !valinta.getName().endsWith(".jpg") && !valinta.getName().endsWith(".png") ) return;
        this.valinta = valinta;
        Container container = frame.getContentPane();
        
        container.removeAll();
        
        container.add( new Kuvapaneeli(valinta, x, x), BorderLayout.CENTER );
        container.add( painikekentta(), BorderLayout.SOUTH );
        
        container.validate();
        container.repaint();
    }
    
    public void hyvaksy() {
        if(valinta == null) return;
        
        try {
            BufferedImage im = ImageIO.read(valinta);
            File output = new File("kirjasto/kuvat/" + TekstinFormatointi.tiedostonimeksi( laji ) + ".jpg");
            ImageIO.write(im, "jpg", output);
            kali.lisaaKuva(laji, output);
        } catch(Exception ex) {
            System.out.println("virhe");
            return;
        }
        frame.dispose();
    }
    
}
