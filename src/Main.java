import java.math.BigInteger;

import problems1to5.EvenFibonacciNumbers;
import problems1to5.LargestPrimeFactor;
import problems1to5.MultiplesOf3And5;


public class Main {

	public static void main(String[] args) {
		
		// 1-5
		// 1. Multiples of 3 and 5 (or any two integers) 
		
		int sum = MultiplesOf3And5.multiplesOfEitherOfTwoFactors(3,5,1000);	
		System.out.println();
		
		// Extended version: User inputs any amount of factors
		// MultiplesOf3And5.severalFactors();
		
		// TODO 1. Apply a sorting algorithm to the resulting array 
			
		
		// 2. Even Fibonacci Numbers
		EvenFibonacciNumbers.fiboArray(4000000);
		
		EvenFibonacciNumbers.fiboArrayCompact(4000000);
		
		
		// TODO 2. How to keep arrays properly sized? 
		
		
		// 3. Largest prime factor
		System.out.println("Largest prime factor: " + LargestPrimeFactor.largest(600851475143L)) ;
		
	}

}
