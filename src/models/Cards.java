package models;

import models.constants.Point;
import models.constants.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cards {
    private int decks;
    private List<Card> allCards;

    public Cards(int numbers){
        allCards = new ArrayList<Card>();
        decks = numbers;
        generateCards(numbers);
    }

    public int getDecks() {
        return decks;
    }

    public void setDecks(int decks) {
        this.decks = decks;
    }

    public List<Card> getAllCards() {
        return allCards;
    }

    public void setAllCards(List<Card> allCards) {
        this.allCards = allCards;
    }

    private void generateCards(int numbers){
        for (int i = 0; i < numbers; i++) {
            for (Suit suit : Suit.values()) {
                for (Point point : Point.values()) {
                    Card card = new Card();
                    card.setSuit(suit);
                    card.setPoint(point);
                    allCards.add(card);
                }
            }
        }

        for (int i = 0; i < 9999999; i ++) {
            Collections.shuffle(allCards);
        }
    }
}
