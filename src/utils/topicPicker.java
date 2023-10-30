package src.utils;

import java.util.Scanner;

import src.topics.BaseConversion;

public class topicPicker {
    public static void pickTopic(Scanner scanner) {
        // Ask the user to pick a topic
        System.out.println("Choose a topic:");
        System.out.println("1. Base Conversion");
        System.out.println("More coming soon...");
        System.out.println("Type \"q\" to quit.");
        System.out.println();
        System.out.print("Choice: ");

        // Array with possible choices, if the choice picked isn't in the array then say
        // it's invalid, then ask again.
        String[] choices = { "1" };
        String choice = scanner.nextLine();
        System.out.println();
        if (choice.equals("q"))
            System.exit(0);
        else {
            if (choice.equals(choices[0])) {
                // Ask the user if they want to pick the bases
                System.out.println("Do you want to pick the bases? (y/n)");
                String pickBases = scanner.nextLine();
                if (pickBases.equals("y")) {
                    // Ask the user for the bases
                    System.out.println("What base do you want to convert from?");
                    int fromBase = scanner.nextInt();
                    System.out.println("What base do you want to convert to?");
                    int toBase = scanner.nextInt();
                    scanner.nextLine(); // consume the newline character
                    // Ask the questions
                    while (true) {
                        BaseConversion.askQuestion(scanner, fromBase, toBase);
                        System.out.println("Type \"q\" to quit or any other key to continue.");
                        String quit = scanner.nextLine();
                        if (quit.equals("q")) {
                            break;
                        }
                    }
                } else {
                    // Ask the questions
                    while (true) {
                        BaseConversion.askQuestion(scanner);
                        System.out.println("Type \"q\" to quit or any other key to continue.");
                        String quit = scanner.nextLine();
                        if (quit.equals("q")) {
                            break;
                        }
                    }
                }
            } else {
                System.out.println("Invalid choice.");
                pickTopic(scanner);
            }
        }
    }
}
