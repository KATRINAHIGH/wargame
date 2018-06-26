package com.firsttime.war;

/**
 * Representation of the 13 possible ranks in a standard deck of cards.
 * Where 2 is the lowest value and Ace is the highest value
 */
public enum Rank {
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace",14);

    private String rankName;
    private int pointValue;

    Rank (String rankName, int pointValue) {
        this.pointValue = pointValue;
        this.rankName = rankName;
    }

    /**
     * example ACE = Ace
     * @return longHand of rank
     */
    public String getRankName() {
        return this.rankName;
    }

    /**
     * example ACE = 14
     * @return int rank from 2 to 14
     */
    public int getPointValue() {
        return this.pointValue;
    }

    /**
     * example ACE = A
     * @return shortHand of rank
     */
    @Override
    public String toString() {
        if(this.getPointValue() > 10){
            return this.getRankName().substring(0,1);
        }
        return String.valueOf(this.getPointValue());
    }

}
