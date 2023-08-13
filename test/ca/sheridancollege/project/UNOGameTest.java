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
import java.util.ArrayList;

/**
 *
 * @author Anshul Alpesh Patel
 */
public class UNOGameTest {
    
    public UNOGameTest() {
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
     * Test of getDeck method, of class UNOGame.
     */
    @Test
    public void testGetDeckGood() {
        System.out.println("getDeckGood");
        ArrayList<Player> players = new ArrayList<>();
        UNOGame instance = new UNOGame("Test Game", players);
        Deck expResult = instance.getDeck();
        Deck result = instance.getDeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testGetDeckBad() {
        System.out.println("getDeckBad");
        UNOGame instance = null;
        Deck expResult = null;
        Deck result = instance.getDeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testGetDeckBoundary() {
        System.out.println("getDeckBOundary");
        
        // Create an empty list of players
        ArrayList<Player> players = new ArrayList<>();
        UNOGame instance = new UNOGame("Empty Deck", players);
        Deck expResult = new Deck();
        Deck result = instance.getDeck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
