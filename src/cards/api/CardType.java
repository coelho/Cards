package cards.api;

public class CardType {

	public static final CardType TWO = new CardType("2", 1);
	public static final CardType THREE = new CardType("3", 2);
	public static final CardType FOUR = new CardType("4", 3);
	public static final CardType FIVE = new CardType("5", 4);
	public static final CardType SIX = new CardType("6", 5);
	public static final CardType SEVEN = new CardType("7", 6);
	public static final CardType EIGHT = new CardType("8", 7);
	public static final CardType NINE = new CardType("9", 8);
	public static final CardType TEN = new CardType("10", 9);
	public static final CardType JACK = new CardType("J", 10);
	public static final CardType QUEEN = new CardType("Q", 11);
	public static final CardType KING = new CardType("K", 12);
	public static final CardType ACE = new CardType("A", 13);
	
	private String representation;
	private int power;
	
	public CardType(String representation, int power) {
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
