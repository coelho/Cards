package cards.api;

public class TypeCardComparator implements CardComparator {

	public static TypeCardComparator instance = new TypeCardComparator();
	
	public int compare(Card card, Card card2) {
		if(card.getType().ordinal() > card2.getType().ordinal()) {
			return 1;
		}
		if(card.getType().ordinal() < card2.getType().ordinal()) {
			return -1;
		}
		return 0;
	}
	
}
