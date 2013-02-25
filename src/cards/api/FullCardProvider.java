package cards.api;

import java.util.ArrayList;
import java.util.List;

public class FullCardProvider implements CardProvider {

	public static final FullCardProvider instance = new FullCardProvider();
	
	private FullCardProvider() {
		// private
	}
	
	public List<Card> getCards() {
		List<Card> cards = new ArrayList<Card>();
		for(CardType type : CardType.values()) {
			for(CardSuit suit : CardSuit.values()) {
				cards.add(Card.getCard(type, suit));
			}
		}
		return cards;
	}

}
