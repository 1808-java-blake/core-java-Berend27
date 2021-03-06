package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.lang.Object;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/** done
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		char[] acronymed = new char[phrase.length()];
		int spaceCount = 0;
		for (int i = 0; i <= phrase.length() - 1; i++) 
		{
			if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') 
			{
				spaceCount += 1;
				if (phrase.charAt(i+1) != '\0')
				{
					acronymed[spaceCount] = phrase.charAt(i+1);
				}
			}
		}
		
		// Adding the first letter to the acronym
		int j = 0;
		do {
			if (phrase.charAt(j) != ' ')
			{
				acronymed[0] = phrase.charAt(0);
			}
			else 
			{
				j += 1;
			}
		} while (phrase.charAt(j) == ' ');

		return new String(acronymed).toUpperCase().trim();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 * done
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

			if (sideOne == sideTwo && sideOne == sideThree)
			{
				return true;
			}
			else
				return false;
		}

		public boolean isIsosceles() {
			int sameSize = 1;
			if (sideOne == sideTwo)
				sameSize += 1;
			if (sideOne == sideThree)
				sameSize += 1;
			if (sideTwo == sideThree)
				sameSize += 1;
			if (sameSize >= 2)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideTwo != sideThree && sideThree != sideOne)
				return true;
			else 
				return false;
		}

	}

	/** done
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		string = string.toUpperCase();
		for (int i = 0; i < string.length(); i++) 
		{
			if (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' 
					|| string.charAt(i) == 'U' || string.charAt(i) == 'L' || string.charAt(i) == 'N' || 
					string.charAt(i) == 'R' || string.charAt(i) == 'S' || string.charAt(i) == 'T') 
			{
				score += 1;
			}
			else if (string.charAt(i) == 'D' || string.charAt(i) == 'G')
			{
				score += 2;
			}
			else if (string.charAt(i) == 'B' || string.charAt(i) == 'C' || string.charAt(i) == 'M' || 
					 string.charAt(i) == 'P' )
			{
				score += 3;
			}
			else if (string.charAt(i) == 'F' || string.charAt(i) == 'H' || string.charAt(i) == 'V' || 
					string.charAt(i) == 'W' || string.charAt(i) == 'Y' )
			{
				score += 4;
			}
			else if (string.charAt(i) == 'K')
				score += 5;
			else if (string.charAt(i) == 'J' || string.charAt(i) == 'X')
				score += 8;
			else if (string.charAt(i) == 'Q' || string.charAt(i) == 'Z')
				score += 10;
			else
				score += 0;
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
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
		char[] phoneNumber = new char[string.length()];
		int numCount = 0;
		if ((string.charAt(0) == '+' && string.charAt(1) != '1') || 
				(string.charAt(0) != '1' && string.charAt(1) == ' '))
			return string + " (invalid country code)";
		else 
		{
			for (int i = 0; i < string.length(); i++) 
			{
				if (string.charAt(i) == '0' || string.charAt(i) == '1' || string.charAt(i) == '2' || 
						string.charAt(i) == '3' || string.charAt(i) == '4' || string.charAt(i) == '5' || 
						string.charAt(i) == '6' || string.charAt(i) == '7' || string.charAt(i) == '8' || 
						string.charAt(i) == '9' )
				{
					phoneNumber[numCount] = string.charAt(i);
					numCount += 1;
				}
			}
			return new String(phoneNumber).trim();
		}
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String[] split = string.split("[ \\,]");
		Map <String, Integer> words = new HashMap<>();
		int occurrences = 0;
		for (String word: split)
		{
			occurrences = countOfOccurrences(string, word);
			words.put(word, occurrences);
		}
		return words;
	}
	


	public int countOfOccurrences(String str, String subStr) {
		return (str.length() - str.replaceAll(Pattern.quote(subStr), "").length()) / subStr.length();
	}



	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration, 
		// 		Be able to handle a string with multiple words separated by spaces
		char[] pigLatinWord = new char[string.length()+6];
		char[] pigLatinWord2 = new char[string.length()+10];
		int startingConsonants = 0;
		int end2 = string.length();
		char letter = string.charAt(0);
		while (letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o' 
				&& letter != 'u') 
		{
			startingConsonants += 1;
			letter = string.charAt(startingConsonants);
		}
		System.out.println(startingConsonants);
		if (startingConsonants != 0)
		{
			for (int i = 0; i <= startingConsonants; i++)
			{
				pigLatinWord[end2] = string.charAt(i);
				end2 += 1;
			}
		}
		switch (startingConsonants) {
			case 0: 
				for (int j = startingConsonants; j < string.length()-startingConsonants; j++)
				{
					pigLatinWord[j] = string.charAt(j);
				}
				break;
			case 1: 
				for (int j = startingConsonants; j <= string.length()-startingConsonants; j++)
				{
					pigLatinWord[j] = string.charAt(j);
				}
				break;
			case 2:
				for (int j = startingConsonants; j <= string.length()-startingConsonants+1; j++)
				{
					pigLatinWord[j] = string.charAt(j);
				}
				break;
			case 3:
				for (int j = startingConsonants; j <= string.length()-startingConsonants+2; j++)
				{
					pigLatinWord[j] = string.charAt(j);
				}
				break;
		}
		// adding the "ay"
		pigLatinWord[string.length()+startingConsonants] = 'a';
		pigLatinWord[string.length()+startingConsonants+1] = 'y';
		
		// getting rid of the spaces by adding to a second character array
		switch (startingConsonants) {
		case 0: 
			for (int j = startingConsonants; j < string.length()-startingConsonants; j++)
			{
				for (int m = 0; m < string.length() + 5; m++)
					pigLatinWord2[m] = pigLatinWord[m+startingConsonants];
			}
			break;
		case 1: 
			for (int j = startingConsonants; j <= string.length()-startingConsonants; j++)
			{
				for (int m = 0; m < string.length() + 5; m++)
					pigLatinWord2[m] = pigLatinWord[m+startingConsonants];
			}
			break;
		case 2:
			for (int j = startingConsonants; j <= string.length()-startingConsonants+1; j++)
			{
				for (int m = 0; m < string.length() + 4; m++)
					pigLatinWord2[m] = pigLatinWord[m+startingConsonants];
			}
			break;
		case 3:
			for (int j = startingConsonants; j <= string.length()-startingConsonants+2; j++)
			{
				for (int m = 0; m < string.length() + 3; m++)
					pigLatinWord2[m] = pigLatinWord[m+startingConsonants];
			}
			break;
	}
			
	
		return new String(pigLatinWord2).trim();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String theNumber = Integer.toString(input);
		int power = theNumber.length();
		int sum = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		switch (power) 
		{
		case 1:
			d = Character.getNumericValue(theNumber.charAt(0));
			break;
		case 2:
			d = (Character.getNumericValue(theNumber.charAt(1)));
			d = d*d;
			c = (Character.getNumericValue(theNumber.charAt(0)));
			c = c*c;
			break;
		case 3: 
			d = Character.getNumericValue(theNumber.charAt(2));
			d = d*d*d;
			c = (Character.getNumericValue(theNumber.charAt(1)));
			c = c*c*c;
			b = (Character.getNumericValue(theNumber.charAt(0)));
			b = b*b*b;
			break;
		case 4:
			d = (Character.getNumericValue(theNumber.charAt(3)));
			d = d*d*d*d;
			c = (Character.getNumericValue(theNumber.charAt(2)));
			c = c*c*c*c;
			b = (Character.getNumericValue(theNumber.charAt(1)));
			b = b*b*b*b;
			a = (Character.getNumericValue(theNumber.charAt(0)));
			a = a*a*a*a;
			break;
		default:
			return false;
		}
		sum = a + b + c + d;
		if (sum == input)
			return true;
		else 
			return false;
		
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */ 
	public List<Long> calculatePrimeFactorsOf(long l) { 
		Long divisor = 2l;
		List<Long> PrimeFactors = new ArrayList<>();
		while (l != 1l)
		{
			if (l % divisor == 0)
			{
				PrimeFactors.add(divisor);
				l = l / divisor;
			}
			else
				divisor += 1l;
		}
		return PrimeFactors;

	} 

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			char[] rotated = new char[string.length()];
			for (int i = 0; i < string.length(); i++)
			{
				if ((string.charAt(i) < 'A'))
				{
					rotated[i] = string.charAt(i);
					continue;
				}
				rotated[i] = (char) ((int)string.charAt(i) + key);
				if (rotated[i] > 'z')
					rotated[i] -= 26;
				else if(rotated[i] > 90 && rotated[i] < 97)
					rotated[i] -= 26;
				else if(string.charAt(i) < 90 && rotated[i] > 'Z')
					rotated[i] -= 26;
			}
			return new String(rotated);
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		// for 0th prime, make an if case and throw exception as illegal argument
		if (i <= 0)
			throw new IllegalArgumentException();
		else 
		{
			int prime = 1; 
			int divisor;
			for (int j = 1; j <= i; j++)
			{
				prime++;
				divisor = prime - 1;
				if (divisor == 1)
					continue;
				while (prime % divisor != 0)
				{
					divisor -= 1;
					if (prime % divisor == 0 && divisor != 1)
					{
						prime += 1; 
						divisor = prime - 1;
					}
				}
			}
		return prime;
		}
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			string = string.toLowerCase();
			char[] ciphered = new char[string.length()+1];
			char[] grouped = new char[string.length()*2];
			char thisChar;
			int addedSpace = 0;
			int spaces = 0;
			
			for (int i = 0; i < string.length(); i++) 
			{
				thisChar = string.charAt(i);
				switch (thisChar) {
				case 'a':
					thisChar = 'z';
					ciphered[i-spaces] = thisChar;
					break;
				case 'b':
					thisChar = 'y';
					ciphered[i-spaces] = thisChar;
					break;
				case 'c':
					thisChar = 'x';
					ciphered[i-spaces] = thisChar;
					break;
				case 'd':
					thisChar = 'w';
					ciphered[i-spaces] = thisChar;
					break;
				case 'e':
					thisChar = 'v';
					ciphered[i-spaces] = thisChar;
					break;
				case 'f':
					thisChar = 'u';
					ciphered[i-spaces] = thisChar;
					break;
				case 'g':
					thisChar = 't';
					ciphered[i-spaces] = thisChar;
					break;
				case 'h':
					thisChar = 's';
					ciphered[i-spaces] = thisChar;
					break;
				case 'i':
					thisChar = 'r';
					ciphered[i-spaces] = thisChar;
					break;
				case 'j':
					thisChar = 'q';
					ciphered[i-spaces] = thisChar;
					break;
				case 'k':
					thisChar = 'p';
					ciphered[i-spaces] = thisChar;
					break;
				case 'l':
					thisChar = 'o';
					ciphered[i-spaces] = thisChar;
					break;
				case 'm':
					thisChar = 'n';
					ciphered[i-spaces] = thisChar;
					break;
				case 'n':
					thisChar = 'm';
					ciphered[i-spaces] = thisChar;
					break;
				case 'o':
					thisChar = 'l';
					ciphered[i-spaces] = thisChar;
					break;
				case 'p':
					thisChar = 'k';
					ciphered[i-spaces] = thisChar;
					break;
				case 'q':
					thisChar = 'j';
					ciphered[i-spaces] = thisChar;
					break;
				case 'r':
					thisChar = 'i';
					ciphered[i-spaces] = thisChar;
					break;
				case 's':
					thisChar = 'h';
					ciphered[i-spaces] = thisChar;
					break;
				case 't':
					thisChar = 'g';
					ciphered[i-spaces] = thisChar;
					break;
				case 'u':
					thisChar = 'f';
					ciphered[i-spaces] = thisChar;
					break;
				case 'v':
					thisChar = 'e';
					ciphered[i-spaces] = thisChar;
					break;
				case 'w':
					thisChar = 'd';
					ciphered[i-spaces] = thisChar;
					break;
				case 'x':
					thisChar = 'c';
					ciphered[i-spaces] = thisChar;
					break;
				case 'y':
					thisChar = 'b';
					ciphered[i-spaces] = thisChar;
					break;
				case 'z':
					thisChar = 'a';
					ciphered[i-spaces] = thisChar;
					break;
				case ' ':
					spaces += 1;
					break;
				case '.':
					spaces += 1;
					break;
				case ',':
					spaces += 1;
					break;
				default: 
					ciphered[i-spaces] = thisChar;
					break;
					
				}
				
			}
			if (string.length() >= 4)
			{
				for (int j = 0; j < (string.length()+2); j++)
				{
					if (j != 0 && (j+1) % 6 == 0)
					{
						grouped[j] = ' ';
						addedSpace += 1;
					}
					else
						//System.out.println(ciphered[(j - addedSpace)]);
						grouped[j] = ciphered[j - addedSpace];
				}
			}
			else
			{
				for (int j = 0; j < (string.length()); j++)
				{
					if (j != 0 && (j+1) % 6 == 0)
					{
						grouped[j] = ' ';
						addedSpace += 1;
					}
					else
						//System.out.println(ciphered[(j - addedSpace)]);
						grouped[j] = ciphered[j - addedSpace];
				}
			}
			
			return new String(grouped).trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			string = string.toLowerCase();
			char[] ciphered = new char[string.length()];
			char thisChar;
			int addedSpace = 0;
			int spaces = 0;
			
			for (int i = 0; i < string.length(); i++) 
			{
				thisChar = string.charAt(i);
				switch (thisChar) {
				case 'a':
					thisChar = 'z';
					ciphered[i-spaces] = thisChar;
					break;
				case 'b':
					thisChar = 'y';
					ciphered[i-spaces] = thisChar;
					break;
				case 'c':
					thisChar = 'x';
					ciphered[i-spaces] = thisChar;
					break;
				case 'd':
					thisChar = 'w';
					ciphered[i-spaces] = thisChar;
					break;
				case 'e':
					thisChar = 'v';
					ciphered[i-spaces] = thisChar;
					break;
				case 'f':
					thisChar = 'u';
					ciphered[i-spaces] = thisChar;
					break;
				case 'g':
					thisChar = 't';
					ciphered[i-spaces] = thisChar;
					break;
				case 'h':
					thisChar = 's';
					ciphered[i-spaces] = thisChar;
					break;
				case 'i':
					thisChar = 'r';
					ciphered[i-spaces] = thisChar;
					break;
				case 'j':
					thisChar = 'q';
					ciphered[i-spaces] = thisChar;
					break;
				case 'k':
					thisChar = 'p';
					ciphered[i-spaces] = thisChar;
					break;
				case 'l':
					thisChar = 'o';
					ciphered[i-spaces] = thisChar;
					break;
				case 'm':
					thisChar = 'n';
					ciphered[i-spaces] = thisChar;
					break;
				case 'n':
					thisChar = 'm';
					ciphered[i-spaces] = thisChar;
					break;
				case 'o':
					thisChar = 'l';
					ciphered[i-spaces] = thisChar;
					break;
				case 'p':
					thisChar = 'k';
					ciphered[i-spaces] = thisChar;
					break;
				case 'q':
					thisChar = 'j';
					ciphered[i-spaces] = thisChar;
					break;
				case 'r':
					thisChar = 'i';
					ciphered[i-spaces] = thisChar;
					break;
				case 's':
					thisChar = 'h';
					ciphered[i-spaces] = thisChar;
					break;
				case 't':
					thisChar = 'g';
					ciphered[i-spaces] = thisChar;
					break;
				case 'u':
					thisChar = 'f';
					ciphered[i-spaces] = thisChar;
					break;
				case 'v':
					thisChar = 'e';
					ciphered[i-spaces] = thisChar;
					break;
				case 'w':
					thisChar = 'd';
					ciphered[i-spaces] = thisChar;
					break;
				case 'x':
					thisChar = 'c';
					ciphered[i-spaces] = thisChar;
					break;
				case 'y':
					thisChar = 'b';
					ciphered[i-spaces] = thisChar;
					break;
				case 'z':
					thisChar = 'a';
					ciphered[i-spaces] = thisChar;
					break;
				case ' ':
					spaces += 1;
					break;
				default: 
					ciphered[i-spaces] = thisChar;
					break;
					
				}
			
		}
			return new String(ciphered).trim();
	}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		string = string.replaceAll("-", "").trim();  // gets rid of dashes
		char[] isbn = new char[string.length()];
		int[] ic = new int[string.length()];
		for(int i = 0; i < string.length(); i++)
		{	
			isbn[i] = string.charAt(i);
			if (isbn[i] > 58 && isbn[i] != 'X')
				return false;
			if (i < 9)
			{
				ic[i] = (int) string.charAt(i);
			}
			if (isbn[9] == 'X')
				ic[9] = 10;
			else
				ic[9] = (int) string.charAt(9);
		}
		
		return ((ic[0] * 10 + ic[1] * 9 + ic[2] * 8 + ic[3] * 7 + ic[4] * 6 + ic[5] * 5 + ic[6] * 4 + ic[7] * 3 + 
				ic[8] * 2 + ic[9] * 1) % 11 == 0);
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {

        //In case,time not included

        if(given instanceof LocalDate) {

            LocalDateTime time = LocalDateTime.of((LocalDate) given, LocalTime.MIN);

            return time.plus(Duration.ofSeconds(1000000000l));

        }

        //if time is included

        LocalDateTime time = LocalDateTime.from(given);

        return time.plus(Duration.ofSeconds(1000000000l));

    }
	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		string = string.replaceAll(" by", "");
		String[] split = string.split(" ");
		int first = Integer.parseInt(split[2]);
		int answer = 1;
		char[] n2 = new char[split[4].length()-1];
		for (int i = 0; i < split[4].length()-1; i++)
		{
			n2[i] = split[4].charAt(i); 
		}
		String s2 = new String(n2);
		int second = Integer.parseInt(s2);
		if (split[3].equals("plus"))
			answer = first + second;
		else if (split[3].equals("minus"))
			answer = first - second;
		else if (split[3].equals("multiplied"))
			answer = first*second;
		else if (split[3].equals("divided"))
			answer = first/second;
		else 
			throw new IllegalArgumentException();
		
		return answer;
	}

}
