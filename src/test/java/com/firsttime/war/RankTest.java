package com.firsttime.war;

import org.junit.Assert;
import org.junit.Test;

import static com.firsttime.war.Rank.ACE;
import static com.firsttime.war.Rank.TWO;

public class RankTest {

    @Test
    public void getRankName_returnTitleCaseOfRank() {
        String expected = "Two";
        String actual = TWO.getRankName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPointValue_returnNumValueOfRank() {
        int expected = 2;
        int actual = TWO.getPointValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toString_returnFirstLetterOfWordRank() {
        String expected = "A";
        String actual = ACE.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toString_returnNumValueAsString() {
        String expected = "2";
        String actual = ACE.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stringToEnum_returnsEnumConstantOfStringValue() {
        Rank expected = ACE;
        Rank actual = Rank.valueOf("ACE");
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void enumName_returnsEnumNameAsString() {
        String expected = "FIVE";
        String actual = Rank.FIVE.name();
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void toString_overriden_nameAndToStringNotEqual() {
        String expected = ACE.toString();
        String actual = ACE.name();
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void enumOrdinal_returnsCorrectIndexOfRank() {
        int expected = 1;
        int actual = Rank.THREE.ordinal();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void enumContains_allRankValuesExpected() {
        Rank[] expected = {Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN,
                Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE};
        Rank[] actual = Rank.values();
        Assert.assertArrayEquals(expected, actual);
    }

}


