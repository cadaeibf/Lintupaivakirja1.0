/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.audio;

import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author anterova
 */
public class Audio {

    public Audio() {
    }
    
    public static void soitaAudio(File tiedosto) {
        final File file = tiedosto;
       JFrame frame = new JFrame("");
       final JFXPanel fxpanel = new JFXPanel();
       frame.add(fxpanel);
       frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        Platform.runLater( new Runnable() {
            @Override public void run() {
                playAudio(file);
            }
        } );
       
    }
    
    private static void playAudio(File tiedosto) {
         new MediaPlayer( new Media("file://" + tiedosto.getAbsolutePath()) ).play();
    }
    
}
