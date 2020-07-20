import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<Card>();
    }

    // create 52 cards, 4 suits, 13 ranks


    public int getDeckSize() {
        return this.deck.size();
    }

    public void addCardToDeck(Card card){
        this.deck.add(card);
    }

    public void addAllCardsToDeck(){
        //Go through all 4 suits
        for (SuitType suitType : SuitType.values()){
            //iterate through all 13 card types
            for (RankType rankType : RankType.values()) {
                Card card = new Card(suitType, rankType);
                //add each instance to deck
                addCardToDeck(card);
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public Card checkCardByIndex(int index){
        return this.deck.get(index);
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public Card removeCard(){
        return this.deck.remove(0);
    }
}
