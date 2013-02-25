package cards.api;

public class TypeSuitCardComparator implements CardComparator {

	public static TypeSuitCardComparator instance = new TypeSuitCardComparator();
	
	public int compare(Card card, Card card2) {
		if(card.getType().ordinal() > card2.getType().ordinal()) {
			return 1;
		}
		if(card.getType().ordinal() < card2.getType().ordinal()) {
			return -1;
		}
		if(card.getSuit().ordinal() > card2.getSuit().ordinal()) {
			return 1;
		}
		if(card.getSuit().ordinal() < card2.getSuit().ordinal()) {
			return -1;
		}
		return 0;
	}

}
