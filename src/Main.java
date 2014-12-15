import java.math.BigInteger;

import problems1to5.EvenFibonacciNumbers;
import problems1to5.MultiplesOf3And5;


public class Main {

	public static void main(String[] args) {
		
		// 1-5
		// 1. Multiples of 3 and 5 (or any two integers) 
		
		int sum = MultiplesOf3And5.multiplesOfEitherOfTwoFactors(7,11,100);	
		System.out.println();
		
		// Extended version: User inputs any amount of factors
		// MultiplesOf3And5.severalFactors();
		
		// TODO 1. Apply a sorting algorithm to the resulting array 
			
		
		// 2. Even Fibonacci Numbers
		EvenFibonacciNumbers.fiboArray(700);
		
		// TODO 2. How to keep arrays properly sized? 
	}

}
