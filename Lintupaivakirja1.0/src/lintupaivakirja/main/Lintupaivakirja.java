/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lintupaivakirja.main;

import javax.swing.SwingUtilities;
import lintupaivakirja.gui.Kayttoliittyma;

/**
 *
 * @author anterova
 */
public class Lintupaivakirja {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kayttoliittyma kali = new Kayttoliittyma();
        SwingUtilities.invokeLater(kali);
        
        
//        Havaintolista lista = new Havaintolista();
//        Havainto havainto2 = new Havainto(new Lintulaji("Korppi"), new Havaintopaikka("Tukkipolku"), new Pvm(26,3,2014));
//        Havainto havainto1 = new Havainto( new Lintulaji("Varis"), new Havaintopaikka("Vaasa"), new Pvm(21,3,2014));
//        
//        lista.lisaa(havainto1);
//        lista.lisaa(havainto2);
//        lista.lisaa(new Havainto(new Lintulaji("Ankka"), new Havaintopaikka("Brändö"), new Pvm(26,3,2012)));
//        lista.lisaa(new Havainto(new Lintulaji("Kotka"), new Havaintopaikka("Santtio"), new Pvm(26,6,2013)));
//        lista.lisaa(new Havainto(new Lintulaji("Joutsen"), new Havaintopaikka("Otaniemi"), new Pvm(17,5,2012)));
//        lista.lisaa(new Havainto(new Lintulaji("Lokki"), new Havaintopaikka("Helsinki"), new Pvm(17,5,2012)));
//        lista.lisaa(new Havainto(new Lintulaji("Rastas"), new Havaintopaikka("Brändö"), new Pvm(20,4,2013)));
//        
//        
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Järjestämisperuste: " + i + "\n");
//            lista.setJarjestamisperuste(i);
//            lista.jarjesta();
//            System.out.println(lista);
//            System.out.println("");
//        }
//        
//        System.out.println("poistetaan varishavainto...");
//        lista.poista(havainto1);
//        
//        System.out.println(lista);
    }
}
