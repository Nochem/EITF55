package RSAProject;

import java.math.BigInteger;
import java.util.Random;

//import java.util.Scanner;

public class main {
	public static void runRabinMiller() {
		int primesDesired = 100; //Only set to 1 for development and testing. See assignment. TODO
		int numberOfPrimes = 0, notPrimes = 0;
		Random rand = new Random();
		RabinMillerTest test = new RabinMillerTest();
		BigInteger[] primes = new BigInteger[primesDesired]; 
		while (numberOfPrimes < primesDesired) { 
			BigInteger number = new BigInteger(2048, rand);
			if (test.runTest(number, 20)) { //Where 20 is the number of runs as per assignment. set to 1 for testing. TODO
				primes[numberOfPrimes] = number;
				++numberOfPrimes;
			} else {
				++notPrimes;
			}
		}
		System.out.println("Number of primes found: " + numberOfPrimes);
		System.out.println("Number of composites found: " + notPrimes);
		System.out.println("Prime dump:");
		for (int i = 0; i != primes.length; ++i) {
			System.out.println(primes[i].toString());
		}
	}
	
	public static void runSimpleEuclidan() {
		BigInteger p = new BigInteger("7549756113064360138535608122553947087224868028403471891795544787396066857286199765127658605288055704404129638481871127763603874258630322994323248652461431");
		BigInteger q = new BigInteger("5244905553831700672307896136918618965754314212732245195994029480133130225458860507918079124557134946385917747329268333911166045326962153306962234797316419");
		SimpleEuclidean euc = new SimpleEuclidean(p, q);
	}
	
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		//runRabinMiller();
		runSimpleEuclidan();
		long time2 = System.currentTimeMillis();
		System.out.println("Computation took " + (time2-time1) + " milliseconds.");
	}
}