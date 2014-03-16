package cards.api;

public class Card {
	
	// TODO cache
	public static Card forCard(CardType type, CardSuit suit) {
		return new Card(type, suit);
	}
	
	private CardType type;
	private CardSuit suit;
	
	private Card(CardType type, CardSuit suit) {
		this.type = type;
		this.suit = suit;
	}
	
	public int compare(Card card) {
		return TypeSuitCardComparator.instance.compare(this, card);
	}
	
	public int compare(Card card, CardComparator comparator) {
		return comparator.compare(this, card);
	}
	
	public CardType getType() {
		return this.type;
	}
	
	public CardSuit getSuit() {
		return this.suit;
	}
	
	@Override
	public String toString() {
		return this.suit.getRepresentation() + this.type.getRepresentation();
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null) {
			return false;
		}
		if(object == this) {
			return true;
		}
		if(!(object instanceof Card)) {
			return false;
		}
		Card card = (Card) object;
		if(card.getType() != this.type) {
			return false;
		}
		if(card.getSuit() != this.suit) {
			return false;
		}
		return true;
	}
	
}
