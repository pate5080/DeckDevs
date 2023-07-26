/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * A class that represents the UNO card game, a specific implementation of the Game class.
 * The UNOGame class handles the game flow, rules, and interactions between players and the deck.
 * It allows players to draw cards, play cards, and checks for UNO calls and winning conditions.
 * The game continues until one player has no cards left, and they are declared the winner.
 * Players take turns to match the top card on the discard pile by either color, number, or type of card.
 * If a player cannot play a card, they must draw from the draw pile until they get a playable card.
 * Special cards (Skip, Reverse, Draw Two, Wild, Wild Draw Four) have specific effects in the game.
 * The direction of play can be reversed by playing the Reverse card.
 * Players need to call UNO when they have only one card left; failure to do so and getting caught will result in drawing two penalty cards.
 *
 * @author Anshul Alpesh Patel July 2023
 */

import java.util.*;


public class UNOGame extends Game{
    private Deck deck;
    private ArrayList<Card> discardPile;
    private int currentPlayerIndex;
    private int direction;
    private boolean reverse;
    
    /**
     * Constructs an instance of the UNOGame class with the given name and list of players.
     *
     * @param name    the name of the UNO game.
     * @param players the list of players participating in the game. 
     */
    public UNOGame(String name, ArrayList<Player> players) {
        super(name);
        deck = new Deck();
        discardPile = new ArrayList<>();
        currentPlayerIndex = 0;
        direction = 1;
        reverse = false;
        
        // Assign players to the Game
        setPlayers(players);
    }
    
    /**
     * Gets the current deck used in the UNO game.
     *
     * @return the deck instance
     */
    public Deck getDeck() {
        return deck;
    }
    
    /**
     * Deals initial cards to players when the game starts.
     * Each player receives 7 cards from the deck.
     */
    public void initialDeal() {
        int numInitialCards = 7;
        for (Player player : getPlayers()) {
            for (int i = 0; i < numInitialCards; i++) {
                player.drawCard(deck);
            }
        }
    }
    
   
    /**
     * The main game loop that runs the UNO game until one player wins.
     * It handles the turns of players, checks for playable cards, and enforces UNO call rules.
     */
    
