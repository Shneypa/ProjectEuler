package problems1to5;

/* 
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.

	What is the largest prime factor of the number 600851475143 ?
 * 
 * 
 */


public class LargestPrimeFactor {
	private static long largestFactor = 0;
	private static long factor = 3;
	
	private static long startTime;
	private static long endTime;
	
	public static long largest(long number) {
		startTime = System.currentTimeMillis();
		
		System.out.println();
		System.out.println("Prime factors of " + number + " : ");
		
		if(number % 2 == 0)  System.out.print(2 + " ");
		
		for (int i = 3; i <= number; i++ )  {
			
			if((number % factor == 0) && isPrime(factor)) {
				System.out.print(factor + " ");
				largestFactor = factor;
				number /= factor;
			}
				
			factor+=2;
			
		}	
		System.out.println();
		endTime = System.currentTimeMillis();
		System.out.println("Time taken in millis: " + (endTime - startTime));
		return largestFactor;
	}
	
	public static boolean isPrime(long number) {
		
		for (int i = 2; i < number; i++) {
			if (number % i == 0) return false;
		} return true;
		
	}
}
