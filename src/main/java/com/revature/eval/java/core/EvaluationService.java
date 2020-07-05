package com.revature.eval.java.core;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EvaluationService {

	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {

			final double kph2mph = 0.62137119223733;
			if (kilometersPerHour < 0.0) {
				return -1;
			} //end if block
			else {
				double mph = Math.round(kilometersPerHour * kph2mph);
				return (long)mph;
			} //end else block
		} //end toMilesPerHour method

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {

			if (kilometersPerHour < 0.0) {
				return "Invalid Value";
			} //end if block
			else {
				long mph = SpeedConverter.toMilesPerHour(kilometersPerHour);
				return String.valueOf(kilometersPerHour) + " km/h = " + String.valueOf(mph) + " mi/h";
			} //end else block
		} //end printConversion method
	} //end SpeedConverter class
		
	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int XX) {

		final int MegaByte = 1024;
		int MB, KB = 0;

		if (XX < 0) {
			return "Invalid Value";
		} //end if block
		else {
			MB = XX / MegaByte; // integer division
			KB = XX % MegaByte; // modulo division to get remainder as KB
			return String.valueOf(XX) + " KB = " + String.valueOf(MB)+ " MB and " + String.valueOf(KB) + " KB";			
		} //end else block			
		//return null;
	} //end printMegaBytesAndKiloBytes method

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {

		if (hourOfDay < 0 || hourOfDay > 23) {
			return false;
		} //end if block
		else {
			if (isBarking && (hourOfDay < 8 || hourOfDay > 22)) {
				return true;
			} //end if block
			else {
				return false;
			} //end else block
		} //end else block		
	} //end of shouldWakeUp method

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {

		double shiftFactor = 1000.0;
		long comp1L, comp2L;
		
		comp1L = (long)(firstNum * shiftFactor);	//multiply parm1 by 1000 and cast as long
		comp2L = (long)(secondNum * shiftFactor);	//multiply parm2 by 1000 and cast as long

		if (comp1L == comp2L) {						//perform algebraic compare
			return true;							//they are equal, return true
		} //end if block
		else {
			return false;							//they are not equal, return false
		} //end else block
	}// end areEqualByThreeDecimalPlaces

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {

			if (isTeen(x)) {					//pass first parm to see if isTeen is true
				return true;					//yes - return true
			} //end if block
				else if (isTeen(y)) {			//pass second parm to see if isTeen is true
					return true;				//yes - return true
				} //end else if block
					else if (isTeen(z)) {		//pass last parm to see if isTeen is true
						return true;			//yes - return true
					} //end else if block
					else {
						return false;			//all parms failed - return false
					} //end else block
			} //end hasTeen method

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		public static boolean isTeen(int number) {

			if (number <=19 && number >= 13) {		//check to see if input parm is between 13 & 19 inclusive
				return true;						//yes - return true
			} //end if block
			else {
				return false;						//no - return false
			} //end else block
		} //end isTeen method
	} //end TeenNumberChecker class

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {

		final long minutesPerYear = 525600;		//60 mins/hr * 24 hr/day * 365 days/yr
		final long minutesPerDay  = 1440;		//60 mins/hr * 24 hr/day
		long years, days;
		
		if (minutes < 0) {						//is input parm negative?
			return "Invalid Value";				//yes - return error message
		}										//end if block
		else {
			years = minutes / minutesPerYear;   //convert total minutes to # of years
			days  = minutes % minutesPerYear;	//calculate remaining minutes
			if (days > 0) {						//is there any remaining minutes
				days  /= minutesPerDay;			//convert remaining minutes to # of days
				}
			return minutes + " min = " + years + " y and " + days + " d"; //return expected output string
		}										//end else block
	}											//end printYearAndDays method

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {

		switch (number) {			//no need for a break statement since the code is doing a return
			case 0 : return "ZERO";
			case 1 : return "ONE";
			case 2 : return "TWO";
			case 3 : return "THREE";
			case 4 : return "FOUR";
			case 5 : return "FIVE";
			case 6 : return "SIX";
			case 7 : return "SEVEN";
			case 8 : return "EIGHT";
			case 9 : return "NINE";
			default : return "OTHER";
		} //end switch
		
	} //end printNumberInWord method

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	public int getGreatestCommonDivisor(int first, int second) {

		if (first < 10 || second < 10) {			//check to see if the either parm is < 10
			return -1;								//return error code
		} //end if block

		/* the while loop algorithm for gcd is faster than this for loop!
		int gcd = 1;
		for (int i = 1; i <= first && i <= second; i++) {
			if (first % i == 0 && second % i == 0) {
				gcd = i;
			} //end if block
		} //end for loop
		return gcd;
		 */

		while (first != second) {					//perform loop while first is not equal to second integer
			if (first > second) {					//first > second
				first -= second;					//subtract second from first
			} //end if block
			else {									//second > first
				second -= first;					//subtract first from second
			} //end else block
		} //end while loop
		
		return first;								//return gcd
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {

		int sum, firstDigit, lastDigit = 0;

		if (num < 0) {								//is parm negative
			return -1;								//yes - return error code
		} //end if block

		String strNumber = String.valueOf(num);		//convert input parm to String
		if (strNumber.length() == 1) {				//is input parm a single digit
			sum = num + num;						//double the original value and return it
			return sum;								//return num + num
		} //end if block
		else {										//Sandy Moose gave me the suggestion to use the Character method .getNumericValue()
													//rather than breaking up the string into a char array
			firstDigit = Character.getNumericValue(strNumber.charAt(0));	//load value of 1 digit
			lastDigit = Character.getNumericValue(strNumber.charAt(strNumber.length()-1));	//load value of last digit
			sum = firstDigit + lastDigit;			//add the digits together and return that value
			return sum;
		} //end else block
		
	} //end sumFirstAndLastDigit

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {

		String revstr = "";							//initialize the string

		/* Here's the code solution using StringBuilder

		StringBuilder sb = new StringBuilder(string);
		sb.reverse();
		String revstr = sb.toString();
		System.out.println("string = " + string);
		System.out.println("rev str = " + revstr);
		
		*/
		
		for (int i = string.length()-1; i >= 0; i--) {	//go through the String in reverse order
			revstr += string.charAt(i);				//append the character located at the current string index to end of the string
			} //end for loop
		return revstr;								//return reversed string to caller
	} //end reverse method 

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {

		String acronym = "";													//initialize the acronym string
		String wordArray[] = phrase.replace('-', ' ').toUpperCase().split(" "); //modify the String by replacing all '-' with ' ', then
																				//upper-casing the String and finally splitting the String
																				//up into individual Strings and load them into a String array

		for (String word : wordArray) {											//process each String in the String array
			acronym += word.charAt(0);											//get the 1st character from the current String and append 
		} //end for-each loop													//it to the end of the acronym String
		
		return acronym;															//return acronym String
	} //end acronym method

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {

			if (sideOne == sideTwo && sideOne == sideThree) {	//check to see if all three sides are equal to each other
				return true;									//yes - return true
			} //end if block
			else {
				return false;									//no - return false
			} //end else block
		} //end isEquilateral method

		public boolean isIsosceles() {

			if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) {	//check to see if there are at least 2 sides are equal
				return true;															//yes - return true
			} //end if block
			else {
				return false;															//no - return false
			} //end else block
		} //end isIsosceles method

		public boolean isScalene() {

			if (sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree) {	//check to see if all the sides are not equal to each other
				return true;															//yes - return true
			} //end if block
			else {
				return false;															//no - return false
			} //end else block
		} //end isScalene method

	} //end Triangle class

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {

		char[] ch = string.toUpperCase().toCharArray();		//load upper-cased input string into a char array
		int score = 0;										//initialize running totals to 0

		for (char letter : ch) {							//parse through the character array and determine the score for each letter
			switch (letter) {
				case 'A':									//letters A, E, I, O, U, L, N, R, S, T are worth 1 point
				case 'E':	
				case 'I':	
				case 'O':	
				case 'U':	
				case 'L':	
				case 'N':	
				case 'R':	
				case 'S':	
				case 'T':	
					score += 1;								//add 1 to running total
					break;
				case 'D':									//letters D, G are worth 2 points
				case 'G':	
					score += 2;								//add 2 to running total
					break;
				case 'B':									//letters B, C, M, P are worth 3 points
				case 'C':	
				case 'M':	
				case 'P':	
					score += 3;								//add 3 to running total
					break;
				case 'F':									//letters F, H, V, W, Y are worth 4 points
				case 'H':	
				case 'V':	
				case 'W':	
				case 'Y':	
					score += 4;								//add 4 to running total
					break;
				case 'K':									//letter K is worth 5 points
					score += 5;								//add 5 to running total
					break;
				case 'J':									//letters J, X are worth 8 points
				case 'X':	
					score += 8;								//add 8 to running total
					break;
				case 'Q':									//letters Q, Z are worth 10 points
				case 'Z':	
					score += 10;							//add 10 to running total
					break;
				default :									//all other characters/symbols are worth 0 points
					score += 0;								//add 0 to running total		
			} //end switch block
		} //end for loop

		return score;
	} //end getScrabbleScore method

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {

		String tempPhnNum = string;							//copy contents of input string

		/* The replace all statement replaces these individual replace statements
		 * tempPhnNum = tempPhnNum.replace("+", "");			//remove '+' from phone string
		 * tempPhnNum = tempPhnNum.replace("(", "");			//remove '(' from phone string
		 * tempPhnNum = tempPhnNum.replace(")", "");			//remove ')' from phone string
		 * tempPhnNum = tempPhnNum.replace("-", "");			//remove '-' from phone string
		 * tempPhnNum = tempPhnNum.replace(".", "");			//remove '.' from phone string
		 * tempPhnNum = tempPhnNum.replace(" ", "");			//remove ' ' from phone string
		 */
		
		tempPhnNum = tempPhnNum.replaceAll("[^0-9]", "");	//remove everything except numerals
		
		if (tempPhnNum.length() > 11 || tempPhnNum.length() < 10) {	//is the cleaned phone string too long or short?
			throw new IllegalArgumentException(string);				//yes - throw IllegalArgumentException
		}
		else if (tempPhnNum.length() == 11){				//is the country code present?
			tempPhnNum = tempPhnNum.substring(1);			//remove the country code
		}//end else-if block

		try {												//don't need this check unless you are doing the individual replace steps
			Double.parseDouble(tempPhnNum);					//test to see if the string is numeric have to use double
			return tempPhnNum;								//is Numeric - return clean phone number string
		} //end try block 
		catch (NumberFormatException nfe) {					//NumberFormatException thrown
			throw new IllegalArgumentException(string);		//throw IllegalArgumentException
		} //end catch block

	} //end cleanPhoneNumber method

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		
		int total = 0, digit = 0;
		String strNumber = String.valueOf(input);		//store input integer parm as a String
		
		if (strNumber.length() == 1) {
			return true;								//all single digits are Armstrong numbers
		} //end if block
		
		for (int i = 0; i <= strNumber.length()-1; i++) {			//loop thru the String to process the individual digits
			digit = Character.getNumericValue(strNumber.charAt(i));	//Sandy Moose gave me the suggestion to do it this way
			total += raiseToPowerOfN(digit, strNumber.length());	//add calculated power of digit to running total
		} //end for loop

		if (total == input) {									//compare calculated total to actual input value
			return true;										//equal - return isArmstrongNumber is true
		} //end if block
		else {
			return false;										//not equal - return isArmstrongNumber is false
		} //end else block
		
	} //end isArmstrongNumnber

	public int raiseToPowerOfN(int base, int power) {
		
		if (power == 0) {					//anything raised to the 0 power is 1!
			return 1;			
		} else if (power == 1) {			//anything raised to the 1st power is itself!
			return base;		
		} //end else if block
		
		int intProduct = base;					//initialize running total to value of base
		for (int i = power-1; i > 0; i--) {		//loop until counter reaches 0
			intProduct *= base;					//accumulate running total of raising base to the Nth power
		} //end for loop
		return intProduct;						//return base^power
		
	} //end of raiseToPowerOfN method


	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		// TODO Write an implementation for this method declaration
		int finalPrime = 0;

		if (k <= 0) {													//is input parm <= 0
			throw new IllegalArgumentException(Integer.toString(k)); 	//yes - throw IllegalArgumentException
		}
		
		switch (k) {
			case 1 : return 2;		//1st prime
			case 2 : return 3;		//2nd prime
			case 3 : return 5;		//3rd prime
			case 4 : return 7;		//4th prime
			case 5 : return 11;		//5th prime
			case 6 : return 13;		//6th prime
			case 7 : return 17;		//7th prime
			case 8 : return 19;		//8th prime
			case 9 : return 23;		//9th prime

			default :
  				int nextInteger, nextPrime;
				for (nextInteger = 2, nextPrime = 0; nextPrime < k; nextInteger++) {
					if (isPrime(nextInteger)) {
						nextPrime++;
					} //end if block
				} //end for loop
				finalPrime = nextInteger-1;
		} //end switch
		return finalPrime;			//return Nth prime
		
	} //end calculateNthPrime
	
	public boolean isPrime(int num) {
		
		int i =2;
		while (i <= num/2) {
			if (num % i == 0) {
				return false;
			} //end if
			i++;
		} //end while loop
		return true;

	} //end isPrime method

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		return 0;
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		
		Random rand = new Random();					//instance of Random class (Random number generator)
		int upperbound = 101;						//generate random values from 0-100
		int [] intArray = new int[3];				//instance of integer array with 3 entries
		
		for (int i = 0; i < 3; i++ ) {
			intArray[i] = rand.nextInt(upperbound); //assign generated random integer to the integer Array
		} //end for loop
		
		return intArray;							//return the integer Array
	}
	
	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		return (int)(Math.random() * ((y - x) + 1)) + x;
	}
}
