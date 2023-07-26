/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Main class for the UNO game.
 * This class is responsible for running the UNO game by creating players, initializing the game, and starting the game loop.
 * It prompts the user to enter the number of players and their names, deals initial cards, and declares the winner at the end of the game.
 * 
 * @author Anshul Alpesh Patel July 2023
 */
public class Main {
    /**
     * The main method to run the UNO game.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the number of Players
        System.out.print("Enter the number of players (2-10): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        
        if (numPlayers < 2 || numPlayers > 10) {
            System.out.println("Invalid number of players.");
            return;
        }
        
        // Create players and add them to a list
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter the name of Player " + i + ":");
            String playerName = scanner.nextLine();
            players.add(new UNOPlayer(playerName));
        }
        
        // Create and Initialize the UNO game
        UNOGame unoGame = new UNOGame("UNO Game" , players);
        
        // Shuffle the deck
        unoGame.getDeck().shuffle();
        
        // Deal initial cards to players
        unoGame.initialDeal();
        
        // Start the game
        unoGame.play();
        
        // Declare the winner
        unoGame.declareWinner();
    }
}
