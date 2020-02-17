package RSAProject;

import java.math.BigInteger;
import java.util.Random;

public class SimpleEuclidean {
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger ZERO = BigInteger.ZERO;

public SimpleEuclidean(BigInteger a, BigInteger m) {
		BigInteger t; // m, a, d, d1, d2, v, v1, v2, t1, t2, t3;	
		//m = p.subt1ract(ONE).multiply(q.subtract(ONE));
		/*Random rand = new Random();
		a = new BigInteger(512, rand);
		d1 = m;
		d2 = a;
		v1 = ZERO;
		v2 = ONE;*/
		while (!m.equals(ZERO)) {
			t = m;
			m = a.mod(m);
			a = t;
		}
		return a;
	}
	
/*
	public SimpleEuclidean(BigInteger p, BigInteger q) {
		BigInteger s, t, m, a, d, d1, d2, v, v1, v2, t1, t2, t3;
		m = p.subtract(ONE).multiply(q.subtract(ONE));
		Random rand = new Random();
		a = new BigInteger(512, rand);
		d1 = m;
		d2 = a;
		v1 = ZERO;
		v2 = ONE;
		while (!d2.equals(ZERO)) {
			System.out.println(d2.toString());
			System.exit(0);
			s = d1.divide(d2);
			t2 = v1.subtract(s.multiply(v2));
			t3 = d1.subtract(t.multiply(d2)); //q? t? Try to dechipher the assignment. TODO
			v1 = v2; d1 = d2; v2 = t2; d2 = t3;
		}
		v = v1;
		d = d1;
		System.out.println("v and d:");
		System.out.println(v.toString());
		System.out.println(d.toString());
		
	}
}
/*
 * m = (p - 1)(q - 1) //Which is the two primes we generated in the previous
 * For example:7549756113064360138535608122553947087224868028403471891795544787396066857286199765127658605288055704404129638481871127763603874258630322994323248652461431
				5244905553831700672307896136918618965754314212732245195994029480133130225458860507918079124557134946385917747329268333911166045326962153306962234797316419

 * a = random base
 *
//Name: Inverse Mod m
 * //Find v such that d=gcd(a,m)=a x v mod m, if d=1 then v is the
 * //inverse of a modulo m
 * 	d1 = m;
 * 	v1 = 0;
 *  v2 = 1;
 *   d2 = a;
 *   while (d2 != 0){
 *   	q = d1 div d2;
 *   	t2 = v1 - q*v2;
 *   	t3 = d1 - q*d2;
 *   	v1 = v2;
 *   	d1 = d2;
 *   	v2 = t2; 
 *   	d2 = t3;
 *   }
 *   v=v1;
 *   d=d1;
 */
