package com.revature.eval.java.core;

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





