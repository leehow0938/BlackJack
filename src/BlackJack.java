import models.Card;
import models.Cards;
import models.Player;
import models.constants.Point;
import models.constants.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackJack {
    private int numOfDeck;
    private int numOfPlayer;

    public BlackJack() {

    }

    public BlackJack(int numOfDeck, int numOfPlayer) {
        this.numOfDeck = numOfDeck;
        this.numOfPlayer = numOfPlayer;
    }

    public void start() {
        //		Card card=new Card();
        Player player = new Player();

        List<Card> cardList = new ArrayList<>();
        Cards cards = new Cards(numOfDeck);


        // print shuffle results and deck size
        for(Card a : cards.getAllCards()) {
            System.out.println(String.format("%s %s", a.getSuit().getDisplayName(), a.getPoint().getValue()));
        }
        System.out.println("size: " + cardList.size());




    }
}
