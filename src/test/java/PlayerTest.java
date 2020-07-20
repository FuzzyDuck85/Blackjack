import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PlayerTest {

    Player player;
    Hand hand;
    Deck deck;

    @Before
    public void before(){
        player = new Player("Player1");
        hand = new Hand();
        deck = new Deck();
        deck.addAllCardsToDeck();
    }

    @Test
    public void playerHasName(){
        assertEquals("Player1", player.getName());
    }

    @Test
    public void playerStartsWithNoCardsInHand(){
        assertEquals(0, player.getPlayerHandSize());
    }

    @Test
    public void playerCanReceiveCardsToHand(){
        hand.receiveCard(deck);
        hand.receiveCard(deck);
        player.receiveHand(hand);
        player.receiveHand(hand);
        assertEquals(2, player.getPlayerHandSize());
    }


    @Test
    public void valueOfPlayerHand(){
        hand.receiveCard(deck);
        hand.receiveCard(deck);
        hand.receiveCard(deck);
        player.receiveHand(hand);
        player.receiveHand(hand);
        player.receiveHand(hand);
        assertEquals(6, player.getHandCardValue());
    }
}
