/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.HINT, you might want to subclass this more than
 once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Anshul Patel 
 * Updated on: 26th July 2023
 * @param <T> The type of cards in the group
 */
public class GroupOfCards<T> {

    //The group of cards, stored in an ArrayList
    private final ArrayList<T> cards;
    private final int maxSize;//the size of the grouping

    public GroupOfCards(int maxSize) {
        this.maxSize = maxSize;
        cards = new ArrayList<>();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<T> getCards() {
        return cards;
    }

    /**
     * @return the size of the group of cards
     */
    public int getMaxSize() {
        return maxSize;
    }

    /**
     * @param size the max size for the group of cards
     * @return true if the card was added successfully, false if the group is full
     */
    public boolean addCard(T card) {
        if (cards.size() < maxSize) {
            cards.add(card);
            return true;
        }
        return false;
    }
    
    /**
     * Shuffles the group of Cards 
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

}
