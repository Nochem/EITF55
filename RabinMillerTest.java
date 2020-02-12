package RSAProject;

import java.math.BigInteger;
import java.util.Random;

public class RabinMillerTest {
	private BigInteger ZERO = BigInteger.ZERO, ONE = BigInteger.ONE, TWO = new BigInteger("2");
	private BigInteger s, r;

	public RabinMillerTest() {

	}

	/*
	 * runTest() is made to handle the things that are outside the actual algorithm,
	 * such as random number generation and re-running the algorithm the desired
	 * number of times.
	 */
	public boolean runTest(BigInteger nbrToTest, int times) {
		if (nbrToTest.mod(TWO).equals(ZERO)) {
			//System.out.println("Number given is even.");
			return false;
		} else {
			//Converts the input into the form (2^r) * d + 1.
			BigInteger toFactor = nbrToTest.subtract(ONE);
			s = toFactor;
			r = ZERO;
			//System.out.println("Converts input to (2^r) * d + 1");
			while (s.mod(TWO).equals(ZERO)) {
				r = r.add(ONE);
				s = s.divide(TWO);
			}
		}
		
		//Fills a set with random numbers 2 < a < n - 2
		Random rand = new Random();
		BigInteger[] randomAs = new BigInteger[times];
		//System.out.println("Generating random A:s");
		for (int i = 0; i != times; ++i) {
			BigInteger current = new BigInteger(nbrToTest.subtract(TWO).bitLength(), rand);
			while ((current.compareTo(nbrToTest.subtract(TWO)) > 0) && current.compareTo(TWO) > 0) { //As the random generator cannot accept a upper bound.
				current = new BigInteger(nbrToTest.subtract(TWO).bitLength(), rand);
			}
			randomAs[i] = current;
		}
		
		//Runs the test "times" times, with the set of random numbers.
		//System.out.println("Starting algorithm.");
		for (int t=0; t!=times; ++t) {
			if (!run(nbrToTest, randomAs[t])) { 	 //If run says that nbrToTest is prime in respect to the random number returned from pollfirst,
															//rerun with new random until set is empty. If run says nbrToTest is a composite, return false.
				//System.out.println("Number is a compostie.");
				return false;						
			}
		}
		//System.out.println("Number is probably prime: " + nbrToTest);
		return true;
	}

	/* The algorithm. */
	private boolean run(BigInteger n, BigInteger a) {
		BigInteger x = a.modPow(s, n);
		if (x.compareTo(ONE) == 0 || x.compareTo(n.subtract(ONE)) == 0) {
			return true; // Probably Prime.
		}
		//System.out.println("Testing primality.");
		for (BigInteger j = ONE; j.compareTo(r.subtract(ONE)) < 0; j = j.add(ONE)) {
			// x = a.modPow(TWO.pow(j).multiply(s), n); //Where does j come from? TODO
			x = x.modPow(x, n);
			if (x.equals(ONE)) {
				return false;
			}
			if (x.equals(n.subtract(ONE))) {
				return true;
			}
		}
		return false;
	}
}