package com.firsttime.war;

import java.util.List;
import java.util.Scanner;

public class Game {

    /**
     * Game deck
     */
    private Deck deck;

    /**
     * Game printer
     */
    private static PrintUtil printUtil = new PrintUtil();

    /**
     * Human Player
     */
    private Player humanPlayer;

    /**
     * CPU Player
     */
    private Player cpuPlayer;

    /**
     * start the game
     */
    public void startGame() {
        //print opening message
        printUtil.openingMessage();

        // get player 1 name from stdin
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        this.humanPlayer = new Player(name);
        this.cpuPlayer = new Player("CPU");

        //start Game Message
        printUtil.startGameMessage(humanPlayer);

        //create fresh deck
        deck = new Deck();

        //shuffle deck
        deck.shuffleDeck();

        //Create and set hands
        humanPlayer.setHand(new Hand());
        cpuPlayer.setHand(new Hand());

        //dealCards to hand
        dealCards(humanPlayer.getHand());
        dealCards(cpuPlayer.getHand());

        printUtil.printRoundHeader(humanPlayer, cpuPlayer);

        // show result
        int maxRounds = 27;
        Player winner = null;
        while (battle(humanPlayer, cpuPlayer, null)) {
            maxRounds--;

            // check hands for winner
            if (humanPlayer.getHand().handSize() == 0) {

                // cpu is winner
                winner = cpuPlayer;
                break;
            } else if (cpuPlayer.getHand().handSize() == 0) {

                // player is winner
                winner = humanPlayer;
                break;
            }

            if (maxRounds < 0) {
                break;
            }
        }

        if (winner != null) {

            // someone won
        } else if (humanPlayer.getHand().handSize() > cpuPlayer.getHand().handSize()) {
            winner = humanPlayer;
        } else if (cpuPlayer.getHand().handSize() > humanPlayer.getHand().handSize()) {
            winner = cpuPlayer;
        } else {

            // draw
            printUtil.announceDraw();
            return;
        }
        printUtil.announceGameWinner(winner);
    }

    // Deal 26 cards to each hand in alternating order
    public void dealCards(Hand hand) {
        for (int i = 0; i < 26; i++) {
            hand.addCardToTop(deck.dealCard());
        }
    }

    // Models a battle between player1 and player2. If the battle
    // results in a war, three cards from each player are placed
    // in the prize queue and the battle is continued recursively.
    public boolean battle(Player playerOne, Player playerTwo, Hand pot) {

        // both players show top card from deck, each player draws from top of deck
        //store cards that are in play in an array.
        Card playerOneFaceUp = playerOne.getHand().removeCardFromTop();
        if (playerOneFaceUp == null) {
            return false;
        }

        Card playerTwoFaceUp = playerTwo.getHand().removeCardFromTop();
        if (playerTwoFaceUp == null) {
            return false;
        }

        //In case of war each player adds 3 cards to pot and the forth card is evaluated
        if (pot == null) {
            pot = new Hand();
        }
        pot.addCardToTop(playerOneFaceUp);
        pot.addCardToTop(playerTwoFaceUp);

        int result = playerOneFaceUp.compareTo(playerTwoFaceUp);
        switch (result) {
            case 0:
                printUtil.announceWarRound();

                //each player adds three cards to the prize hand
                List<Card> warPlayerOnePot = playerOne.getHand().take(3);
                if (warPlayerOnePot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerOnePot);

                List<Card> warPlayerTwoPot = playerTwo.getHand().take(3);
                if (warPlayerTwoPot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerTwoPot);

                return battle(playerOne, playerTwo, pot);
            case 1:
                //Give all cards on table to player 1
                //player1 adds both face up cards to bottom of her deck
                playerOne.getHand().mergeHand(pot);
                printUtil.announceRoundWinner(playerOne, playerOneFaceUp, playerTwo, playerTwoFaceUp, playerOne.getName());
                break;
            case -1:
                //Give all cards on table to player 2
                //player2 adds both face up cards to bottom of his deck
                playerTwo.getHand().mergeHand(pot);
                printUtil.announceRoundWinner(playerOne, playerOneFaceUp, playerTwo, playerTwoFaceUp, playerTwo.getName());
                break;
        }

        return true;
    }
}







