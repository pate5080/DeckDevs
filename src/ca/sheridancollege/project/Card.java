/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Anshul Patel 
 * Date Updated: 26th July 2023
 */

import java.util.*;
        
enum Color {
    RED, YELLOW, GREEN, BLUE, WILD
}

enum Value {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
    SKIP, REVERSE, DRAW_TWO,
    WILD, WILD_DRAW_FOUR
}
public class Card {
    
    private Color color;
    private Value value;
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    public Card(Color color, Value value) {
        this.color = color;
        this.value = value;
    }
    
    public Color getColor() {
        return color;   
    }
    
    public Value getValue() {
        return value;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return color + " " + value;
    }
    
}