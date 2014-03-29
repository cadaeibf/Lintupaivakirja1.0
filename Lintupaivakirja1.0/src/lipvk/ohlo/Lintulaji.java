/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lipvk.ohlo;

/**
 *
 * @author anterova
 */
public class Lintulaji implements Comparable {
    private String nimi;
    private String latinalainenNimi;

    public Lintulaji (String nimi, String latinalainenNimi) throws IllegalArgumentException {
        if(nimi == null) throw new IllegalArgumentException();
        this.nimi = nimi;
        this.latinalainenNimi = latinalainenNimi;
    }

    public Lintulaji(String nimi) throws IllegalArgumentException {
        if(nimi == null) throw new IllegalArgumentException();
        if(nimi.equals("")) throw new IllegalArgumentException();
        this.nimi = nimi;
    }
    
    public void setLatinalainenNimi(String latinalainenNimi) {
        this.latinalainenNimi = latinalainenNimi;
    }
    
    public String getLatinalainenNimi() {
        if(latinalainenNimi == null) return "";
        return this.latinalainenNimi;
    }

    @Override
    public String toString() {
        return this.nimi; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public int compareTo(Object o) {
        if(o.getClass() != this.getClass()) return -1;
        Lintulaji verrattava = (Lintulaji) o;
        return nimi.compareTo(verrattava.nimi);
    }
}
