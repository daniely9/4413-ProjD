package model;

import java.math.BigInteger;
import java.util.Random;

import projA.*;

public class Engine {
	private static Engine instance = null;
	public static final double BITS_PER_DIGIT = 3.0;
	public static final Random RNG = new Random();

	private Engine() {
	}

	public synchronized static Engine getInstance() {
		if (instance == null)
			instance = new Engine();
		return instance;
	}

	public String doPrime(String lower, String upper) throws Exception {

		try {
			int low = Integer.parseInt(lower);
			int high = Integer.parseInt(upper);
			System.out.println(low + " " + high);
			if (low < 0) {
				throw new Exception("start < 0:" + low);
			} else if (low >= high) {
				throw new Exception("No more primes in range.");
			} else {
				BigInteger result = BigInteger.valueOf((long) low).nextProbablePrime();
				if (result.intValue() >= high) {
					throw new Exception("No more primes in range.");
				} else {
					return (result.toString());
				}
			}
		} catch (Exception e) {
			throw new Exception("The entry must be int!");
		}
	}

}
