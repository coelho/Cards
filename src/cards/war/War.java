package cards.war;

import java.util.Random;

import cards.api.Card;
import cards.api.Deck;
import cards.api.TypeCardComparator;

public class War {

	private Deck deckDealer = new Deck();
	private Deck deckOne = new Deck();
	private Deck deckTwo = new Deck();
	private Deck deckOneRisk = new Deck();
	private Deck deckTwoRisk = new Deck();
	private Random random;
	private boolean debug;

	public War(Random random, boolean debug) {
		this.random = random;
		this.debug = debug;
	}

	public int execute() {
		this.deckDealer.fill();
		this.deckDealer.shuffle(this.random);
		if(this.debug) System.out.println("Original Dealer Shuffled: " + this.deckDealer.toString());

		this.deckDealer.dealTop(this.deckOne, this.deckTwo);
		if(this.debug) System.out.println("Original Deck One: " + this.deckOne.toString());
		if(this.debug) System.out.println("Original Deck Two: " + this.deckTwo.toString());
		if(this.debug) System.out.println("----------------------------------------------------------");
		while(!this.deckOne.isEmpty() && !this.deckTwo.isEmpty()) {
			Card card1 = this.deckOne.removeTop();
			Card card2 = this.deckTwo.removeTop();
			int comparison = card1.compare(card2, TypeCardComparator.instance);
			// if the comparison is in deckOne's favor
			if(comparison == 1) {
				// show the risk, and deal it, if there is any
				if(this.deckOneRisk.isEmpty() && this.deckTwoRisk.isEmpty()) {
					if(this.debug) System.out.println(card1.toString() + " vs " + card2.toString() + ": Deck One wins the battle!");
				} else {
					if(this.debug) System.out.println(card1.toString() + " (" + this.deckOneRisk.toString() + ") vs " + card2.toString() + " (" + this.deckTwoRisk.toString() + "): Deck One wins the battle!");
					this.deckOneRisk.dealBottom(this.deckOne);
					this.deckTwoRisk.dealBottom(this.deckOne);
				}
				// give the cards to the winner
				this.deckOne.putBottom(card1);
				this.deckOne.putBottom(card2);
			// if the comparison is in deckTwo's favor
			} else if(comparison == -1) {
				// show the risk, and deal it, if there is any
				if(this.deckOneRisk.isEmpty() && this.deckTwoRisk.isEmpty()) {
					if(this.debug) System.out.println(card1.toString() + " vs " + card2.toString() + ": Deck Two wins the battle!");
				} else {
					if(this.debug) System.out.println(card1.toString() + " (" + this.deckOneRisk.toString() + ") vs " + card2.toString() + " (" + this.deckTwoRisk.toString() + "): Deck Two wins the battle!");
					this.deckOneRisk.dealBottom(this.deckTwo);
					this.deckTwoRisk.dealBottom(this.deckTwo);
				}
				// give the cards to the winner
				this.deckTwo.putBottom(card2);
				this.deckTwo.putBottom(card1);
			// if the comparison is neutral
			} else if(comparison == 0) {
				// show the risk if there is any
				if(this.deckOneRisk.isEmpty() && this.deckTwoRisk.isEmpty()) {
					if(this.debug) System.out.println(card1.toString() + " vs " + card2.toString() + ": Clash!");
				} else {
					if(this.debug) System.out.println(card1.toString() + " (" + this.deckOneRisk.toString() + ") vs " + card2.toString() + " (" + this.deckTwoRisk.toString() + "): Clash!");
				}
				// create a risk for the next hand
				this.deckOneRisk.putBottom(card1);
				this.deckTwoRisk.putBottom(card2);
				int remaining = 3;
				if(this.deckOne.getRemaining() <= remaining) {
					remaining = this.deckOne.getRemaining() - 1;
				}
				if(this.deckTwo.getRemaining() <= remaining) {
					remaining = this.deckTwo.getRemaining() - 1;
				}
				for(int i = 0; i < remaining; i++) {
					this.deckOneRisk.putBottom(this.deckOne.removeTop());
					this.deckTwoRisk.putBottom(this.deckTwo.removeTop());
				}
			}
		}
		if(this.debug) System.out.println("----------------------------------------------------------");
		if(this.deckOne.isEmpty()) {
			if(this.debug) System.out.println("Deck Two has succeeded in war: " + this.deckTwo.toString());
			this.cleanup();
			return 2;
		} else if(this.deckTwo.isEmpty()) {
			if(this.debug) System.out.println("Deck One has succeeded in war: " + this.deckOne.toString());
			this.cleanup();
			return 1;
		}
		throw new RuntimeException();
	}

	private void cleanup() {
		this.deckDealer.empty();
		this.deckOne.empty();
		this.deckTwo.empty();
		this.deckOneRisk.empty();
		this.deckTwoRisk.empty();
	}
	
}
