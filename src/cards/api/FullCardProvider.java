package cards.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FullCardProvider implements CardProvider {

	public static final FullCardProvider instance = new FullCardProvider();
	
	private static final CardSuit[] fullSuits = new CardSuit[] { CardSuit.CLUB, CardSuit.DIAMOND, CardSuit.HEART, CardSuit.SPADE };
	private static final CardType[] fullTypes = new CardType[] { CardType.TWO, CardType.THREE, CardType.FOUR, CardType.FIVE, CardType.SIX, CardType.SEVEN, CardType.EIGHT, CardType.NINE, CardType.TEN, CardType.JACK, CardType.QUEEN, CardType.KING, CardType.ACE };
	private static final List<Card> cards = new ArrayList<Card>();
	static {
		for(CardSuit suit : FullCardProvider.fullSuits) {
			for(CardType type : FullCardProvider.fullTypes) {
				FullCardProvider.cards.add(Card.forCard(type, suit));
			}
		}
	}
	
	private FullCardProvider() {
		// private
	}
	
	public List<Card> getCards() { 
		return Collections.unmodifiableList(FullCardProvider.cards);
	}

}
