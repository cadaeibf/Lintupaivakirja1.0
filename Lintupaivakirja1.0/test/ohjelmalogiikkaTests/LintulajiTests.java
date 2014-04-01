/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikkaTests;

import lipvk.ohlo.Lintulaji;
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
public class LintulajiTests {
    private Lintulaji ankka;
    private Lintulaji korppi;
    
    public LintulajiTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ankka = new Lintulaji("Ankka");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void toStringToimii1() {
        assertEquals(ankka.toString(), "Ankka");
    }
    
    @Test
    public void vertailuToimiiOikein() {
        assertTrue(ankka.compareTo(korppi) < 0);
    }
}