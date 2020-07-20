import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private String name;
    private ArrayList<Player> players;
    private Player player;
    private ArrayList<Player> winners;

    public Game(String name){
        this.name = name;
        this.players = new ArrayList<Player>();
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public int getAmountOfPlayers(){
        return this.players.size();
    }

    public void addPlayers(Player player){
        this.players.add(player);
    }

    public void dealCard(Hand hand, Deck deck){
        for (Player player : players){
            hand.receiveCard(deck);
            player.receiveHand(hand);
        }
    }

    public void dealSingleCard(Hand hand, Deck deck, Player player){
        hand.receiveCard(deck);
        player.receiveHand(hand);
    }

    public String comparePlayerHands() {
        String winner = null;
        int highest = 0;
        for (Player player : players) {
            if (highest == player.getHandCardValue()) {
                winner = "Sorry, it's a draw";
            } else if (player.getHandCardValue() > highest) {
                highest = player.getHandCardValue();
                winner = player.getName() + " is the winner, with a hand value of " + player.getHandCardValue() + "points.";
            }
        }
            return winner;
        }

        public void decideBlackjackWinner(){
            winners = new ArrayList<Player>();
            int highest = 0;
            for(Player player : players){
                if(player.getStatus() != "Bust"){
                    if(player.getHandCardValue() >= highest) {
                        highest = player.getHandCardValue();
                    }
                }
            }

            for(Player player : players){
                if(player.getStatus() != "Bust"){
                    if(player.getHandCardValue() == highest) {
                        winners.add(player);
                    }
                }
            }

            if(winners.size() == 1){
                System.out.println(winners.get(0).getName() + " is the winner with a score of " + highest);
            }else if(winners.size() > 1){
                System.out.println("We have " + winners.size() + " players on " + highest + " points.");
                for(Player player : winners){
                    System.out.println(player.getName());
                }
            }

        }

        public int getNumberOfPlayers() {
            Scanner myObj = new Scanner(System.in);
            System.out.println("How many people would like to play?");

            int players = myObj.nextInt();
            return players;
        }

        public void displayPlayersCurrentHand(Player player) {
        player.displayPlayersCurrentCards();
        }

            public void pressAnyKeyToContinue()
            {
                System.out.println("Press the enter key" + "[" + "\u21A9" + "]" + " to continue.");
                try
                {
                    System.in.read();
                }
                catch(Exception e)
                {}
            }

    public boolean anyonePlaying() {
        Boolean result = false;
        for(Player person : players){
            if(person.getStatus() == "Playing"){
                result = true;
            }
        }
        return result;
    }
}


