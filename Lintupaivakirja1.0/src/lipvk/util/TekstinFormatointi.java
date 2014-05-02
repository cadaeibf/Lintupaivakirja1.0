/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.util;

/**
 * Apuluokka erinäisiin tekstimanipulaatioihin.
 * @author anterova
 */
public class TekstinFormatointi {

    public static String isoAlkukirjain(String teksti) {
        if( teksti.equals("") ) return "";
        
        
        
        return ( teksti.charAt(0) + "" ) + teksti.substring(1);
    }
    
}
