package oefeningen.sorteeralgoritmes;

import java.util.Random;

public class RandomArrayGenerator {

	/**
	 * This is not OGP, encapsulation is not necessary!
	 */
	public RandomArrayGenerator() {
		
	}
	
	/**
	 * Generates an array to your liking!
	 * @param length
	 * @param low
	 * @param high
	 * @return
	 */
	public int[] getRandomArray(int length, int low, int high) {
		if(low >= high) {
			throw new IllegalArgumentException("double donkey how generate an array when lowest bound is greater than high");
		}
		int counter = 0;
		int[] getArray = new int[length];
		while(counter < length) {
			getArray[counter] = getRandomInt(low, high);
			counter++;
		}
		return getArray;
	}
	
	public int getRandomInt(int low, int high) {
		Random rand = new Random();
		return rand.nextInt(high) + low;
	}
	
}
