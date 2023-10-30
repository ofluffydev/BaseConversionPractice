package src;

import java.util.Scanner;

import src.utils.topicPicker;

public class Main {
    public static void main(String[] args) {
        System.out.println("UIL CS Study tool");
        System.out.println("====================================");
        System.out.println();

        // Create scanner for cli input
        Scanner scanner = new Scanner(System.in);
        topicPicker.pickTopic(scanner);

        // Say thanks for using the program once it returns here
        System.out.println("Thanks for using the program!");

        // Link to my github profile https://github.com/ofluffydev/
        System.out.println("Check out my github profile: https://github.com/ofluffydev/");

    }
}
