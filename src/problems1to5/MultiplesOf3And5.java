package problems1to5;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Problem 1: 
 
 If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 The sum of these multiples is 23.
 

 Find the sum of all the multiples of 3 or 5 below 1000.
 
*/


//Input:		1) two integers(a and b), in this case 3 and 5  
// 				2) n = amount of elements.  In this case, n = 1000

// Output: 		1) Array of numbers which satisfy the condition. (x % 3 == 0) && (y % 5 == 0)
//				2) Sum of all elements of array.
	
public class MultiplesOf3And5 {
	private int n; 
	private int a;
	private int b;
	
	private static int[] allElements;
	private static int[] goodElements;
	private static int numberOfGoodElements;
	
	private static BigInteger bigSum = new BigInteger("0");
	private static BigInteger bigSumMulti = new BigInteger("0");
	
	static Scanner scanner = new Scanner(System.in); // in case user wants to use any amount of multiples (e.g. 3, 5, 11, 13 etc...) 
	private static int[] factors; 
	private static int amountOfFactors;
	private static int[] allElementsMulti;
	private static int[] goodElementsMulti;
	private static int[] resultArray;
	private static int numberOfGoodElementsMulti;
	
	
	
	// User defines how many factors he wants to check.
	// For example, we can check if numbers from 1 to 1000 are divisible by 3, 5 or 7.
	// We would get a progression of 3, 5, 6, 7, 9, 10, 12, 14, 15 etc...
	
	public static void severalFactors() {
		System.out.println("EXERCISE 1: Multiples of 3 and 5 (or ANY AMOUNT of factors) ");
		System.out.println();
		
		int sumOfElements = 0;
		int n;
		
		System.out.println("How many numbers you want to check?");
		while(true) {
			try {
				n = scanner.nextInt();
				scanner.nextLine();
				break; 
			} catch (InputMismatchException e) {
				System.out.println("Type a number!");
				scanner.nextLine();
			}
		}
		
		System.out.println("How many factors?");
		while(true) {
			try {
				amountOfFactors = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Type a number!");
				scanner.nextLine();
			}
		}
		
		
		factors = new int[amountOfFactors];

		for (int i = 0; i < amountOfFactors; i++) {
			System.out.println("Input next factor: ");
			factors[i] = scanner.nextInt();
		}
		
		initArrayMulti(n);
		
		chooseElementsMulti();
		
		System.out.println();
		printArray(resultArray);	// now array needs SORTING ! 
									// FIXME Duplicated elements have to be deleted ! 
		
		sumOfElements = sumOfArrayElements(resultArray);
		
		System.out.println();
		System.out.println("Number of elements: "+ numberOfGoodElementsMulti);
		System.out.println("Sum of elements: " + sumOfElements);
		System.out.println("Sum of elements (BigInteger): " + bigSum);
		
		anotherOne();
	
	}
	
	// initialize original array and fill it with numbers 1, 2, 3, 4, 5 etc... 
		private static void initArrayMulti(int n) {
			

			allElementsMulti = new int[n];
			goodElementsMulti = new int[n];				
					
			for (int i = 0; i < n; i++) {
				
				allElementsMulti[i] = i + 1;
			}
		}
	
	// fill new array with elements that satisfy condition 
		private static void chooseElementsMulti() {
			
			int numberOfPasses = amountOfFactors;
							
			numberOfGoodElementsMulti = 0;
			
			for (int k = 0; k < numberOfPasses; k ++ ) {
				
				for (int i = 0; i < allElementsMulti.length; i++) {
				
					if ((allElementsMulti[i] % factors[k] == 0 )) {
						
						goodElementsMulti[numberOfGoodElementsMulti] = allElementsMulti[i];
						numberOfGoodElementsMulti++;
						
					} 
				}
			}
			
			resultArray = new int[numberOfGoodElementsMulti];
			for (int i = 0; i < numberOfGoodElementsMulti; i++) {
				resultArray[i] = goodElementsMulti[i];
			}
				
			
		}

		public static void anotherOne() {
			System.out.println("Would you like to make another calculation? (Y/N) ");
			String answer = scanner.next();
			
			if ( (answer.equalsIgnoreCase("y"))) severalFactors();
			else return;
			
		}
	
		// print array
				public static void printArray(int[] arrayToPrint) {
					for (int x : arrayToPrint) {
						System.out.print(x + " ");;
					}
				}
		
		// getter		
		public static int[] getResult() {
			return resultArray;
		}
				
				
				
				
				
				
		
		// *** SOLUTION FOR ORIGINAL PROBLEM ( just two factors) **********************************************
		
		
		// initialize array
		private static void initArray(int n) {
			
			allElements = new int[n - 1];
			goodElements = new int[n - 1];
					
			for (int i = 0; i < n - 1 ; i++) {
				
				allElements[i] = i + 1;
			}
		}
		
		// create new array with elements that satisfy condition
		private static void chooseElements(int a, int b) {
			
			numberOfGoodElements = 0;
			
			for (int i = 0; i < allElements.length; i++) {
			
				if ((allElements[i] % a == 0 ) || (allElements[i] % b == 0 )) {
					
					goodElements[numberOfGoodElements] = allElements[i];
					numberOfGoodElements++;
					
				} 
			}
		}
		
		// Sum of all elements of an array
			public static int sumOfArrayElements(int[] array) {
				int sum = 0;
				bigSum = bigSum.ZERO;
				
				for (int x : array) {
					sum += x;
					bigSum = bigSum.add(BigInteger.valueOf(x));
				}
				
				
				return sum;
			}

		
		public static int multiplesOfEitherOfTwoFactors(int a, int b, int n) {
			System.out.println("EXERCISE 1: Multiples of 3 and 5 (or any two factors) ");
			System.out.println();
			
			int sumOfElements = 0;
			
			
			initArray(n);
			
			chooseElements(a,b);
			
			// trimming array
			int[] resultingArray = new int[numberOfGoodElements];
			for (int k = 0 ; k < numberOfGoodElements; k++) {
				resultingArray[k] = goodElements[k];
			}
			
			// print
			System.out.println();
			printArray(resultingArray);
			
			
			sumOfElements =  sumOfArrayElements(resultingArray);
			
			System.out.println();
			System.out.println("Number of elements: "+ numberOfGoodElements);
			System.out.println("Sum of elements: " + sumOfElements);
			System.out.println("Sum of elements (BigInteger): " + bigSum);
			
			return sumOfElements;
		}
}
