/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.ohjelmalogiikka;

/**
 *
 * @author anterova
 */
public class Havaintopaikka implements Comparable{
    private String nimi;

    public Havaintopaikka(String nimi) throws IllegalArgumentException {
        if(nimi.equals("")) throw new IllegalArgumentException();
        
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return this.nimi; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) return -1;
        Havaintopaikka verrattava = (Havaintopaikka) o;
        return nimi.compareTo(verrattava.nimi);
        
    }
    
    
}