   @Override
   public void play() {
       // Start the game loop
       while (!isGameOver()) {
           Player currentPlayer = getCurrentPlayer();
           System.out.println("\n" + currentPlayer.getName() + "'s turn!");
           
           // Display the top card on the discard pile
           Card topCard = getTopCard();
           if (topCard != null) {
               System.out.println("Top Card: " + topCard);
           } 
           // Gets the first top card for the first player in the very first round
           else {
               System.out.println("Discard pile is empty. Drawing the first card to start the game.");
                topCard = deck.drawCard();
                discardPile.add(topCard);
           }
          
           // Display the player's hand
           ArrayList<Card> hand = currentPlayer.getHand();
           System.out.println("Yout Hand: " + hand);
           
           // Check if the player can play a card
           boolean validCardPlayed = false;
           while (!validCardPlayed) {
           int cardIndex = selectCardIndex(currentPlayer);
           Card selectedCard = currentPlayer.playCard(cardIndex);

           if (selectedCard == null) {
               // Player chose not to play a card (maybe drawing a card)
                break;
           }
           
           if (isPlayable(selectedCard, topCard)) {
                // Valid card played, update the discard pile
                discardPile.add(selectedCard);
               
               if (selectedCard.getColor() == Color.WILD) {
                   // Handle Wild cards
                   // For simplicity, we'll allow the player to choose the new color (0 for Red, 1 for Yellow, etc.)
                   System.out.println("Select new color: 0-Red, 1-Yellow, 2-Green, 3-Blue");
                   Scanner scanner = new Scanner(System.in);
                   int newColorIndex = scanner.nextInt();
                   Color newColor = Color.values()[newColorIndex];
                   selectedCard.setColor(newColor);
               }
               
               // Handle special cards
               handleSpecialCards(selectedCard);
               
               // Break out of the loop, valid card played
                validCardPlayed = true; 
           } else {
               // Card is not playable, ask the player to retry
                System.out.println("Invalid card! Please choose a card with matching color or number.");
               // Player cannot play, draw a card
               currentPlayer.drawCard(deck);
           }
           
           // Move to the next Player
           updateCurrentPlayerIndex();
           
           // Check for UNO call and upadte direction if necessary
           handleUNOCall(currentPlayer);
           updateDirection();
        }
    }
    
    /**
     * Checks if a card is playable on the discard pile based on color, number, or type of card.
     *
     * @param card    the card to check for playability.
     * @param topCard the top card on the discard pile.
     * @return true if the card is playable, false otherwise.
     */
    private boolean isPlayable(Card card, Card topCard) {
        // Implement the logic to check if a card is playable on the discard pile
        Color topColor = topCard.getColor();
        Value topValue = topCard.getValue();
        Color cardColor = card.getColor();
        Value cardValue = card.getValue();

        return cardColor == topColor || cardValue == topValue ||
                cardColor == Color.WILD || cardValue == Value.WILD ||
                cardColor == Color.WILD && cardValue == Value.WILD_DRAW_FOUR;
    }
    
    /**
     * Gets the current player whose turn it is.
     *
     * @return the current player.
     */
    private Player getCurrentPlayer() {
        return getPlayers().get(currentPlayerIndex);
    }
    
    /**
     * Gets the top card on the discard pile.
     *
     * @return the top card on the discard pile, or null if the discard pile is empty.
     */
    private Card getTopCard() {
        if (!discardPile.isEmpty()) {
            return discardPile.get(discardPile.size() - 1);
        }
        return null;
    }
    
    /**
     * Prompts the player to select a card index from their hand to play.
     *
     * @param player the player whose turn it is.
     * @return the index of the card selected by the player.
     */
    private int selectCardIndex(Player player) {
        // Implement the logic to prompt the player to select a card from their hand
        // For simplicity, let's assume the player enters a valid index
        System.out.println("Enter the index of the card you want to play: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    /**
     * Handles the effects of special cards (Skip, Reverse, Draw Two, Wild Draw Four) when played.
     *
     * @param card the special card played by the player.
     */
    private void handleSpecialCards(Card card) {
        // Implement the logic to handle special cards (Skip, Reverse, Draw Two, Wild Draw Four)
        // You may need to update currentPlayerIndex, direction, and handle drawing cards for Draw Two and Wild Draw Four.
        
        switch (card.getValue()) {
        case SKIP:
            updateCurrentPlayerIndex();
            break;
        case REVERSE:
            reverse = !reverse;
            updateCurrentPlayerIndex();
            break;
        case DRAW_TWO:
            Player nextPlayerDrawTwo = getCurrentPlayer();
            updateCurrentPlayerIndex();
            Player nextPlayerDrawTwoAgain = getCurrentPlayer();
            nextPlayerDrawTwo.drawCard(deck);
            nextPlayerDrawTwoAgain.drawCard(deck);
            break;
        case WILD_DRAW_FOUR:
            Player nextPlayerWildDrawFour = getCurrentPlayer();
            updateCurrentPlayerIndex();
            Player nextPlayerWildDrawFourAgain = getCurrentPlayer();
            nextPlayerWildDrawFour.drawCard(deck);
            nextPlayerWildDrawFour.drawCard(deck);
            nextPlayerWildDrawFour.drawCard(deck);
            nextPlayerWildDrawFourAgain.drawCard(deck);
            break;
    }
    }
    
    /**
     * Checks if the player needs to call UNO and penalizes them if they fail to do so.
     *
     * @param player the player whose turn it is.
     */
    private void handleUNOCall(Player player) {
        // Implement the logic to check if the player needs to call UNO
        if (player.getHand().size() == 1) {
            // The player has only one card left. check if the player announce UNO
            System.out.println(player.getName() + ", do you want to call UNO? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine().toUpperCase();
            if (!answer.equals("Y")) {
                System.out.println("You didn't call UNO! Draw two penalty cards.");
                player.drawCard(deck);
                player.drawCard(deck);
            }
        }
    }
    
    /**
     * Updates the currentPlayerIndex based on the direction of play (clockwise or counterclockwise).
     */
    private void updateCurrentPlayerIndex() {
        // Implement the logic to update the currentPlayerIndex based on the direction of play
        if (reverse) {
        // When direction is reversed, move to the previous player
        currentPlayerIndex = ((currentPlayerIndex - 1) + getPlayers().size()) % getPlayers().size();
    } else {
        // When direction is forward, move to the next player
        currentPlayerIndex = (currentPlayerIndex + 1) % getPlayers().size();
    }
    }
    
    /**
     * Updates the direction of play (clockwise or counterclockwise) if a Reverse card is played.
     */
    private void updateDirection() {
        // Implement the logic to update the direction of play if a Reverse card is played
        Card topCard = getTopCard();
        if (topCard.getValue() == Value.REVERSE) {
            direction *= -1;
        }
    }
    
    /**
     * Checks if the game is over (one player has no cards left).
     *
     * @return true if the game is over, false otherwise.
     */
    private boolean isGameOver() {
        // Implement the logic to check if the game is over (one player has no cards left)
        for (Player player : getPlayers()) {
            if (!player.hasCards()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Declares and displays the winning player when the game is over.
     */
    
    @Override
    public void declareWinner() {
        // Implement the logic to declare and display the winning player
        for (Player player : getPlayers()) {
            if (!player.hasCards()) {
                System.out.println(player.getName() + " wins!");
                break;
            }
    }
     
}
}
