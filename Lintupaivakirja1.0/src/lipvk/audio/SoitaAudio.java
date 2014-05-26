/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.audio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import lipvk.ohlo.Lintulaji;

/**
 *
 * @author anterova
 */
public class SoitaAudio implements ActionListener {
    private Lintulaji laji;

    public SoitaAudio(Lintulaji laji) {
        this.laji = laji;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Audio.soitaAudio( new File("kirjasto/audio/cornix.mp3"));
    }
    
}
