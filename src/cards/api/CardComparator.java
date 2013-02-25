package cards.api;

import java.util.Comparator;

public interface CardComparator extends Comparator<Card> {

	public int compare(Card card, Card card2);

}
