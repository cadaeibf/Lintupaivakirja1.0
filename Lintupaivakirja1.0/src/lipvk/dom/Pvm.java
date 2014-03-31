/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.dom;

import java.util.Calendar;

/**
 *
 * @author anterova
 */
public class Pvm implements Comparable {
    private int paivat;
    private int kuukaudet;
    private int vuodet;

    public Pvm() {
        Calendar cal = Calendar.getInstance();
        
        paivat = cal.get( Calendar.DAY_OF_MONTH );
        kuukaudet = cal.get( Calendar.MONTH ) + 1;
        vuodet = cal.get( Calendar.YEAR );
    }

    public Pvm(int paivat, int kuukaudet, int vuodet) {
        this.paivat = paivat;
        this.kuukaudet = kuukaudet;
        this.vuodet = vuodet;
    }

    @Override
    public String toString() {
        return paivat + "." + kuukaudet + "." + vuodet; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) return -1;
        Pvm verrattava = (Pvm) o;
        if(this.vuodet != verrattava.vuodet) return verrattava.vuodet - this.vuodet;
        if(this.kuukaudet != verrattava.kuukaudet) return verrattava.kuukaudet - this.kuukaudet;
        return verrattava.paivat - this.paivat;
    }
    
    
}
