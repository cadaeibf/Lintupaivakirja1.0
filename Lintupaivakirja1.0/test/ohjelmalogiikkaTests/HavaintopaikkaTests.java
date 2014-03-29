/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikkaTests;

import lipvk.ohlo.Havaintopaikka;
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
public class HavaintopaikkaTests {
    private Havaintopaikka santtio;
    private Havaintopaikka tukkipolku;
    
    public HavaintopaikkaTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        santtio = new Havaintopaikka("Santtio");
        tukkipolku = new Havaintopaikka("Tukkipolku");
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
    public void vertailuToimii() {
        assertTrue(santtio.compareTo(tukkipolku) < 0);
    }
}