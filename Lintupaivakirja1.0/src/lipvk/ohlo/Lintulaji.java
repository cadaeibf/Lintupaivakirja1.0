/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Luokka kuvaa lintulajia ja siihen liittyviä havaintoja.
 * @author anterova
 */
public class Lintulaji implements Comparable {
    private String nimi;
    private String heimo;
    private String lahko;
    private String latNimi;
    private File aanitiedosto;
    private List<File> kuvat;
    
    private TreeSet<Havainto> havainnot;

    public Lintulaji(String nimi) throws IllegalArgumentException {
        if(nimi == null) throw new IllegalArgumentException();
        if(nimi.equals("")) throw new IllegalArgumentException();
        
        this.nimi = nimi;
        this.kuvat = new ArrayList<>();
        havainnot = new TreeSet<>();
    }

    public void setLatNimi(String latNimi) {
        this.latNimi = latNimi;
    }

    public void setLahko(String lahko) {
        this.lahko = lahko;
    }

    public void setHeimo(String heimo) {
        this.heimo = heimo;
    }

    public void setAaniTiedosto(File aanitiedosto) {
        this.aanitiedosto = aanitiedosto;
    }
    
    public void lisaaKuva(File kuva) {
        kuvat.add(kuva);
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

    public String getLatNimi() {
        if( latNimi == null ) return "";
        return latNimi;
    }

    public String getLahko() {
        if( lahko == null ) return "";
        return lahko;
    }

    public String getHeimo() {
        if( heimo == null ) return "";
        return heimo;
    }
    
    public int getHavaintoja() {
        return havainnot.size();
    }

    public File getAanitiedosto() {
        return aanitiedosto;
    }

    public List<File> getKuvat() {
        return kuvat;
    }
    
    public boolean eiHavaintoja() {
        return havainnot.isEmpty();
    }
    
    public boolean eiAanitiedostoa() {
        return aanitiedosto == null;
    }
    
    public TreeSet<Havainto> getHavainnot() {
        return havainnot;
    }
    
    public String havaintojaVuonna(int vuosi) {
        int havaintoja = 0;
        
        for (Havainto havainto : havainnot) {
            if( havainto.getVuosi() == vuosi ) havaintoja ++;
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
    
    public void tyhjennaHavainnot() {
        havainnot.removeAll(kuvat);
    }
    
    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) return -1;
        Lintulaji verrattava = (Lintulaji) o;
        return nimi.compareTo(verrattava.nimi);
    }

    @Override
    public String toString() {
        return nimi;
    }
    
    
}
