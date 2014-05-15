/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.pics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author anterova
 */
public class Kuvapaneeli extends JPanel {
    private BufferedImage image;
    private int leveys;
    private int korkeus;

    public Kuvapaneeli(File kuvatiedosto, int leveys, int korkeus) {
        super();
        this.leveys = leveys;
        this.korkeus = korkeus;
        
        luoKomponentit(kuvatiedosto);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(image != null) {
            float s = muuntosuhde(image.getWidth(), image.getHeight(), leveys, korkeus);
            int kuvanLeveys = (int) ( s*image.getWidth() );
            int kuvanKorkeus = (int) ( s*image.getHeight() );
            
            g.drawImage(image, (leveys - kuvanLeveys) / 2, 0, kuvanLeveys, kuvanKorkeus, null);
        } else add( new JLabel("kuvatiedostoa ei löytynyt") );
    }

    private void luoKomponentit(File kuvatiedosto) {
        try {
            image = ImageIO.read(kuvatiedosto);
        } catch(Exception ex) {
            image = null;
        }
    }
    
    private float muuntosuhde(int xAlku, int yAlku, int xLoppu, int yLoppu) {
        float s = (float) xLoppu / (float) xAlku;
        float t;
        if( (t = (float) yLoppu / (float) yAlku ) < s ) s = t;
        return s;
    }
    
}
