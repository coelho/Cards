package cards.api;

import java.util.ArrayList;
import java.util.List;

public class FullCardProvider implements CardProvider {

	public static final FullCardProvider instance = new FullCardProvider();
	private List<Card> cards = new ArrayList<Card>();
	
	private FullCardProvider() {
		for(CardType type : CardType.values()) {
			for(CardSuit suit : CardSuit.values()) {
				this.cards.add(Card.getCard(type, suit));
			}
		}
	}
	
	public List<Card> getCards() { 
		return this.cards;
	}

}
