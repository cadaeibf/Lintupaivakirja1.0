/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.takut.napit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;

/**
 *
 * @author anterova
 */
public class SoitaAudio implements ActionListener {
    private File tiedosto;

    public SoitaAudio(File tiedosto) {
        this.tiedosto = tiedosto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returVal = fileChooser.showDialog(null, "mp3");
        
        if(returVal == JFileChooser.APPROVE_OPTION) {
            
            try {
                Clip clip = AudioSystem.getClip();
                
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileChooser.getSelectedFile());
                
                clip.open(audioStream);
                clip.start();
                
            } catch (Exception ex) {
                Logger.getLogger(SoitaAudio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
