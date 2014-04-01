/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo;

import java.util.TreeSet;

/**
 *
 * @author anterova
 */
public class Lintulaji implements Comparable {
    private String nimi;
    private TreeSet<Havainto> havainnot;

    public Lintulaji(String nimi) {
        this.nimi = nimi;
        havainnot = new TreeSet<>();
    }
    
    public void lisaaHavainto(Havainto havainto) {
        havainnot.add(havainto);
    }
    
    public void poistaHavainto(Havainto havainto) {
        havainnot.remove(havainto);
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int getHavaintoja() {
        return havainnot.size();
    }
    
    public String havaintojaVuonna(int vuosi) {
        int havaintoja = 0;
        
        for (Havainto havainto : havainnot) {
            if( havainto.getVuosi() == vuosi ) havaintoja += havainto.getLkm();
        }
        
        if (havaintoja == 0) return "-";
        
        return havaintoja + "";
    }
    
    public String viimeinenHavaintoPaikka() {
        if( havainnot.isEmpty() ) return "-";
        return havainnot.last().getPaikka().toString();
    }
    
    public String viimeinenHavaintoPvm() {
        if( havainnot.isEmpty() ) return "-";
        return havainnot.last().formatoiPvm();
    }
    
    public String viimeinenHavaintoLkm() {
        if( havainnot.isEmpty() ) return "-";
        return havainnot.last().getLkm() + "";
    }
    
    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) return -1;
        Lintulaji verrattava = (Lintulaji) o;
        return nimi.compareTo(verrattava.nimi);
    }

    @Override
    public String toString() {
        String tuloste = "";
        
        for (Havainto havainto : havainnot) {
            tuloste += havainto.toString() + "\n";
        }
        
        return tuloste;
    }
    
    
}
