package models;

import models.constants.Point;
import models.constants.Role;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private Role role;
	private String name;
	private long chips;
	private List<Card> handCards;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getChips() {
		return chips;
	}

	public void setChips(long chip) {
		this.chips = chip;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role){
		this.role = role;
	}

	public List<Card> getHandCards() {
		return handCards;
	}

	public void setHandCards(List<Card> handCards) {
		this.handCards = handCards;
	}

	public void clearHandCards() {
		this.handCards = new ArrayList<>();
	}

	public long addChip(long bet) {
		this.chips += bet;
		return this.chips;
	}

	public long deductChip(long bet) {
		this.chips -= bet;
		return this.chips;
	}

	public int getHandCardsSum() {
		int sum = 0;
		int numOfAces = 0;

		for (Card card : handCards) {
			if (card.getPoint().equals(Point.ACE)) {
				numOfAces ++;
				continue;
			}
			sum += card.getPoint().getValue();
		}

		for (int i = 0; i < numOfAces; i ++) {
			if (sum + 11 > 21) {
				sum += 1;
			} else {
				sum += 11;
			}
		}

		return sum;
	}
}
