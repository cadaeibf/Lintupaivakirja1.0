/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.audio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author anterova
 */
public class ValitseAani implements ActionListener {
    private JLabel aaniKentta;

    public ValitseAani(JLabel aaniKentta) {
        this.aaniKentta = aaniKentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter( new FileNameExtensionFilter("wav-tiedostot", "wav") );
        
        if( fileChooser.showDialog(null, "Valitse") == JFileChooser.APPROVE_OPTION ) {
            aaniKentta.setText( fileChooser.getSelectedFile().getAbsolutePath() );
        }
    }
    
}
