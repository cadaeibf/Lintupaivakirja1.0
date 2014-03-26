/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.ohjelmalogiikka;

import lintupaivakirja.util.Pvm;

/**
 *
 * @author anterova
 */
public class Havainto {
    private Lintulaji laji;
    private Havaintopaikka paikka;
    private Pvm pvm;
    private int lkm;

    public Havainto(Lintulaji laji, Pvm pvm, Havaintopaikka paikka, int lkm) {
        this.laji = laji;
        this.paikka = paikka;
        this.pvm = pvm;
        this.lkm = lkm;
    }
    
   public Havainto(Lintulaji laji, Pvm pvm, Havaintopaikka paikka) {
       this.laji = laji;
       this.paikka = paikka;
       this.pvm = pvm;
       this.lkm = 1;
   }

    public Lintulaji getLaji() {
        return laji;
    }

    public Havaintopaikka getPaikka() {
        return paikka;
    }

    public Pvm getPvm() {
        return pvm;
    }

    public int getLkm() {
        return lkm;
    }

    @Override
    public String toString() {
        return laji + "\t" + pvm + "\t" + paikka + " (" + lkm + ")";
    }
   
   
}
