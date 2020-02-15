import models.Card;
import models.Cards;
import models.Player;
import models.Players;

import java.util.*;

public class BlackJack {

    private final static int DEFAULT_BET = 10;
    private final static double BLACKJACK_MULTIPLIER = 1.5;
    private final static String YES = "y";
    private int numOfDeck;
    private int numOfPlayer;

    public BlackJack() {

    }

    public BlackJack(int numOfDeck, int numOfPlayer) {
        this.numOfDeck = numOfDeck;
        this.numOfPlayer = numOfPlayer;
    }

    public void start() {
        Cards cards = new Cards(numOfDeck);

        // print shuffle results and deck size
//        for(Card a : cards.getAllCards()) {
//            System.out.println(String.format("%s %s", a.getSuit().getDisplayName(), a.getPoint().getValue()));
//        }

        Players players = new Players();
        players.registerPlayer("Hao", 100000L);
        players.registerPlayer("Tim", 100000L);

        System.out.println("[Game start]:");

        boolean continueGame = false;
        int headPointer = 0;
        do {
            System.out.println("==========================================");
            System.out.println(String.format("Dealer name: %s Role: %s Chips: %d",
                    players.getDealer().getName(),
                    players.getDealer().getRole(),
                    players.getDealer().getChips()));

            System.out.println(String.format("Player name: %s Role: %s Chips: %d",
                    players.getPlayers().get(0).getName(),
                    players.getPlayers().get(0).getRole(),
                    players.getPlayers().get(0).getChips()));

            System.out.println(String.format("Player name: %s Role: %s Chips: %d",
                    players.getPlayers().get(1).getName(),
                    players.getPlayers().get(1).getRole(),
                    players.getPlayers().get(1).getChips()));

            // distribute cards
            List<Card> allCards = cards.getAllCards();
            for (int i = 0; i < 2; i++) {
                for (Player player : players.getPlayers()) {
                    List<Card> handCards = player.getHandCards();
                    handCards.add(allCards.get(headPointer ++));
                }
                players.getDealer().getHandCards().add(allCards.get(headPointer ++));
            }

            // show Dealer hands
            Player dealer = players.getDealer();
            System.out.println("dealer: " + dealer.getName());
            Card dealerFirstCard = dealer.getHandCards().get(0);
            System.out.println(String.format(" %s %s", dealerFirstCard.getSuit().getDisplayName(), dealerFirstCard.getPoint().getDisplayName()));
            // ask
            Scanner in = new Scanner(System.in);
            for (Player player : players.getPlayers()) {
                System.out.println("player: " + player.getName());
                showPlayerHandCards(player);

//                System.out.println("Please answer: ");
//                String answer = in.nextLine();
                // H (Hit) == "y", S (Stand) = "n"
                String answer = checkStrategy(dealerFirstCard.getPoint().getValue(), player.getHandCardsSum());
                while ("Y".equals(answer)) {

                    player.getHandCards().add(allCards.get(headPointer ++));
                    showPlayerHandCards(player);

                    // check if bust
                    int sum = player.getHandCardsSum();

                    if (sum > 21) {
                        System.out.println("Bust!");
                        break;
                    } else if (sum == 21) {
                        System.out.println("21!");
                        break;
                    } else {
                        // if no boommmmm
                        System.out.println("Please answer: ");
                        answer = in.nextLine();
                    }
                }
            }

            // Dealer's turn
            while (dealer.getHandCardsSum() < 17) {
                dealer.getHandCards().add(allCards.get(headPointer ++));
            }

            System.out.println("[Result]:");
            System.out.println("Dealer: " + dealer.getName());
            showPlayerHandCards(dealer);

            // save bet within a map!

            // compare hands: players vs Dealer
            int dealerSum = dealer.getHandCardsSum();
            dealerSum = dealerSum > 21 ? 0 : dealerSum;

            for (Player player : players.getPlayers()) {
                int playerSum = player.getHandCardsSum();
                if (playerSum > 21 || playerSum < dealerSum) {
                    System.out.println(String.format("Player %s lost $%s!", player.getName(), DEFAULT_BET));
                    player.deductChip(DEFAULT_BET);
                    dealer.addChip(DEFAULT_BET);
                } else if (playerSum > dealerSum) {
                    long wonAmount = DEFAULT_BET;
                    if (player.getHandCards().size() == 2 && playerSum == 21) {
                        wonAmount = (new Double(DEFAULT_BET * BLACKJACK_MULTIPLIER)).longValue();
                        System.out.println(String.format("Player %s BlackJack! Won: %s!", player.getName(), wonAmount));
                    } else {
                        System.out.println(String.format("Player %s won $%s!", player.getName(), DEFAULT_BET));
                    }
                    player.addChip(wonAmount);
                    dealer.deductChip(wonAmount);
                } else {
                    System.out.println("Push!");
                }
            }

            // clear all hands
            dealer.clearHandCards();
            for(Player player : players.getPlayers()) {
                player.clearHandCards();
            }

            System.out.print("Play again? ");
            continueGame = YES.equals(in.nextLine());

            // check if cards use up
            if (headPointer > cards.getAllCards().size() - 35) {
                Cards.shuffleCards(cards.getAllCards());
                headPointer = 0;
            }

        } while (continueGame);
        // verify basic strategy

    }

    private void showPlayerHandCards(Player player) {
        for (Card card : player.getHandCards()) {
            System.out.print(String.format("%s %s ", card.getSuit().getDisplayName(),
                    card.getPoint().getDisplayName()));
        }
        System.out.println("Total: " + player.getHandCardsSum());
    }

    private String checkStrategy(int dealerFirstCard, int playerSum) {
        String strategy[][]= new String[21][10];
        for(playerSum=1; playerSum<22; playerSum++){
            for(dealerFirstCard=1; dealerFirstCard<11; dealerFirstCard++){
                if(playerSum<=11){
                    strategy[playerSum][dealerFirstCard]="Y";
                }
                else if(playerSum==12 && (dealerFirstCard==4||dealerFirstCard==5||dealerFirstCard==6)){
                    strategy[playerSum][dealerFirstCard]="N";
                }
                else if(playerSum>=13 && (dealerFirstCard>=2 && dealerFirstCard<=6)){
                    strategy[playerSum][dealerFirstCard]="N";
                }
                else if(playerSum==17){
                    strategy[playerSum][dealerFirstCard]="N";
                }
                else{
                    strategy[playerSum][dealerFirstCard]="Y";
                }
            }
        }
        return strategy[playerSum][dealerFirstCard];
    }
}
