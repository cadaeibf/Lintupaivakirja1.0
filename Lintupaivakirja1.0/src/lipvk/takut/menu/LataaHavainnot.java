/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import lipvk.main.Kayttoliittyma;

/**
 *
 * @author anterova
 */
public class LataaHavainnot implements ActionListener {
    private Kayttoliittyma kali;

    public LataaHavainnot(Kayttoliittyma kali) {
        this.kali = kali;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter("xml tiedostot", "xml") );
        
        int returVal = fileChooser.showDialog( null, "Valitse" );
        
        if( returVal == JFileChooser.APPROVE_OPTION ) {
            kali.lataaHavainnot( fileChooser.getSelectedFile() );
        }
    }
    
}
