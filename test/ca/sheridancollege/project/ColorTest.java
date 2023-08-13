/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Anshul Alpesh Patel
 */
public class ColorTest {
    
    public ColorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of values method, of class Color.
     */
    @Test
    public void testValuesGood() {
        System.out.println("valuesGood");
        Color[] expResult = {Color.RED, Color.GREEN, Color.BLUE};
        Color[] result = Color.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void testValuesBad() {
        System.out.println("valuesBad");
        Color[] expResult = {};
        Color[] result = Color.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    public void testValuesBoundary() {
        System.out.println("valuesBoundary");
        Color[] expResult = {};
        Color[] result = Color.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Color.
     */
    @Test
    public void testValueOfGood() {
        System.out.println("valueOfGood");
        String string = "RED";
        Color expResult = Color.RED;
        Color result = Color.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testValueOfBad() {
        System.out.println("valueOfBad");
        String string = "INVALID_COLOR";
        Color expResult = null;
        Color result = Color.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testValueOfBoundary() {
        System.out.println("valueOfBOundary");
        String string = "";
        Color expResult = null;
        Color result = Color.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
