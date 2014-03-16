package cards.api;

public class SuitCardComparator implements CardComparator {

	public static SuitCardComparator instance = new SuitCardComparator();
	
	private SuitCardComparator() {
		// private
	}
	
	public int compare(Card card, Card card2) {
		if(card.getSuit().getPower() > card2.getSuit().getPower()) {
			return 1;
		}
		if(card.getSuit().getPower() < card2.getSuit().getPower()) {
			return -1;
		}
		return 0;
	}
	
}
