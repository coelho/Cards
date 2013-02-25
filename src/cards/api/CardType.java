package cards.api;

public enum CardType {

	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	JACK("J"),
	QUEEN("Q"),
	KING("K"),
	ACE("A");
	
	private String representation;
	
	CardType(String representation) {
		this.representation = representation;
	}
	
	public String getRepresentation() {
		return this.representation;
	}
	
}
