package src.topics;

import java.util.Scanner;

public class BaseConversion {

    public Scanner scanner;
    public static String currentAnswer;

    // Constructor
    public BaseConversion(Scanner x) {
        scanner = x;

    }

    /**
     * Generates a random number and base, converts the number to the random base
     * based on user input, then checks if the user's answer is correct and prints
     * the result.
     *
     * @param scanner a Scanner object used to get user input
     */
    public static void askQuestion(Scanner scanner) {
        // Generate random number from 1-1000
        int randomNumber = (int) (Math.random() * 1000) + 1;
        if (randomNumber == 1001)
            randomNumber = 1000;

        // Pick any random base other than decimal up to base 16
        int randomBase = (int) (Math.random() * 15) + 2;

        // Convert the number to the random base
        String convertedNumber = convertBase(Integer.toString(randomNumber), 10, randomBase);

        // Ask the question
        System.out.println("Convert " + randomNumber + " to base " + randomBase + ".");
        String answer = scanner.nextLine();
        // Check the answer, if "q" is given then quit.
        if (answer.equals("q"))
            // End the program
            System.exit(0);
        if (answer.equals(convertedNumber))
            System.out.println("Correct!");
        else
            System.out.println("Incorrect. The answer is " + convertedNumber + ".");
    }

    /**
     * Generates a random number and base, converts the number to the random base,
     * and returns a question asking the user to convert the number to the random
     * base.
     *
     * @param scanner  the Scanner to get input from
     * @param fromBase the base of the original number
     * @param toBase   the base to convert the number to
     */
    public static void askQuestion(Scanner scanner, int fromBase, int toBase) {
        // Generate random number from 1-1000
        int randomNumber = (int) (Math.random() * 1000) + 1;
        if (randomNumber == 1001)
            randomNumber = 1000;

        // Convert the number to the random base
        String convertedNumber = convertBase(Integer.toString(randomNumber), fromBase, toBase);

        // Ask the question
        System.out.println("Convert " + randomNumber + " from base " + fromBase + " to base " + toBase + ".");
        String answer = scanner.nextLine();
        // Check the answer, if "q" is given then quit.
        if (answer.equals("q"))
            // End the program
            System.exit(0);
        if (answer.equals(convertedNumber))
            System.out.println("Correct!");
        else
            System.out.println("Incorrect. The answer is " + convertedNumber + ".");
    }

    /**
     * Generates a random number and base, converts the number to the random base,
     * and returns a question asking the user to convert the number to the random
     * base.
     *
     * @return a String representing the question asking the user to convert a
     *         randomly generated number to a randomly generated base
     */
    public static String askQuestion() {
        // Generate random number from 1-1000
        int randomNumber = (int) (Math.random() * 1000) + 1;
        if (randomNumber == 1001)
            randomNumber = 1000;

        // Pick any random base other than decimal up to base 16
        int randomBase = (int) (Math.random() * 15) + 2;

        // Convert the number to the random base
        String convertedNumber = convertBase(Integer.toString(randomNumber), 10, randomBase);

        // Set answer to the converted number for later
        currentAnswer = convertedNumber;

        // Ask the question
        String question = "Convert " + randomNumber + " to base " + randomBase + ".";

        // Return the question
        return question;
    }

    /**
     * Converts a number from one base to another.
     *
     * @param number   the number to convert
     * @param fromBase the base of the original number
     * @param toBase   the base to convert the number to
     * @return a String representing the converted number
     */
    public static String convertBase(String number, int fromBase, int toBase) {
        // Convert the number to decimal (base 10)
        int decimal = Integer.parseInt(number, fromBase);

        // Convert the decimal number to the desired base
        String converted = Integer.toString(decimal, toBase);

        return converted;
    }
}