package com.firsttime.war;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HandTest {

    Hand handTest, handTest2;
    Card testCard1, testCard2, testCard3, testCard4;

    @Before
    public void setUpBefore() {
        handTest = new Hand();
        testCard1 = new Card(Rank.ACE, Suit.SPADES);
        testCard2 = new Card(Rank.KING, Suit.HEARTS);
        testCard3 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        testCard4 = new Card(Rank.JACK, Suit.CLUBS);

        handTest2 = new Hand();
        handTest2.addCardToTop(testCard1);
        handTest2.addCardToTop(testCard2);
        handTest2.addCardToTop(testCard3);
    }

    //testing default value
    @Test
    public void addCardToTop() {
        Card expected = testCard3;
        Card actual = handTest2.removeCardFromTop();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handSize_returnsCountForEmptyHand() {
        int expected = 0;
        int actual = handTest.handSize();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handSize_returnsCountAfterCardsAdded() {
        int expected = 3;
        int actual = handTest2.handSize();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeCardFromBottom() {
        Card expected = testCard1;
        Card actual = handTest2.removeCardFromBottom();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCardToBottom() {
        Card expected = testCard4;
        handTest2.addCardToBottom(testCard4);
        Card actual = handTest2.removeCardFromBottom();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCardsToTop() {
        Card expected = new Card(Rank.SEVEN, Suit.SPADES);
        List<Card> cards = new ArrayList<>(Arrays.asList(
                new Card(Rank.THREE, Suit.DIAMONDS),
                new Card(Rank.TEN, Suit.HEARTS),
                expected
        ));

        handTest2.addCardsToTop(cards);
        Assert.assertEquals(handTest2.handSize(), 6);
        Assert.assertEquals(expected, handTest2.removeCardFromTop());
    }

    @Test
    public void take() {
        List<Card> cards = handTest2.take(2);
        Assert.assertEquals(handTest2.handSize(), 1);
        Assert.assertEquals(cards.get(0), testCard3);
        Assert.assertEquals(cards.get(1), testCard2);
    }
}