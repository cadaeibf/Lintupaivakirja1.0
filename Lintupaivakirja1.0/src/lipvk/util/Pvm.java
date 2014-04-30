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

    public Pvm() {
    }
    
    public Calendar uusi(int vuosi, int kuukausi, int paiva) {
        return new GregorianCalendar(vuosi, kuukausi-1, paiva);
    }
}
