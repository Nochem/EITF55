package RSAProject;

import java.math.BigInteger;
import java.util.Random;

//import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		int primesDesired = 1; //Only set to 1 for development and testing. See assignment. TODO
		int numberOfPrimes = 0;
		Random rand = new Random();
		RabinMillerTest test = new RabinMillerTest();
		BigInteger[] primes = new BigInteger[primesDesired]; 
		while (numberOfPrimes < primesDesired) { 
			BigInteger number = new BigInteger(512, rand);
			
			if (test.runTest(number, 20)) { //Where 20 is the number of runs as per assignment. set to 1 for testing. TODO
				primes[numberOfPrimes] = number;
				numberOfPrimes++;
			}
		}
		long time2 = System.currentTimeMillis();
		System.out.println("Number of primes found: " + numberOfPrimes);
		System.out.println("Computation took " + (time2-time1) + " milliseconds.");
		System.exit(0);
	}
}