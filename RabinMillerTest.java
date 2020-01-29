package RSAProject;

import java.math.BigInteger;
import java.util.Random;

import javafx.util.converter.BigIntegerStringConverter;
 
public class RabinMillerTest {
	private BigInteger ZERO = BigInteger.ZERO, ONE = BigInteger.ONE, TEN = BigInteger.TEN, TWO = new BigInteger("2");
	public RabinMillerTest() {		
	
	}
	
	/* runTest() is made to handle the things that are outside the actual algorithm, such as random number generation 
	 * and re-running the algorithm the desired number of times.
	 */
	public boolean runTest(BigInteger nbrToTest, int times) {
		if (nbrToTest.mod(TWO).equals(ZERO)) {
			System.out.println(nbrToTest.toString());
			System.out.println("Number given is even.");
			System.exit(0);
			return false;
		} else {
			//Converts the input into the form (2^r) * d + 1.
			BigInteger toFactor = nbrToTest.subtract(ONE), d = toFactor, r = ZERO;
			while (d.mod(TWO).not().equals(ZERO)) {
				r.add(ONE);
				d = toFactor.divide(TWO);
			}
		}
		
		//Fills a set with random numbers 2 < a < n - 2
		Random rand = new Random();
		BigInteger current = new BigInteger()
		int[] randomInts = new int[times];
		for (int i = 0; i != times; ++i) {
			int current = rand.nextInt(nbrToTest.intValue()-2); //Not sure if the Random class will handle the number coming as upper bound. Test. TODO
			if (current < 3) {
				--i; //This feels like an open invitation to  logical faults. Make sure to rethink this to make sure it's valid. TODO
			} else {
				randomInts[i] = current;
			}
		}
		
		//Runs the test "times" times, with the set of random numbers.
		for (int t=0; t!=times; ++t) {
			if (!run(nbrToTest, (BigInteger)randomInts[t])) { 	 //If run says that nbrToTest is prime in respect to the random number returned from pollfirst,
															//rerun with new random until set is empty. If run says nbrToTest is a composite, return false.
				System.out.println("Number is a compostie.");
				return false;						
			}
		}
		System.out.println("Number is probably prime: " + nbrToTest);
		return true;
	}
	
	
	/* The algorithm. */
	private boolean run(BigInteger n, BigInteger a) {
		System.out.println("Computing: " + n.toString());
		
		
		BigInteger x = a^
		while (s.mod(TWO).equals(BigInteger.ZERO)) {
			++r;
			s = s.divide(TWO);
			
			
		}
		

		// Setting up the numbers to be calculated into BigInteger wrappers
		BigInteger random = new BigInteger(a.toString());
		BigInteger number = new BigInteger(n.toString());		
		BigInteger x = random.modPow(s, number);
		
		
		
		//The actual algorithm
		if (x.equals(BigInteger.ONE) || x.equals(number.subtract(BigInteger.ONE))) {
			return true;
		}
		for (int t = 1; t != r; t++) {
			//System.out.println("Entering first for with r = " + r.toString());
			/* x = x^2
			 * x = 
			 */
			// x = a^((2^t)s) mod n
			//x = random.pow(TWO.pow(t).multiply(ss).intValue()).mod(number);
			x = x.pow(2).mod(number);
			if (x.equals(BigInteger.ONE)) {
				return false;
			}
			if (x.equals(number.subtract(BigInteger.ONE))) {
				return true;
			}
		}
		return false;
	}

	//Random number generator.
	private int generateRandomBase(BigInteger nbr) { //Nbr is included to generate numbers in the 0-nbr span.
		Random rand = new Random();
		int randomNbr = 0;
		while (randomNbr < 1) {
			randomNbr = rand.nextInt(nbr.intValue());
		}
		return randomNbr;
	}
}



