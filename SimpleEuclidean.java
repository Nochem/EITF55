
import java.math.BigInteger;
import java.util.Random;

public class SimpleEuclidean {
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger ZERO = BigInteger.ZERO;

	public SimpleEuclidean(BigInteger a, BigInteger m) {
		BigInteger d1 = new BigInteger(
				"7549756113064360138535608122553947087224868028403471891795544787396066857286199765127658605288055704404129638481871127763603874258630322994323248652461431");
		BigInteger d2 = new BigInteger(
				"5244905553831700672307896136918618965754314212732245195994029480133130225458860507918079124557134946385917747329268333911166045326962153306962234797316419");
		BigInteger e = new BigInteger("2");
		e = e.pow(16).add(ONE);
		System.out.println("e; " + e.toString());
		BigInteger inverse = run(e, d1.subtract(ONE).multiply(d2.subtract(ONE)));

		// The encryption
		BigInteger N = d1.multiply(d2);
		Random rand = new Random();
		BigInteger s = new BigInteger(N.bitLength(), rand);
		while ((s.compareTo(N) >= 0) || s.compareTo(ONE) <= 0) { // As the random generator cannot accept a upper bound.
			s = new BigInteger(N.bitLength(), rand);
		}
		System.out.println("s: " + s.toString());
		BigInteger c = s.modPow(e, N);
		System.out.println("c: " + c.toString());
		BigInteger z = c.modPow(inverse, N);
		System.out.println("z: " + z.toString());

	}

	private BigInteger run(BigInteger d1, BigInteger d2) {
		BigInteger t1 = ONE, t2 = ZERO, q, v1 = ZERO, v2 = ONE;
		while (!d2.equals(ZERO)) {
			q = d1.divide(d2);
			d1 = d1.mod(d2);
			t1 = t1.subtract(q.multiply(t2));
			v1 = v1.subtract(q.multiply(v2));
			q = d2.divide(d1);
			d2 = d2.mod(d1);
			t2 = t2.subtract(q.multiply(t1));
			v2 = v2.subtract(q.multiply(v1));
		}
		System.out.println("v: " + v1.toString());
		System.out.println("d: " + d1.toString());
		System.out.println("Inverse: " + t1.toString());
		return t1;

	}
}