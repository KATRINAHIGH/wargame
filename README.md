# War of Cards

This game is a project created for Deacom as part of their hiring process. It’s purpose is to show my 
understanding of OOP principles by modelling objects from the real world. For example, a Deck consists
 of several Card objects and a Game is played with a Deck.

## This is how the game works:
This is how the game works:
War is a card game for two players. A standard deck of 52 cards is dealt so that both players have 26 
cards. In war, each card generally has one of thirteen possible predetermined values-two through Ace. 
In war, the card’s suite-hearts, diamonds,spades, or clubs, have no impact on the cards value. During 
each round of battle, both players play a card from the top of their hand face up. The player who plays
the card of the higher rank wins both cards and places them at the bottom of his stack of cards. If both
cards played are of the same rank, then War is initiated --both players play three additional cards face 
down and then one more card face up. The player who wins the war by playing the higher card wins all 
eight cards. If the ranks are still the same, additional wars are played until one player wins the turn. 
If either player runs out of cards during war to play, he loses the game. The player that accumulates all 
52 cards leaving an opponent with no cards is the winner. 
Note: it is possible for a Game of war to be infinite. I accounted for this by putting a max limit on the game of 26 rounds. The winner at this point is whomever has the most cards in his/her deck.

## Features
1. Language used Java 8 with IntelliJ IDE
2. Unit tests written with the Junit framework.
3. Build and dependencies managed with Apache Maven.
4. Hosted on GitHub.

## Usage
This game is automated, once started it will run until there is a winner declared. It's you
against the CPU.

* Clone this repo `git clone https://github.com/KATRINAHIGH/wargame.git`
* Copy path to repository and replace `<PATH/TO/REPO>` below
* Run with java: `java -Dfile.encoding=UTF-8 -classpath <PATH/TO/REPO>/target/classes com.firsttime.war.GameRunner`