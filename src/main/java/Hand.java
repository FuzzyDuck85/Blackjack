import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> dealerHand;

    public Hand(){
        this.dealerHand = new ArrayList<Card>();
    }

    public int getHandSize() {
        return this.dealerHand.size();
    }

    public void receiveCard(Deck deck){
        Card card = deck.removeCard();
        dealerHand.add(card);
    }

    public Card removeCard(){
        return this.dealerHand.remove(0);
    }
}
