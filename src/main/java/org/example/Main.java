package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        String word = "watermelon";
        int wrongGuesses = 0;

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("************************");
        System.out.println("Welcome to Java Hangman!");
        System.out.println("************************");

        System.out.println(getHangmanArt(2));

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
