package RSAProject;

import java.math.BigInteger;
import java.util.Random;

//import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		RabinMillerTest test = new RabinMillerTest();
		Random rand = new Random();
		int numberOfPrimes = 0;
		while (numberOfPrimes < 2) {
			BigInteger number = new BigInteger(512, rand);
			
			if (test.runTest(number, 20)) { //Where 20 is the number of runs.
				numberOfPrimes++;
				System.out.println("Number of primes found: " + numberOfPrimes);
			}
		}
		long time2 = System.currentTimeMillis();
		System.out.println("Computation took " + (time2-time1) + " milliseconds.");
		System.exit(0);
	}
}