import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {
    Deck deck;
    Card card;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckStartEmpty(){
        assertEquals(0, deck.getDeckSize());
    }

    @Test
    public void canAddCardToDeck() {
        card = new Card(SuitType.HEARTS, RankType.QUEEN);
        deck.addCardToDeck(card);
        assertEquals(1, deck.getDeckSize());
    }

    @Test
    public void canAddAllCardsToDeck(){
        deck.addAllCardsToDeck();
        assertEquals(52, deck.getDeckSize());
    }

    @Test
    public void canGetCardByIndex(){
        deck.addAllCardsToDeck();
        assertEquals(SuitType.DIAMONDS, deck.checkCardByIndex(13).getSuit());
        assertEquals(SuitType.HEARTS, deck.checkCardByIndex(1).getSuit());
        assertEquals(SuitType.SPADES, deck.checkCardByIndex(26).getSuit());
        assertEquals(SuitType.CLUBS, deck.checkCardByIndex(39).getSuit());
        assertEquals(1, deck.checkCardByIndex(13).getRank().getValue());
        assertEquals(1, deck.checkCardByIndex(0).getRank().getValue());
        assertEquals(1, deck.checkCardByIndex(26).getRank().getValue());
        assertEquals(1, deck.checkCardByIndex(39).getRank().getValue());
    }

//    @Test
//    public void canReturnFullDeck(){
//        deck.addAllCardsToDeck();
//        System.out.println(Arrays.toString(SuitType.values(), RankType.values()));
//        assertEquals(52, deck.getDeck().size());
//    }

    @Test
    public void canShuffleDeck(){
        deck.addAllCardsToDeck();
        assertEquals(1, deck.checkCardByIndex(13).getRank().getValue());
        deck.shuffleDeck();
        assertNotEquals(1, deck.checkCardByIndex(13).getRank().getValue());

    }

}
