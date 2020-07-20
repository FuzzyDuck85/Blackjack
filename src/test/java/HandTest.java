import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {
    Hand hand;
    Deck deck;

    @Before
    public void before(){
        hand = new Hand();
        deck = new Deck();
        deck.addAllCardsToDeck();
    }

    @Test
    public void handStartsEmpty(){
        assertEquals(0, hand.getHandSize());
    }

    @Test
    public void canReceiveCardFromDeck(){
        deck.shuffleDeck();
        hand.receiveCard(deck);
        hand.receiveCard(deck);
        assertEquals(2, hand.getHandSize());
        assertEquals(50, deck.getDeckSize());
    }
}
