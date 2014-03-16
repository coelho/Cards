package cards.war.test;

import java.util.Random;

import cards.war.War;

public class TestPlayBenchmark {

	// 97k Games/s on an i7-4770k
	public static void main(String[] args) {
		Random random = new Random();
		long startTime = System.currentTimeMillis();
		int amount = 0;
		while(true) {
			new War(random, false).execute();
			amount++;
			if(System.currentTimeMillis() - startTime < 1000L) {
				continue;
			}
			System.out.println(amount + " Games/s");
			startTime = System.currentTimeMillis();
			amount = 0;
		}
	}

}
