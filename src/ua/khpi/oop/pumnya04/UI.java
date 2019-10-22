package labs.pumnya04;

import java.util.Scanner;

final class UI {
    private UI() {
    }
    /** Gets values from user. */
    private static Scanner scan = new Scanner(System.in);
    /** User's choice in main menu. */
    private static int choice;
    static int getChoice() {
        return choice;
    }
    static void mainMenu() {
        System.out.format("%n1. Enter values.%n");
        System.out.format("2. Print values.%n");
        System.out.format("3. Task completion.%n");
        System.out.format("4. Print result.%n");
        System.out.format("0. Exit.%n");
        System.out.format("Enter your choose: ");
    }

    static void printInfo(final String text,
                          final String word,
                          final String sentence) {
        System.out.format("%nText: " + text + "%n");
        System.out.format("Word: " + word + "%n");
        System.out.format("Sentence: " + sentence + "%n");
    }

    static void printResult(final String text, final String result) {
        System.out.format("%nSource text: " + text + "%n");
        System.out.format("Result: " + result + "%n");
    }

    static void enterChoice() {
        choice = scan.nextInt();
        scan.nextLine();
    }

    static String getText() {
        System.out.format("%nEnter text: ");
        return scan.nextLine();
    }

    static String getWord() {
        System.out.format("Enter word: ");
        return scan.nextLine();
    }

    static String getSentence() {
        System.out.format("Enter sentence: ");
        return scan.nextLine();
    }
}
