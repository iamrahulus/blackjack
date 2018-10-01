package model;

import java.util.Random;

import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard {

	private static Random random = new Random();

	private PlayingCard.Value value;

	private PlayingCard.Suit suit;

	public PlayingCardImpl(PlayingCard.Value value, PlayingCard.Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	@Override
	public Suit getSuit() {
		// TODO Auto-generated method stub
		return this.suit;
	}

	@Override
	public Value getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		if (this.getValue() == Value.ACE)
			return 1;
		if (this.getValue() == Value.EIGHT)
			return 8;
		if (this.getValue() == Value.SEVEN)
			return 7;
		if (this.getValue() == Value.FIVE)
			return 5;
		if (this.getValue() == Value.FOUR)
			return 4;
		if (this.getValue() == Value.TEN || this.getValue() == Value.JACK
				|| this.getValue() == Value.KING
				|| this.getValue() == Value.QUEEN)
			return 10;
		if (this.getValue() == Value.NINE)
			return 9;
		if (this.getValue() == Value.SIX)
			return 6;
		if (this.getValue() == Value.THREE)
			return 3;
		if (this.getValue() == Value.TWO)
			return 2;
		return 0;
	}

	@Override
	public boolean equals(PlayingCard card) {
		// TODO Auto-generated method stub
		if (card.getSuit() == this.getSuit()
				&& card.getScore() == this.getScore())
			return true;
		return false;
	}
}