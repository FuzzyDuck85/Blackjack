import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Player player1;
    Player player2;
    Hand hand;
    Deck deck;
    Card card1;
    Card card2;

    @Before
    public void before(){
        game = new Game("Highest Value");
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        hand = new Hand();
        deck = new Deck();
        deck.addAllCardsToDeck();
    }

    @Test
    public void gameInitialisesWithNoPlayers(){
        assertEquals(0, game.getAmountOfPlayers());
    }

    @Test
    public void gameCanAddPlayers(){
        game.addPlayers(player1);
        game.addPlayers(player2);
        assertEquals(2, game.getAmountOfPlayers());
    }

    @Test
    public void gameDealsCardsToOnePlayersHand(){
        game.addPlayers(player1);
        game.addPlayers(player2);
        game.dealCard(hand, deck);
        game.dealCard(hand, deck);
        assertEquals(2, player1.getPlayerHandSize());
        assertEquals(2, player2.getPlayerHandSize());
    }

    @Test

    public void canDisplayValueOfPlayerHand(){
        game.addPlayers(player1);
        game.addPlayers(player2);
        game.dealCard(hand, deck);
        game.dealCard(hand, deck);
        assertEquals(4, player1.getHandCardValue());
        assertEquals(6, player2.getHandCardValue());
    }

    @Test
    public void whichPlayerHasHighestHandValue(){
        game.addPlayers(player1);
        game.addPlayers(player2);
        game.dealCard(hand, deck);
        game.dealCard(hand, deck);
        player1.getHandCardValue();
        player2.getHandCardValue();
        assertEquals("Player2 is the winner, with a hand value of 6!!!", game.comparePlayerHands());
    }

    @Test
    public void gameIsADraw(){
        game.addPlayers(player1);
        game.addPlayers(player2);
        Card card1 = new Card(SuitType.HEARTS, RankType.QUEEN);
        Card card2 = new Card(SuitType.DIAMONDS, RankType.QUEEN);
        player1.receiveCard(card1);
        player2.receiveCard(card1);
        player1.getHandCardValue();
        player1.getHandCardValue();
        assertEquals("Sorry, it's a draw", game.comparePlayerHands());
    }

//    @Test
//    public void canGetNumberOfPlayers() {
//        assertEquals(2, );
//    }
}
