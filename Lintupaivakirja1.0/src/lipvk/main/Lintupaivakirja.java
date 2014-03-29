/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.main;

import javax.swing.SwingUtilities;
import lipvk.kali.Kayttoliittyma;

/**
 *
 * @author anterova
 */
public class Lintupaivakirja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Kayttoliittyma() );
    }
}
