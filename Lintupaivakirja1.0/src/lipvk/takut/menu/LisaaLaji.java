/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import lipvk.gui.KaliPaneelit;
import lipvk.gui.Kayttoliittyma;

/**
 *
 * @author anterova
 */
public class LisaaLaji implements ActionListener {
    private Kayttoliittyma kali;

    public LisaaLaji(Kayttoliittyma kali) {
        this.kali = kali;
    }
    
    private class UusiLaji implements Runnable {
        private JFrame frame;

        public UusiLaji() {
        }
        
        @Override
        public void run() {
            frame = new JFrame("Uusi laji");
            
            Dimension ruudunKoko = new Dimension( kali.getKoko() );
            Dimension ikkunanKoko = new Dimension( 400, 200 );
            int x = (int) (ruudunKoko.getWidth() / 2 -  ikkunanKoko.getWidth() / 2);
            int y = (int) (ruudunKoko.getHeight() / 2 - ikkunanKoko.getHeight() / 2);
            
            frame.setSize( ikkunanKoko );
            
            frame.getContentPane().add( KaliPaneelit.uusiLintulajiKaavake(kali) );
            
            frame.setLocation(x, y);
            
            frame.setResizable(false);
            frame.setVisible(true);
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SwingUtilities.invokeLater( new UusiLaji() );
    }
    
}
