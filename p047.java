/* 
 * Solution to Project Euler problem 47
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */


public final class p047 {
	
	public static void main(String[] args) {
		for (int i = 2; ; i++) {
			if (has4PrimeFactors(i) && has4PrimeFactors(i + 1) && has4PrimeFactors(i + 2) && has4PrimeFactors(i + 3)) {
				System.out.println(i);
				break;
			}
		}
	}
	
	
	private static boolean has4PrimeFactors(int n) {
		return countDistinctPrimeFactors(n) == 4;
	}
	
	
	private static int countDistinctPrimeFactors(int n) {
		int count = 0;
		int end = Library.sqrt(n);
		for (int i = 2; i <= end; i++) {
			if (n % i == 0) {
				do n /= i;
				while (n % i == 0);
				count++;
				end = Library.sqrt(n);
			}
		}
		if (n > 1)
			count++;
		return count;
	}
	
}
