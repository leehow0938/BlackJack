package models;

import models.constants.Role;

import java.util.ArrayList;
import java.util.List;

public class Players {

    // Dealer
    private Player dealer;

    // Players
    private List<Player>  players = new ArrayList<>();

    public Players () {
        dealer = new Player();
        dealer.setRole(Role.DEALER);
        dealer.setName("James");
        dealer.setChips(10000000L);
        dealer.setHandCards(new ArrayList<>());
    }

    public void registerPlayer(String name, long chips) {
        // create player
        Player player = new Player();
        player.setRole(Role.PLAYER);
        player.setName(name);
        player.setChips(chips);
        player.setHandCards(new ArrayList<>());

        // add to players list
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getDealer() {
        return dealer;
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }
}
