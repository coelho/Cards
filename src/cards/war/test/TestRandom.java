package cards.war.test;

import java.util.Random;

import cards.war.WarRandom;

public class TestRandom {

	// 3000 Integers/s on an i7-4770k
	public static void main(String[] args) {
		WarRandom warRandom = new WarRandom(new Random());
		long startTime = System.currentTimeMillis();
		int amount = 0;
		while(true) {
			warRandom.nextInt();
			amount++;
			if(System.currentTimeMillis() - startTime < 1000L) {
				continue;
			}
			System.out.println(amount + " Integers/s");
			startTime = System.currentTimeMillis();
			amount = 0;
		}
	}

}
