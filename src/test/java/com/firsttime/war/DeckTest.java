package com.firsttime.war;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.firsttime.war.Rank.ACE;
import static com.firsttime.war.Suit.HEARTS;


public class DeckTest {

    Deck testDeck;

    @Before
    public void setUpBefore() {
        testDeck = new Deck();
    }

    @Test
    public void constructor_create52UniqueCards() {
        int expected = 52;
        int actual = new HashSet<>(testDeck.getCards()).size();
        Assert.assertEquals(expected, actual);
    }

    //52 cards should be in enum ordinal, constructor test
    /** @Test public void constructor_cardsPriorToShuffleInEnumOrdinal() {

    Assert.assertEquals(testDeck.getCards().get(0), new Card(Rank.TWO, Suit.DIAMONDS));
    Assert.assertEquals(testDeck.getCards().get(51), new Card(Rank.ACE, Suit.HEARTS));
    }*/

    //Cards should be the same before shuffling
    /**@Test public void beforeShuffle() {
    Assert.assertEquals(new Deck().getCards(), testDeck.getCards());
    }*/

    //Cards should be different after shuffling
    //@Test

    /**
     * public void afterShuffle() {
     * Assert.assertNotEquals(new Deck().shuffleDeck().getCards(), testDeck.getCards());
     * }
     */

    @Test
    public void toString_returnsStringOfCardsInDeck() {
        String expected = "";
        String actual = testDeck.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardsCount_returnsCountOfCardsInNewDeck() {
        int expected = 52;
        int actual = testDeck.getCardsCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealCard_returnsLastCardInDeck() {
        Suit sExpected = Suit.HEARTS;
        Rank rExpected = Rank.ACE;
        Card actual = testDeck.dealCard();
        Suit sActual = actual.getSuit();
        Rank rActual = actual.getRank();
        Assert.assertEquals(sExpected, sActual);
        Assert.assertEquals(rExpected, rActual);
        System.out.println(testDeck.dealCard());
    }

    @Test
    public void getCardsCount_returnsCountOfCardsAfterRemoved() {
        int expected = 50;
        testDeck.dealCard();
        testDeck.dealCard();
        int actual = testDeck.getCardsCount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCard() {


    }

    /**@Test public void getCards_() {
    List<Card> expected = new ArrayList<Card>(Arrays.asList(
    new Card(Rank.TWO, Suit.DIAMONDS),
    new Card(Rank.THREE, Suit.DIAMONDS),
    new Card(Rank.FOUR, Suit.DIAMONDS),
    new Card(Rank.FIVE, Suit.DIAMONDS), new Card(Rank.SIX, Suit.DIAMONDS), new Card(Rank.SEVEN, Suit.DIAMONDS), new Card(Rank.EIGHT, Suit.DIAMONDS), new Card(Rank.NINE, Suit.DIAMONDS), new Card(Rank.TEN, Suit.DIAMONDS), new Card(Rank.JACK, Suit.DIAMONDS), new Card(Rank.QUEEN, Suit.DIAMONDS),
    new Card(Rank.KING, Suit.DIAMONDS), new Card(Rank.ACE, Suit.DIAMONDS), new Card(Rank.TWO, Suit.SPADES), new Card(Rank.THREE, Suit.SPADES), new Card(Rank.FOUR, Suit.SPADES), new Card(Rank.FIVE, Suit.SPADES),
    new Card(Rank.SIX, Suit.SPADES), new Card(Rank.SEVEN, Suit.SPADES), new Card(Rank.EIGHT, Suit.SPADES), new Card(Rank.NINE, Suit.SPADES), new Card(Rank.TEN, Suit.SPADES), new Card(Rank.JACK, Suit.SPADES),
    new Card(Rank.QUEEN, Suit.SPADES), new Card(Rank.KING, Suit.SPADES), new Card(Rank.ACE, Suit.SPADES), new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.CLUBS), new Card(Rank.FOUR, Suit.CLUBS),
    new Card(Rank.FIVE, Suit.CLUBS), new Card(Rank.SIX, Suit.CLUBS), new Card(Rank.SEVEN, Suit.CLUBS), new Card(Rank.EIGHT, Suit.CLUBS), new Card(Rank.NINE, Suit.CLUBS), new Card(Rank.TEN, Suit.CLUBS), new Card(Rank.JACK, Suit.CLUBS),
    new Card(Rank.QUEEN, Suit.CLUBS), new Card(Rank.KING, Suit.CLUBS), new Card(Rank.ACE, Suit.CLUBS), new Card(Rank.TWO, Suit.HEARTS), new Card(Rank.THREE, Suit.HEARTS), new Card(Rank.FOUR, Suit.HEARTS), new Card(Rank.FIVE, Suit.HEARTS),
    new Card(Rank.SIX, Suit.HEARTS), new Card(Rank.SEVEN, Suit.HEARTS), new Card(Rank.EIGHT, Suit.HEARTS), new Card(Rank.NINE, Suit.HEARTS), new Card(Rank.TEN, Suit.HEARTS), new Card(Rank.JACK, Suit.HEARTS), new Card(Rank.QUEEN, Suit.HEARTS),
    new Card(Rank.KING, Suit.HEARTS), new Card(Rank.ACE, Suit.HEARTS)));

    List<Card> actual = testDeck.getCards();
    Assert.assertTrue(testDeck.equals(expected));
    }*/
}



