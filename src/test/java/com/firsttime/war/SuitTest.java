package com.firsttime.war;

import org.junit.Assert;
import org.junit.Test;

public class SuitTest {

    @Test
    public void getSymbol_returnsFirstLetterOfSuit() {
        String expected = "C";
        String actual = Suit.CLUBS.getSymbol();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSuitName_returnsTitleCaseOfSuit() {
        String expected = "Hearts";
        String actual = Suit.HEARTS.getSuitName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toString_returnsFirstLetterOfSuit() {
        String expected = "C";
        String actual = Suit.CLUBS.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void enumOrdinal_returnsCorrectIndexOfSuit() {
        int expected = 2;
        int actual = Suit.CLUBS.ordinal();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void enumContains_allSuitValuesExpected() {
        Suit[] expected = {Suit.DIAMONDS, Suit.SPADES, Suit.CLUBS, Suit.HEARTS};
        Suit[] actual = Suit.values();
        Assert.assertArrayEquals(expected, actual);
    }

}

