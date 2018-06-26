package com.firsttime.war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representative of Deck of cards. 52 cards in total made up of 4 suites of cards
 */
public class Deck {

    private final List<Card> cards = new ArrayList<Card>();

    Deck() {
        createDeck();
    }

    private void createDeck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(r, s));
            }
        }
    }

    /**
     * Shuffles the deck so that the locations of the cards are random.
     */
    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    /**
     * @return List of type Card
     */
    public List<Card> getCards() {
        return this.cards;
    }

    /**
     * @return number of cards left in the deck
     */
    public int getCardsCount() {
        return this.cards.size();
    }

    /**
     * Deals a card from the top of the deck, removing it from the deck.
     *
     * @return a card from the end of the arrayList(Top Card)
     * @throws //EmptyDeckException @throws IllegalStateException if no more cards are left.
     */
    public Card dealCard() {
        /**if(this.cards.size() == 0){
         return  EmptyDeckException;
         }*/
        return this.cards.remove(this.cards.size() - 1);
    }

    /**
     * Adds a card to the bottom of the deck.
     *
     * @param c the card to be added to the bottom of the deck, index 0 of arraylist
     */
    public void addCard(Card c) {
        this.cards.add(0, c);
    }

    /**
     * @return a String containing all of the cards in order
     */
    @Override
    public String toString() {
        return this.cards.toString();
    }
}


