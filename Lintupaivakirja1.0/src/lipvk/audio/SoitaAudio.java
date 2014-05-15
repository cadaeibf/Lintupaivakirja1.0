/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.audio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
        new Audio().soitaAudio("");
    }
    
}
