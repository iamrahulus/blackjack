package model;

import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard {

	private PlayingCard.Value value;

	private PlayingCard.Suit suit;

	public PlayingCardImpl(PlayingCard.Value value, PlayingCard.Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	@Override
	public Suit getSuit() {
		return this.suit;
	}

	@Override
	public Value getValue() {
		return this.value;
	}

	@Override
	public int getScore() {
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
		if (card.getSuit() == this.getSuit()
				&& card.getScore() == this.getScore())
			return true;
		return false;
	}
}