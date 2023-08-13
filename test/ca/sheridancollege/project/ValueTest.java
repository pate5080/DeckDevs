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
public class ValueTest {
    
    public ValueTest() {
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
     * Test of values method, of class Value.
     */
    @Test
    public void testValuesGood() {
        System.out.println("valuesGood");
        Value[] expResult = {Value.ONE, Value.TWO, Value.THREE, Value.FOUR, Value.FIVE};
        Value[] result = Value.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testValuesBad() {
        System.out.println("valuesBad");
        Value[] expResult = {Value.FIVE, Value.FOUR, Value.THREE, Value.TWO, Value.ONE};
        Value[] result = Value.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testValuesBoundary() {
        System.out.println("valuesBoundary");
        Value[] expResult = null;
        Value[] result = Value.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Value.
     */
    @Test
    public void testValueOfGood() {
        System.out.println("valueOf");
        String string = "ONE";
        Value expResult = Value.ONE;
        Value result = Value.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testValueOfBad() {
        System.out.println("valueOf");
        String string = "INVALID_VALUE";
        Value expResult = Value.ONE;
        Value result = Value.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testValueOfBoundary() {
        System.out.println("valueOf");
        String string = "";
        Value expResult = null;
        Value result = Value.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
