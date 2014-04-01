/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelmalogiikkaTests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import lipvk.ohlo.Havainto;
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
public class HavaintoTests {
    private Havainto havainto1;
    
    public HavaintoTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        havainto1 = new Havainto(new Havaintopaikka("Sisarustentie"), new GregorianCalendar(2014, 2, 31), 1);
    }
    
    @After
    public void tearDown() {
    }
    
}