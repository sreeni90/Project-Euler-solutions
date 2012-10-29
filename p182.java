/* 
 * Solution to Project Euler problem 182
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */


public final class p182 {
	
	private static int P = 1009;
	private static int Q = 3643;
	private static int TOTIENT = (P - 1) * (Q - 1);
	
	
	public static void main(String[] args) {
		int[] numUnconcealedP = countAllUnconcealed(P);
		int[] numUnconcealedQ = countAllUnconcealed(Q);
		
		int minUnconcealedP = Integer.MAX_VALUE;
		for (int x : numUnconcealedP)
			minUnconcealedP = Math.min(x, minUnconcealedP);
		
		int minUnconcealedQ = Integer.MAX_VALUE;
		for (int x : numUnconcealedQ)
			minUnconcealedQ = Math.min(x, minUnconcealedQ);
		
		long sum = 0;
		for (int e = 0; e < TOTIENT; e++) {
			if (numUnconcealedP[e % (P - 1)] == minUnconcealedP && numUnconcealedQ[e % (Q - 1)] == minUnconcealedQ)
				sum += e;
		}
		System.out.println(sum);
	}
	
	
	private static int[] countAllUnconcealed(int prime) {
		int[] numUnconcealed = new int[prime - 1];
		for (int e = 0; e < numUnconcealed.length; e++) {
			if (Library.gcd(e, prime - 1) == 1)
				numUnconcealed[e] = countUnconcealed(prime, e);
			else
				numUnconcealed[e] = Integer.MAX_VALUE;
		}
		return numUnconcealed;
	}
	
	
	private static int countUnconcealed(int modulus, int e) {
		int count = 0;
		for (int m = 0; m < modulus; m++) {
			if (powMod(m, e, modulus) == m)
				count++;
		}
		return count;
	}
	
	
	private static int powMod(int x, int y, int m) {
		if (y < 0)
			throw new IllegalArgumentException();
		int z = 1;
		for (; y != 0; y >>>= 1, x = (int)((long)x * x % m)) {
			if ((y & 1) != 0)
				z = (int)((long)z * x % m);
		}
		return z;
	}
	
}
