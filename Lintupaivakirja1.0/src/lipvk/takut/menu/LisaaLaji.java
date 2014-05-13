/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.menu;

import java.awt.Dimension;
import java.awt.Toolkit;
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
            
            Dimension ruudunKoko = new Dimension( Toolkit.getDefaultToolkit().getScreenSize() );
            Dimension ikkunanKoko = new Dimension( 100, 200 );
            
            frame.setSize( ikkunanKoko );
            
            frame.getContentPane().add( KaliPaneelit.uusiLintulajiKaavake(kali) );
            
            frame.pack();
            
            int x = ruudunKoko.width / 2 -  ikkunanKoko.width / 2;
            int y = ruudunKoko.height / 2 - ikkunanKoko.height / 2;
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
