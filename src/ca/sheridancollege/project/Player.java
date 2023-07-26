/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Anshul Patel 
 * Updated: 26th July 2023
 */

import java.util.*;
public abstract class Player {

    private String name; //the unique name for this player
    private ArrayList<Card> hand;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Allows the player to draw a card from the provided deck and add it to their hand.
     *
     * @param deck the deck from which the player will draw the card.
     */
    public void drawCard(Deck deck) {
        Card card = deck.drawCard();
        if (card != null) {
            hand.add(card);          
        } else {
            System.out.println("The deck is empty");
        }
    }
    
    /**
     * Allows the player to play a card from their hand by providing the index of the card in their hand.
     *
     * @param index the index of the card to play.
     * @return the card that was played, or null if the index is invalid.
     */
    public Card playCard(int index) {
        if (index >= 0 && index < hand.size()) {
            return hand.remove(index);
        }
        return null;
    }
    
    /**
     * Checks if the player has any cards left in their hand.
     *
     * @return true if the player has cards left, false otherwise.
     */
    public boolean hasCards() {
        return !hand.isEmpty();
    }
    
    /**
     * @return the player's hand of cards.
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

}
