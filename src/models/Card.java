package models;

import models.constants.Point;
import models.constants.Suit;

public class Card {
	
	private Point point;
	private Suit suit;
	
	public void setPoint(Point point) {
		this.point = point;
	}
	
	public Point getPoint(){
		return point;
	}
	
	public void setSuit(Suit suit){
		this.suit = suit;
	}
	
	public Suit getSuit(){
		return suit;
	}

}
