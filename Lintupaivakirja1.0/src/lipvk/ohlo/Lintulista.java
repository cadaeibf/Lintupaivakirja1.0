/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo;

import java.io.File;
import java.util.TreeSet;
import lipvk.ohlo.xml.LataaHavainnotXML;
import lipvk.ohlo.xml.TallennaHavainnotXML;

/**
 *
 * @author anterova
 */
public class Lintulista {
    private TreeSet<Lintulaji> lista;

    public Lintulista() {
        lista = new TreeSet<>();
    }
    
    public void lataaHavainnot(File tiedosto) {
        new LataaHavainnotXML().lue(tiedosto, this);
    }
    
    public static void tallennaHavainnot(Lintulista lintulista, File tiedosto) {
        new TallennaHavainnotXML().kirjoita(lintulista, tiedosto);
    }
    
    /**
     * Metodi lintulajien lataamiseen tallennustiedostosta.
     * @param lintulaji 
     */
    public void lisaa(Lintulaji lintulaji) {
        lista.add(lintulaji);
    }
    
    /**
     * Metodi lisää annetulle lintulajille havainnon.
     * @param laji
     * @param havainto
     * @throws NullPointerException jos annettua lajia ei löydy listasta
     */
    public void lisaaHavainto(String laji, Havainto havainto) throws NullPointerException {
        if( !sisaltaa(laji) ) throw new NullPointerException();
        
        get(laji).lisaaHavainto(havainto);
    }
    
    public void poista(Lintulaji lintulaji) {
        if(lista.contains(lintulaji)) lista.remove(lintulaji);
    }
    
    public boolean sisaltaa(String laji) {
        for (Lintulaji lintulaji : lista) {
            if(lintulaji.getNimi().toLowerCase().equals(laji.toLowerCase())) return true;
        }
        
        return false;
    }
    
    public int koko() {
        return lista.size();
    }
    
    public int getHavaintoja() {
        int havaintoja = 0;
        
        for (Lintulaji lintulaji : lista) {
            havaintoja += lintulaji.getHavaintoja();
        }
        
        return havaintoja;
    }
    
    public TreeSet<Lintulaji> getLista() {
        return lista;
    }
    
    public Lintulaji get(String laji) {
        for (Lintulaji lintulaji : lista) {
            if( lintulaji.getNimi().toLowerCase().equals( laji.toLowerCase() ) ) return lintulaji;
        }
        return null;
    }

    @Override
    public String toString() {
        String tuloste = "";
        
        for (Lintulaji lintulaji : lista) {
            tuloste += lintulaji.toString() + "\n";
        }
        
        return tuloste;
    }
    
    
    
}
