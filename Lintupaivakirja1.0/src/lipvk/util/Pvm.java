/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author anterova
 */
public class Pvm {

    public static Calendar uusi(int vuosi, int kuukausi, int paiva) {
        return new GregorianCalendar(vuosi, kuukausi-1, paiva);
    }
    
    public static String tanaan() {
        Calendar cal = Calendar.getInstance();
        
        return cal.get(Calendar.DAY_OF_MONTH) + "." + ( cal.get(Calendar.MONTH) + 1 ) + "." + cal.get(Calendar.YEAR);
    }
    
    public static Calendar luePvm(String syote) throws IllegalArgumentException {
        String teksti = syote.trim();
        teksti = teksti.replace(" ", "");
        
        if(!teksti.matches("[012]?[0-9].[01]?[0-9].[0-9][0-9][0-9][0-9]")) throw new IllegalArgumentException();
        
        GregorianCalendar pvm = new GregorianCalendar();
        
        String[] data = teksti.split("\\.");
        
        pvm.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data[0]));
        pvm.set(Calendar.MONTH, (Integer.parseInt(data[1]) - 1));
        pvm.set(Calendar.YEAR, Integer.parseInt(data[2]));
        
        return pvm;
    }
}
