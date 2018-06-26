package com.firsttime.war;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static com.firsttime.war.Rank.*;
import static com.firsttime.war.Suit.*;

public class CardTest {
    //rank then suit 2 through ace
    //suit diamonds D spades S clubs C heart H

    Card happyPath, dup, lowestVal, difRankSameSuit, sameRankDifSuit, nullCard;


    @Before
    public void setUpBefore() {
        happyPath = new Card(ACE, CLUBS);
        dup = new Card(ACE, CLUBS);
        lowestVal = new Card(TWO, HEARTS);
        difRankSameSuit = new Card(TWO, CLUBS);
        sameRankDifSuit = new Card(ACE, HEARTS);

    }

    @Test(expected = NullPointerException.class)
    public void constructor_nullSuitOrRank_IllegalArgumentException() {
        Card nullCard = new Card(null, null);
    }

    @Test
    public void getCardSuit_returnsSuitName() {
        Suit expected = CLUBS;
        Suit actual = happyPath.getSuit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardSuitLetter_returnsFirstLetterOfSuit() {
        String expected = "C";
        String actual = happyPath.getSuitLetter();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardRank_returnsRankName() {
        Rank expected = ACE;
        Rank actual = happyPath.getRank();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardRankLetter_returnsFirstLetterOfSuit() {
        String expected = "A";
        String actual = happyPath.getRankLetter();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardPoints_returnsPointValueOfCard() {
        Integer expected = 14;
        Integer actual = happyPath.getCardPoints();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCard_returnsNameShortHandOfCard() {
        String expected = "AC";
        String actual = happyPath.getCard();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareTo_AreCardsEqual_Return0forTrue() {
        int expected = 0;
        Card card1 = happyPath;
        Card card2 = dup;
        int actual = card1.compareTo(card2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareTo_IsCard1ValueHigher_Return1forTrue() {
        int expected = 1;
        Card card1 = happyPath;
        Card card2 = lowestVal;
        int actual = card1.compareTo(card2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareTo_IsCard1ValueLower_ReturnNeg1forTrue() {
        int expected = -1;
        Card card1 = lowestVal;
        Card card2 = happyPath;
        int actual = card1.compareTo(card2);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void compareTo_null_IllegalArgumentException() {
        Card card1 = happyPath;
        Card card2 = new Card(null, null);
        int actual = card1.compareTo(card2);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void isSameSuit_AreSuitsOfCardEqual_True() {
        Card card1 = happyPath;
        Card card2 = dup;
        boolean actual = card1.isSameSuit(card2);
        Assert.assertTrue(actual);
    }

    @Test
    public void isSameSuit_AreSuitsOfCardEqual_False() {
        Card card1 = happyPath;
        Card card2 = sameRankDifSuit;
        boolean actual = card1.isSameSuit(card2);
        Assert.assertFalse(actual);
    }


    @Test
    public void isSameRank_AreRanksOfCardEqual_True() {
        Card card1 = happyPath;
        Card card2 = dup;
        boolean actual = card1.isSameRank(card2);
        Assert.assertTrue(actual);
    }


    @Test
    public void isSameRank_AreRanksOfCardEqual_False() {
        Card card1 = happyPath;
        Card card2 = difRankSameSuit;
        boolean actual = card1.isSameRank(card2);
        Assert.assertFalse(actual);
    }

    @Test
    public void testToString() {
        String expected = "Ace of Clubs";
        String actual = happyPath.toString();
        Assert.assertEquals(expected, actual);
    }
}