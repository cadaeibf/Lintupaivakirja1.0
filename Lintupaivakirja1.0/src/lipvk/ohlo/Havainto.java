/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo;

import java.util.Calendar;

/**
 *
 * @author anterova
 */
public class Havainto implements Comparable<Havainto> {
    private Havaintopaikka paikka;
    private Calendar pvm;
    private int lkm;

    public Havainto(Havaintopaikka paikka, Calendar pvm, int lkm) {
        this.paikka = paikka;
        this.pvm = pvm;
        this.lkm = lkm;
    }

    public Havaintopaikka getPaikka() {
        return paikka;
    }

    public Calendar getPvm() {
        return pvm;
    }

    public int getLkm() {
        return lkm;
    }
    
    public int getVuosi() {
        return pvm.get(Calendar.YEAR);
    }
    
    public String formatoiPvm() {
        return pvm.get(Calendar.DAY_OF_MONTH) + "."
                + (pvm.get(Calendar.MONTH) + 1) + "."
                + pvm.get(Calendar.YEAR);
    }
    
    public String formatoiPvmXML() {
        String kk = (pvm.get(Calendar.MONTH) + 1) + "";
        if( kk.length() == 1 ) kk = "0" + kk;
        
        String pp = pvm.get(Calendar.DAY_OF_MONTH) + "";
        if( pp.length() == 1 ) pp = "0" + pp;
        
        return pvm.get(Calendar.YEAR) + "-"
                + kk + "-"
                + pp;
    }

    @Override
    public String toString() {
        return paikka.toString() + "\t" + formatoiPvm();
    }

    @Override
    public int compareTo(Havainto o) {
        return this.pvm.compareTo(o.pvm);
    }
   
   
}
