package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class homeworktester {
	public static void main(String[] args) {
		String theString = "Dexter Berend";
		homeworktester tester = new homeworktester();
		theString = tester.acronym(theString);
		System.out.println(theString);
		Triangle t1 = new Triangle(3,4,5);
		System.out.println("Equalateral: " + t1.isEquilateral());
		System.out.println("Isoceles: " + t1.isIsosceles());
		System.out.println("Scalene: " + t1.isScalene());
		String scrabble = "cabbage";
		int scrabbleScore = 0;
		scrabbleScore = tester.getScrabbleScore(scrabble);
		System.out.println(scrabbleScore);
		String cellNumber = "214.735 8395";
		String cellNumberF = "3 214.735 8395";
		String cellNumberplus1 = "+1 (214) 735-8395";
		String cleanedNumber = tester.cleanPhoneNumber(cellNumber);
		System.out.println(cleanedNumber);
		cleanedNumber = tester.cleanPhoneNumber(cellNumberF);
		System.out.println(cleanedNumber);
		cleanedNumber = tester.cleanPhoneNumber(cellNumberplus1);
		System.out.println(cleanedNumber);
		String playString = tester.toPigLatin("school");
		System.out.println(playString);
		System.out.println(tester.isArmstrongNumber(370));
		System.out.println(tester.rotate("1 a z"));
		System.out.println(tester.calculatePrimeFactorsOf(16));
		System.out.println(tester.calculateNthPrime(7));
		AtbashCipher Atbash = new AtbashCipher();
		System.out.println(Atbash.encode("mindblowingly"));
		System.out.println(tester.isValidIsbn("3-598-21507-X"));
		System.out.println(tester.solveWordProblem("What is 1 plus 1?"));

	}
	
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
			{
				ic[9] = 10;
				System.out.println(ic[9]);
			}
				
			else
				ic[9] = (int) string.charAt(9);
		}
		
		return ((ic[0] * 10 + ic[1] * 9 + ic[2] * 8 + ic[3] * 7 + ic[4] * 6 + ic[5] * 5 + ic[6] * 4 + ic[7] * 3 + 
				ic[8] * 2 + ic[9] * 1) % 11 == 0);
	}
	
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
	
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		// for 0th prime, make an if case and throw exception as illegal argument
		if (i == 0 )
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
	
	public String rotate(String string) {
		int key = 1;
		char[] rotated = new char[string.length()];
		for (int i = 0; i < string.length(); i++)
		{
			if ((string.charAt(i) >= '0' && string.charAt(i) <= '9') || string.charAt(i) == ' ')
			{
				rotated[i] = string.charAt(i);
				continue;
			}
			rotated[i] = (char) ((int)string.charAt(i) + key);
			if (rotated[i] > 'z')
				rotated[i] -= 26;
			else if(rotated[i] > 90 && rotated[i] < 97)
				rotated[i] -= 26;
		}
		return new String(rotated);
	}

	
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
	
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration, 
		// 		Be able to handle a string with multiple words separated by spaces
		char[] pigLatinWord = new char[string.length()+6];
		char[] pigLatinWord2 = new char[string.length()+5];
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
				for (int m = 0; m < string.length() + 2; m++)
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
			return new String(phoneNumber);
		}
	}
	
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

	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		char[] acronymed = new char[phrase.length()];
		int spaceCount = 0;
		for (int i = 0; i <= phrase.length() - 1; i++) 
		{
			if (phrase.charAt(i) == ' ') 
			{
				spaceCount += 1;
				if (phrase.charAt(i+1) != '\0')
				{
					acronymed[spaceCount] = phrase.charAt(i+1);
				}
			}
		}
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
		return new String(acronymed).toUpperCase();
	}
}

// 3
class Triangle {
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





