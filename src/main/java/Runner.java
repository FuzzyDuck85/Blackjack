import java.util.Scanner;

public class Runner {

    private int numberOfPlayers;

    private Game game;
    private Deck deck;
    private Player player;
    private Hand hand;

    public static void main(String[] args) {
        Game game = new Game("Blackjack");
        System.out.println("Hello! Would you like to play" + game.getName() + "?");

        //get number of players
        int numberOfPlayers = game.getNumberOfPlayers();

        System.out.println("Okay, let's play " + game.getName() + " with " + numberOfPlayers + " players!");
        System.out.println("");

        // Make the dealer a player
        Player player = new Player("Dealer");
        game.addPlayers(player);

        //get the names of each player
        for(int i = 0; i < numberOfPlayers; i++ ){
            System.out.println("Please type a name for player " + (i + 1));
//            Player player = new Player("temp");
            player = player.createPlayer();
            game.addPlayers(player);

        }
        System.out.println("");
        System.out.println("Okay! Let's play with " + (game.getAmountOfPlayers() - 1) + " players");

        Deck deck = new Deck();
        deck.addAllCardsToDeck();
        deck.shuffleDeck();
        System.out.println("The deck contains " + deck.getDeckSize() + " shuffled cards");

        Hand hand = new Hand();

        game.dealCard(hand, deck);
        game.dealCard(hand, deck);

        System.out.println("");

        for(Player person : game.getPlayers()){
            game.pressAnyKeyToContinue();
            game.displayPlayersCurrentHand(person);
        }

        game.pressAnyKeyToContinue();

        System.out.println("");
        System.out.println("");

        while(game.anyonePlaying()) {
            for (Player person : game.getPlayers()) {

                if(person.getStatus() == "Playing") {
                    char move = person.decideNextMove();

                    if (person.getName() == "Dealer") {
                        if (move == 'd') {
                            game.dealSingleCard(hand, deck, person);
                            game.displayPlayersCurrentHand(person);

                        }
                    }

                    if (person.getName() != "Dealer") {
                        if(person.getStatus() == "Playing") {

                            game.dealSingleCard(hand, deck, person);
                            game.displayPlayersCurrentHand(person);
                        }
                    }
                }
            }
        }

        game.decideBlackjackWinner();








    }
}
