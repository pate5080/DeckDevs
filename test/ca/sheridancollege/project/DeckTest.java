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
public class DeckTest {
    
    public DeckTest() {
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
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffleGood() {
        System.out.println("shuffle");
        Deck instance = new Deck();
        instance.shuffle();
        int initialSize = 108;
        assertEquals(initialSize, instance.size());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testShuffleBad() {
        System.out.println("shuffle");
        Deck instance = new Deck();
        instance.shuffle();
        int initialSize = 2;
        assertEquals(initialSize, instance.size());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testShuffleBoundary() {
        System.out.println("shuffle");
        Deck instance = new Deck();
        instance.shuffle();
        int initialSize = 0;
        assertEquals(initialSize, instance.size());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
