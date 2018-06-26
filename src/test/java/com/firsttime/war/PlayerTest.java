package com.firsttime.war;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlayerTest {

    private Player testPlayer;

    @Before
    public void setUpBefore() {
        testPlayer = new Player("Katrina");
    }

    @Test
    public void getName_returnsPlayerName() {
        //Player testPlayer = new Player("Katrina");
        String expected = "Katrina";
        String actual = testPlayer.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setName_updatesPlayerName() {
        String expected = "Susan";
        testPlayer.setName("Susan");
        String actual = testPlayer.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHand_returnsPlayerHand() {
        Hand expected = new Hand();
        testPlayer.setHand(expected);
        Hand actual = testPlayer.getHand();
        Assert.assertEquals(expected, actual);
    }
}

