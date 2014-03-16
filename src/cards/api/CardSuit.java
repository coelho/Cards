package cards.api;

public class CardSuit {
	
	public static final CardSuit CLUB = new CardSuit("♣", 1);
	public static final CardSuit DIAMOND = new CardSuit("♦", 2);
	public static final CardSuit HEART = new CardSuit("♥", 3);
	public static final CardSuit SPADE = new CardSuit("♠", 4);
	
	private String representation;
	private int power;
	
	public CardSuit(String representation, int power) {
		this.representation = representation;
		this.power = power;
	}
	
	public String getRepresentation() {
		return this.representation;
	}
	
	public int getPower() {
		return this.power;
	}
	
}
