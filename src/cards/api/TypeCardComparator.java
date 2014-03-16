package cards.api;

public class TypeCardComparator implements CardComparator {

	public static TypeCardComparator instance = new TypeCardComparator();
	
	private TypeCardComparator() {
		// private
	}
	
	public int compare(Card card, Card card2) {
		if(card.getType().getPower() > card2.getType().getPower()) {
			return 1;
		}
		if(card.getType().getPower() < card2.getType().getPower()) {
			return -1;
		}
		return 0;
	}
	
}
