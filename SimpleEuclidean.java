package RSAProject;

public class SimpleEuclidean {

}
/*
 * m = (p - 1)(q - 1)
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