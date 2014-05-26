/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.audio;

import java.awt.Dimension;
import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JFrame;

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
       frame.getContentPane().add(fxpanel);
       frame.setSize( new Dimension(300, 200) );
       
       frame.setVisible(true);
       
        Platform.runLater( new Runnable() {
            @Override public void run() {
                Media media = new Media("file://" + file.getAbsolutePath());
                MediaPlayer player = new MediaPlayer( media );
                player.play();
            }
        } );
       
    }
    
}
