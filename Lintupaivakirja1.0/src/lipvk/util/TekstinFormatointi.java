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
        
        return ( teksti.charAt(0) + "" ).toUpperCase() + teksti.substring(1);
    }
    
    public static String tiedostonimeksi(String teksti) {
        String output = teksti;
        
        output = output.trim();
        output = output.replace(" ", "");
        output = output.replace("ä", "a");
        output = output.replace("ö", "o");
        
        return output;
    }
    
}
