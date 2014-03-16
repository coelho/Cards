package cards.war.test;

import java.util.Random;

import cards.war.War;

public class TestPlay {

	public static void main(String[] args) {
		new War(new Random(), true).execute();
	}
	
}
