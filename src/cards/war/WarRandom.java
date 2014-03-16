package cards.war;

import java.util.Random;

/**
 * 
 * This class may be biased towards certain numbers
 * for being crudely implemented, but otherwise it
 * provides entropy over an existing random object
 * 
 * Don't use this in production!
 * 
 * @author coelho
 *
 */
public class WarRandom extends Random {
	
	private static final long serialVersionUID = 1L;

	private War war;
	
	public WarRandom(Random seeder) {
		this.war = new War(seeder, false);
	}
	
	@Override
	protected int next(int bits) {
		long nextseed = 0;
		long bit = 1;
		for(int i = 0; i < bits; i++) {
			if(this.war.execute() == 1) {
				nextseed |= bit;
			}
			bit *= 2;
		}
		nextseed &= (1L << 48) - 1;
		return (int) nextseed;
	}

}
