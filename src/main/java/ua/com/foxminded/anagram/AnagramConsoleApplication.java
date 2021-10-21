package ua.com.foxminded.anagram;

import java.util.Scanner;

public class AnagramConsoleApplication {

    public static void main(String[] args) {
        Scanner streamIn = new Scanner(System.in);
        System.out.println("\nResult anagram algoritm:\n " + AnagramMaker.makeAnagram(streamIn.nextLine()));
        streamIn.close();
    }
}
