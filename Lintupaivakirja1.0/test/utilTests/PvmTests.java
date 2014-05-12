/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilTests;

import java.util.Calendar;
import lipvk.util.Pvm;
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
public class PvmTests {
    
    public PvmTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void luePvmTest1() {
        try{
            Calendar kalenteri = Pvm.luePvm("12 .7.2014 ");
        } catch(IllegalArgumentException ex) {
            throw new AssertionError();
        }
    }
    
    @Test
    public void virheellinenPvm1() {
        try {
            Calendar kalenteri = Pvm.luePvm("");
            
            throw new AssertionError();
        } catch(IllegalArgumentException ex) {
            assertTrue(true);
        }
    }
    
    @Test
    public void virheellinenPvm2() {
        try {
            Calendar kalenteri = Pvm.luePvm("..");
            
            throw new AssertionError();
        } catch(IllegalArgumentException ex) {
            assertTrue(true);
        }
    }
    
    @Test
    public void virheellinenPvm3() {
        try {
            Calendar kalenteri = Pvm.luePvm("15.12.201a4");
            
            throw new AssertionError();
        } catch(IllegalArgumentException ex) {
            assertTrue(true);
        }
    }
    
}