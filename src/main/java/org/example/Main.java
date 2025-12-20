package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        String word = "pizza";
        int wrongGuesses = 0;

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("************************");
        System.out.println("Welcome to Java Hangman!");
        System.out.println("************************");



        while (wrongGuesses < 6) {

            System.out.println(getHangmanArt(wrongGuesses));

            System.out.println("Word: ");

            // format wordState (so console output doesn't look like an array)
            for (char c : wordState) {
                System.out.print(c + " ");
            }

            System.out.println();
            System.out.println("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);


            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct guess!\n");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }
                if (!wordState.contains('_')) {
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("You WIN!");
                    System.out.println("The word was " + word);
                    break;
                }
            } else {
                System.out.println("Wrong guess!\n");
                wrongGuesses++;
            }
        }

        if (wrongGuesses >= 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("GAME OVER!");
            System.out.println("The word was " + word);
        }


        scanner.close();
    }

    static String getHangmanArt(int wrongGuesses) {
        return switch(wrongGuesses) {
            case 0 -> """
                    
                    
                    
                      """;
            case 1 -> """
                        o
                      
                      
                      """;
            case 2 -> """
                        o
                        |
                    
                      """;
            case 3 -> """
                        o
                       /|
                       
                      """;
            case 4 -> """
                        o
                       /|\\
                      
                      """;
            case 5 -> """
                        o
                       /|\\
                       /
                      """;
            case 6 -> """
                        o
                       /|\\
                       / \\
                      """;
            default ->
                "Game over";
        };
    }
}
