package cards.api;

public class TypeSuitCardComparator implements CardComparator {

	public static TypeSuitCardComparator instance = new TypeSuitCardComparator();
	
	private TypeSuitCardComparator() {
		// private
	}
	
	public int compare(Card card, Card card2) {
		if(card.getType().getPower() > card2.getType().getPower()) {
			return 1;
		}
		if(card.getType().getPower() < card2.getType().getPower()) {
			return -1;
		}
		if(card.getSuit().getPower() > card2.getSuit().getPower()) {
			return 1;
		}
		if(card.getSuit().getPower() < card2.getSuit().getPower()) {
			return -1;
		}
		return 0;
	}

}
