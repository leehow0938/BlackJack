import models.Card;
import models.Player;
import models.constants.Point;
import models.constants.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackJack {
    private int numOfDeck;
    private int numOfPlayer;

    public BlackJack() {}

    public BlackJack(int numOfDeck, int numOfPlayer) {
        this.numOfDeck = numOfDeck;
        this.numOfPlayer = numOfPlayer;
    }

    public void start() {
        //		Card card=new Card();
        Player player = new Player();

        List<Card> cardList = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Point point : Point.values()) {
                Card card = new Card();
                card.setPoint(point);
                card.setSuit(suit);

                cardList.add(card);
            }
        }

        // shuffle twice
        Collections.shuffle(cardList);
        Collections.shuffle(cardList);

        // print shuffle results and deck size
        for(Card a : cardList) {
            System.out.println(String.format("%s %s", a.getSuit().getDisplayName(), a.getPoint().getValue()));
        }
        System.out.println("size: " + cardList.size());

//        String[] type={"heart","spade","diamond","club"};
//        String[] num={"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
//        String[][] totalCard=new String[4][14];
//
//        int row=(int)(Math.random()*3.0);
//        int line=(int)(Math.random()*13.0+1.0);
//
//        player.setName("LiHao");
//        player.setRole("Dealer");
//        player.setChips(type[row], num[line]);
//
//        for(int i=0;i<4;i++){
//            card.setType(type[i]);
//            totalCard[i][0]=card.getType();
//
//            for(int j=1;j<14;j++){
//                card.setNum(num[j]);
//                totalCard[i][j]=card.getNum();
//            }
//        }
//
//        for(int i=0;i<4;i++){
//            for(int j=0;j<14;j++){
//                System.out.print(totalCard[i][j]);
//            }
//            System.out.println();
//        }
//
//        System.out.println(player.getName());
//        System.out.println(player.getRole());
//        System.out.println(player.getChips());
    }
}
