/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo;

import java.io.File;
import java.util.TreeSet;
import lipvk.ohlo.xml.LataaHavainnotXML;

/**
 *
 * @author anterova
 */
public class Lintulista {
    private TreeSet<Lintulaji> lista;

    public Lintulista() {
        lista = new TreeSet<>();
    }
    
    public static Lintulista lataaLintulista(File tiedosto) {
        return new LataaHavainnotXML().lue(tiedosto);
    }
    
    public void lisaa(Lintulaji lintulaji) {
        lista.add(lintulaji);
    }
    
    public void lisaaHavainto(String laji, Havainto havainto) {
        if( sisaltaa(laji) ) {
            get(laji).lisaaHavainto(havainto);
            return;
        }
        Lintulaji uusi = new Lintulaji(laji);
        uusi.lisaaHavainto(havainto);
        lista.add(uusi);
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
    
    private Lintulaji get(String laji) throws NullPointerException {
        
        for (Lintulaji lintulaji : lista) {
            if(lintulaji.getNimi().toLowerCase().equals(laji.toLowerCase())) return lintulaji;
        }
        
        throw new NullPointerException();
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
