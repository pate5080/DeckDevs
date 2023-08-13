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
public class CardTest {
    
    public CardTest() {
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
     * Test of getColor method, of class Card.
     */
    @Test
    public void testGetColorGood() {
        System.out.println("getColorGood");
        Color expectedColor = Color.RED;
        Value cardValue = Value.TWO;
        Card instance = new Card(expectedColor, cardValue);
        Color expResult = instance.getColor();
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testGetColorBad() {
        System.out.println("getColorBad");
        Color expectedColor = Color.GREEN;
        Value cardValue = Value.SEVEN;
        Card instance = new Card(expectedColor,cardValue);
        instance.setColor(Color.YELLOW);
        Color expResult = expectedColor;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testGetColorBoundary() {
        System.out.println("getColorBoundary");
        Card instance = new Card(null, null);
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValueGood() {
        System.out.println("getValueGood");
        Value expectedValue = Value.FIVE;
        Card instance = new Card(Color.RED, expectedValue);
        Value expResult = expectedValue;
        Value result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testGetValueBad() {
        System.out.println("getValueBad");
        Value expectedValue = Value.SKIP;
        Card instance = new Card(Color.RED, Value.REVERSE);
        Value expResult = expectedValue;
        Value result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testGetValueBoundary() {
        System.out.println("getValueBoundary");
        Card instance = new Card(Color.BLUE, null);
        Value expResult = null;
        Value result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Card.
     */
    @Test
    public void testSetColorGood() {
        System.out.println("setColorGood");
        Color color = Color.BLUE;
        Card instance = new Card(Color.RED, Value.FIVE);
        instance.setColor(color);
        Color expResult = color;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testSetColorBad() {
        System.out.println("setColorBad");
        Color color = Color.GREEN;
        Card instance = new Card(Color.GREEN, Value.SKIP);
        Color invalidColor = Color.RED;
        instance.setColor(invalidColor);
        Color expResult = color;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testSetColorBoundary() {
        System.out.println("setColorBoundary");
        Color boundaryColor = null;
        Card instance = new Card(Color.YELLOW, Value.WILD);
        instance.setColor( boundaryColor);
        Color expResult = boundaryColor;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToStringGood() {
        System.out.println("toStringGood");
        Color cardColor = Color.RED;
        Value cardValue = Value.FIVE;
        Card instance = new Card(cardColor, cardValue);
        String expResult = "Card{Color: RED, Value: FIVE}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testToStringBad() {
        System.out.println("toStringBad");
        Color cardColor = Color.GREEN;
        Value cardValue = Value.SKIP;
        Card instance = new Card(cardColor, cardValue);
        instance.setColor(Color.YELLOW);
        String expResult = "Card{Color: GREEN, Value: SKIP}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    public void testToStringBoundary() {
        System.out.println("toStringBoundary");
        Card instance = new Card(null, null);
        String expResult = "Card{Color: null, Value: null}";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
