/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikkaTests;

import lipvk.ohlo.Havainto;
import lipvk.ohlo.Havaintolista;
import lipvk.ohlo.Havaintopaikka;
import lipvk.ohlo.Lintulaji;
import lipvk.dom.Pvm;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anterova
 */
public class HavaintolistaTests {
    private Havaintolista lista;
    
    public HavaintolistaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lista = new Havaintolista();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisays1() {
        lista.lisaa( new Havainto( new Lintulaji( "Ankka" ), new Pvm( 27,3,2014 ) , new Havaintopaikka( "Tukkipolku" ) ) );
        assertEquals(lista.getHavaintoja(), 1);
    }
    
    @Test
    public void lisays2() {
        lista.lisaa( new Havainto( new Lintulaji( "Ankka" ), new Pvm( 27,3,2014 ) , new Havaintopaikka( "Tukkipolku" ) ) );
        assertEquals("Ankka\t27.3.2014\tTukkipolku (1)\nHavaintoja: 1", lista.toString());
    }
    
    @Test
    public void lisays3() {
        lista.lisaa( new Havainto( new Lintulaji( "Ankka" ), new Pvm( 27,3,2014 ) , new Havaintopaikka( "Tukkipolku" ) ) );
        lista.lisaa( new Havainto( new Lintulaji( "Papukaija" ), new Pvm( 27,3,2014 ) , new Havaintopaikka( "Tukkipolku" ) ) );
        lista.lisaa( new Havainto( new Lintulaji( "Korppi" ), new Pvm( 27,3,2014 ) , new Havaintopaikka( "Tukkipolku" ) ) );
        
        assertEquals("Korppi", lista.get(1).getLaji().toString());
    }
    
}