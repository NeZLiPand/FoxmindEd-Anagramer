package ua.com.foxminded.nezlipand.main;

import java.util.Scanner;
import ua.com.foxminded.nezlipand.anagrams.PushedText;

public class MainJSpring {

	public static Scanner streamIn = new Scanner(System.in);
	
	public static void main(String[] args) {
		PushedText minigram = new PushedText(streamIn.nextLine());
		System.out.println("\n Result anagram algoritm:\n " + minigram.stringToWords(minigram.enteredText));
		streamIn.close();
	}

}
