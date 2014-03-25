package utilTests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import lintupaivakirja.util.Pvm;
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
public class PvmTest {
    private Pvm pvm1;
    
    public PvmTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pvm1 = new Pvm(11,1,1993);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void toStringToimiiOikein() {
        assertEquals(pvm1.toString(), "11.1.1993");
    }
    
    @Test
    public void jarjestaminen1() {
        Pvm pvm2 = new Pvm(12,1,1993);
        assertTrue(pvm1.compareTo(pvm2) < 0);
    }
}