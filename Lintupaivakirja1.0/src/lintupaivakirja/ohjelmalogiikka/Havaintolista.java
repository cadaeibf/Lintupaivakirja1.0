/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.ohjelmalogiikka;

/**
 *
 * @author anterova
 */
public class Havaintolista {
    private int jarjestamisperuste;
    private Havainto[] lista;
    private int havaintoja;

    public Havaintolista() {
        jarjestamisperuste = 1;
        havaintoja = 0;
        lista = new Havainto[1000];
    }
    
    public void setJarjestamisperuste(int jarjestamisperuste) {
        this.jarjestamisperuste = jarjestamisperuste;
    }
    
    public void lisaa(Havainto havainto) {
        while(havaintoja >= lista.length) lisaaPaikkoja();
        lista[havaintoja] = havainto;
        havaintoja++;
        jarjesta();
    }
    
    public void poista(Havainto havainto)  {
        boolean loytynyt = false;
        
        for (int i = 0; i < havaintoja; i++) {
            if(!loytynyt) {
                if(lista[i] == havainto) loytynyt = true;
            }
            if(loytynyt) lista[i] = lista[i+1];
        }
        if(!loytynyt) return;
        lista[havaintoja-1] = null;
        havaintoja--;
    }
    
    // Lomitusjärjestäminen
    public void jarjesta() {
        if(havaintoja > 1) mergesort(0,havaintoja-1);
    }
    
    private void mergesort(int vasen, int oikea) {
        if(vasen < oikea) {
            int keski = (vasen + oikea) / 2;
            mergesort(vasen, keski);
            mergesort(keski+1, oikea);
            merge(vasen, keski, oikea);
        }
    }
    
    private void merge(int vasen, int keski, int oikea) {
        int n1 = keski-vasen+2;
        int n2 = oikea-keski+1;
        Havainto[] L = new Havainto[n1];
        Havainto[] R = new Havainto[n2];
        
        int i,j,k;
        
        for (i = 0; i < n1-1; i++) {
            L[i] = lista[vasen+i];
        }
        
        for (j = 0; j < n2-1; j++) {
            R[j] = lista[keski+j+1];
        }
        
        i = 0;
        j = 0;
        
        for (k = vasen; k <= oikea; k++) {
           if(vertaa(L[i],R[j]) <= 0) {
               lista[k] = L[i];
               i++;
           } else {
               lista[k] = R[j];
               j++;
           }
        }
    }
    
    private int vertaa(Havainto havainto1, Havainto havainto2) {
        if(havainto1 == null) return 1;
        if(havainto2 == null) return -1;
        if(jarjestamisperuste == 1) return havainto1.getPvm().compareTo(havainto2.getPvm());
        if(jarjestamisperuste == 2) return havainto1.getPaikka().compareTo(havainto2.getPaikka());
        return havainto1.getLaji().compareTo(havainto2.getLaji()); 
    }

    @Override
    public String toString() {
        String tuloste = "";
        for (int i = 0; i < havaintoja; i++) {
            tuloste += lista[i] + "\n";
        }
        tuloste += "\nHavaintoja: " + havaintoja;
        
        return tuloste;
    }

    private void lisaaPaikkoja() {
        Havainto[] uusi = new Havainto[lista.length+500];
        for (int i = 0; i < lista.length; i++) {
            uusi[i] = lista[i];
        }
        
        lista = uusi;
    }
    
    
}
