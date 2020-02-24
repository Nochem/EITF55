import java.math.BigInteger;
import java.util.Random;
import java.util.ArrayList;


public class main {
	
	public static BigInteger[] runRabinMiller(ArrayList<timekeeping> timekeeper) {
		int primesDesired = 2; //Set to 2 for use in the SimpleEuclidean algorithm.
		int numberOfPrimes = 0, notPrimes = 0;
		Random rand = new Random();
		RabinMillerTest test = new RabinMillerTest();
		BigInteger[] primes = new BigInteger[primesDesired]; 
		while (numberOfPrimes < primesDesired) { 
			BigInteger number = new BigInteger(2048, rand);
			main.timekeeping time = new main.timekeeping();
			timekeeper.add(time);
			if (test.runTest(number, 20, time)) { //Where 20 is the number of runs as per assignment.
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
		return primes;
	}
	
	public static void runSimpleEuclidan(BigInteger[] primes) {
		//BigInteger p = new BigInteger("7549756113064360138535608122553947087224868028403471891795544787396066857286199765127658605288055704404129638481871127763603874258630322994323248652461431");
		//BigInteger q = new BigInteger("5244905553831700672307896136918618965754314212732245195994029480133130225458860507918079124557134946385917747329268333911166045326962153306962234797316419");
		SimpleEuclidean euc = new SimpleEuclidean(primes[0], primes[1]);
	}	
	
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		ArrayList<timekeeping> timekeeper = new ArrayList<timekeeping>();
		BigInteger[] primes = runRabinMiller(timekeeper);
		runSimpleEuclidan(primes);
		long time2 = System.currentTimeMillis();
		long timeTaken = time2-time1;
		System.out.println("Computation took " + timeTaken + " milliseconds in total.");
		timePrintout(timekeeper);
		
		
	}
	
	private static void timePrintout(ArrayList<timekeeping> timekeeper) {
		long convertinput = 0, randomAGeneration = 0, testing = 0;
		for (int i = 0; i != timekeeper.size(); ++i) {
			convertinput += timekeeper.get(i).convertInputEnd - timekeeper.get(i).convertInputStart;
			randomAGeneration += timekeeper.get(i).randomAGenerationEnd - timekeeper.get(i).randomAGenerationStart;
			testing += timekeeper.get(i).testingEnd - timekeeper.get(i).testingStart;
		}
		System.out.println("Out of which " + convertinput + " was spent on converting input into into the form (2^r) * d + 1.");
		System.out.println("And out of which " + randomAGeneration + " was spent on generating random A:s.");
		System.out.println("Finally, " + testing + " was spent on testing the numbers for primality.");
	}
	
	public static class timekeeping {
		public long convertInputStart, convertInputEnd, randomAGenerationStart, randomAGenerationEnd, testingStart, testingEnd;
		public timekeeping() {}
		public void setConvertInputStart(long time) {
			convertInputStart = time;
		}
		public void setConvertInputEnd(long time) { 
			convertInputEnd = time;
		}
		public void setRandomAGenerationStart(long time) { 
			randomAGenerationStart = time;
		}
		public void setRandomAGenerationEnd(long time) { 
			randomAGenerationEnd = time;
		}
	}
}