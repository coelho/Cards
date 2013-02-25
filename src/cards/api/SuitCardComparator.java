package cards.api;

public class SuitCardComparator implements CardComparator {

	public static SuitCardComparator instance = new SuitCardComparator();
	
	public int compare(Card card, Card card2) {
		if(card.getSuit().ordinal() > card2.getSuit().ordinal()) {
			return 1;
		}
		if(card.getSuit().ordinal() < card2.getSuit().ordinal()) {
			return -1;
		}
		return 0;
	}
	
}
