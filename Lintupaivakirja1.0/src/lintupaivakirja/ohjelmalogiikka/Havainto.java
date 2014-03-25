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

    public Havainto(Lintulaji laji, Havaintopaikka paikka, Pvm pvm, int lkm) {
        this.laji = laji;
        this.paikka = paikka;
        this.pvm = pvm;
        this.lkm = lkm;
    }
    
   public Havainto(Lintulaji laji, Havaintopaikka paikka, Pvm pvm) {
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
   
   
}
