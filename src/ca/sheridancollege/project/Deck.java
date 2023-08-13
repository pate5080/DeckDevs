/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Anshul Alpesh Patel
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
    private GroupOfCards<Card> cards;
    
    public Deck() {
        cards = new GroupOfCards<>(108);
        
        // Initialize the deck with all 108 cards
        for (Color color : Color.values()) {
            if (color != Color.WILD) {
                for (Value value : Value.values()) {
                    if (value != Value.WILD && value != Value.WILD_DRAW_FOUR) {
                        cards.addCard(new Card(color, value));
                        if (value != Value.ZERO) {
                            cards.addCard(new Card(color, value));
                        }
                    }
                }
            }
        }
        // Add wild cards (4 of each)
        for (int i = 0; i < 4; i++) {
            cards.addCard(new Card(Color.WILD, Value.WILD));
            cards.addCard(new Card(Color.WILD, Value.WILD_DRAW_FOUR));
        }
    }
    
    public Card drawCard() {
        if (cards.getCards().isEmpty()) {
            // Handle the case when the deck is empty
            // For simplicity, we'll not recycle the discard pile here
            return null;
        }
        return cards.getCards().remove(0);
    }
    
    /**
     * Shuffles the group of Cards 
     */
    public void shuffle() {
        cards.shuffle();
    }
    
    public int size() {
        return cards.size();
    }
}