
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private ArrayList<Card> playerHand;
    private String status;

    public Player(String name){
        this.name = name;
        this.playerHand = new ArrayList<Card>();
        this.status = "Playing";
    }

    public String getName() {
        return this.name;
    }

    public void receiveCard(Card card){
        playerHand.add(card);
    }

    public void receiveHand(Hand hand){
        Card card = hand.removeCard();
        playerHand.add(card);
    }

    public int getPlayerHandSize(){
        return this.playerHand.size();
    }

    public int getHandCardValue(){
        int total = 0;
        for (Card card : this.playerHand){
            total += card.getValueFromEnum();
        }
        if(this.hasAce()){
            if( (total + 10) < 22 ){
                total += 10;
                if(total == 21 & this.playerHand.size() == 2){
                    this.setStatus("Blackjack");
                }
            }


        }

        return total;
    }

    public void displayPlayersCurrentCards(){
        System.out.println(this.getName() + ":");
        System.out.println("");
        System.out.println("");
        System.out.println(this.getName() + " has " + this.getHandCardValue() + " points.");
        if(this.getHandCardValue() > 21){
            System.out.println("Oh no, bust!");
        }
        System.out.println("");
    }

    public String getPlayerNameFromScanner(){
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }

    public Player createPlayer(){
        String name = getPlayerNameFromScanner();
        return new Player(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public char decideNextMove(){
        Scanner scanner = new Scanner(System.in);
        char move = 'x';
        int times = 0;

        if(this.getName() == "Dealer"){
            if (this.getHandCardValue() < 17) {
                move = '1';

            }

            if (this.getHandCardValue() <= 21 && this.getHandCardValue() > 16) {
                move = '0';
                this.setStatus("Stick");
            }

            if (this.getHandCardValue() > 21) {
                this.setStatus("Bust");
                System.out.println("The Dealer's hand is " + this.getStatus() + "!");
            }

        }

                if(this.getName() != "Dealer") {

            if (this.getHandCardValue() < 21) {
                System.out.println(this.getName() + " you have " + this.getHandCardValue() + " points. Type 1 to draw another card or 0 to stick.");
                move = scanner.next().charAt(0);
                while (move != '1' & move != '0') {

                    times++;
                    if (times > 2) {
                        System.out.println("Careful now...");
                    }
                    if (move != 'h') {
                        System.out.println(move + " Sorry that's not a valid input, please try again!");
                        System.out.println("Please type 1 to Draw or 0 to Stick");
                        move = scanner.next().charAt(0);
                    }
                    if (move == 'h') {
                        this.displayPlayersCurrentCards();
                        System.out.println("Type 1 to draw or 0 stick");
                        move = scanner.next().charAt(0);

                    }


                }
            } else if (this.getHandCardValue() == 21) {
                System.out.println(this.getName() + " you're on 21 points!");
                move = scanner.next().charAt(0);

            } else if (this.getHandCardValue() > 21) {
                this.setStatus("Bust");
                System.out.println(this.getName() + " hand bust!");

            }

        }
                if(move == '0'){
                    this.setStatus("Stick");
                    System.out.println(this.getName()  + " stuck with " + this.getHandCardValue() + " points");
                }
        if(move == '1'){
            System.out.println(this.getName()  + " decided to draw another card ");
        }
                pressAnyKeyToContinue();
        return move;

    }

    public void pressAnyKeyToContinue()
    {
        System.out.println("Press enter" + "[" + "\u21A9" + "]" + " to continue.");

        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public boolean hasAce() {
        Boolean result = false;
        for(Card card : playerHand){
            if(card.getRank() == RankType.ACE ){
                result = true;
            }
        }
        return result;
    }
}
