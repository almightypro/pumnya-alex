package labs.pumnya06;

import java.util.Scanner;

public final class UI {
    private UI() {
    }
    /** For getting data from keyboard. */
    private static Scanner in = new Scanner(System.in);
    /** For storing user choice. */
    private static int choice;
    /**  */
    private static UserChoice[] values = UserChoice.values();
    /**
     * Main menu text.
     */
    static void mainMenu() {
        System.out.println("01. Add value.");
        System.out.println("02. Remove value.");
        System.out.println("03. Clear.");
        System.out.println("04. Show all elements.");
        System.out.println("05. Check for contain.");
        System.out.println("06. Run my helper class.");
        System.out.println("07. Run friend's helper class.");
        System.out.println("08. Compare elements for equality.");
        System.out.println("09. Sort elements alphabetical.");
        System.out.println("10. Sort elements by length.");
        System.out.println("11. Search elements.");
        System.out.println("12. Search elements by length.");
        System.out.println("13. Serialize container.");
        System.out.println("14. Deserialize object from file.");
        System.out.println("00. Exit.");
        System.out.print("Enter here: ");
    }
    /**
     * Gets user choice and convert is to enum type.
     * @return converted from integer to enum type of user choice
     */
    public static UserChoice enterChoice() {
        getNumber();
        return (choice >= 0 && choice < values.length) ? values[choice] : null;
    }
    /**
     * Returns user choice.
     * @return user choice as enum type
     */
    public static UserChoice getChoice() {
        return (choice >= 0 && choice < values.length) ? values[choice] : null;
    }
    /**
     * Gets string from keyboard.
     * @return string gotten from keyboard
     */
    public static String getString() {
        return in.nextLine();
    }
    /**
     * Gets user choice from keyboard.
     */
    private static void getNumber() {
        choice = in.nextInt();
        in.nextLine();
    }
    /**
     * Gets integer from keyboard.
     * @return integer value
     */
    public static int getInt() {
        return in.nextInt();
    }
    public enum UserChoice {
        /** Exit from program. */
        Exit,
        /** Add value to container. */
        AddValue,
        /** Remove value from container. */
        RemoveValue,
        /** Clear container. */
        Clear,
        /** Show all elements of container. */
        ShowAll,
        /** Check element for contains to container. */
        ContainCheck,
        /** Run my helper class. */
        RunMyHelper,
        /** Run another helper class. */
        RunAnotherHelper,
        /** Comparing elements of container. */
        Compare,
        /** Alphabetical sorting. */
        SortAlphabetical,
        /** Sorting by length. */
        SortByLength,
        /** Searching for elements. */
        Search,
        /** Searching for elements by length. */
        SearchByLength,
        /** Serialization. */
        Serialize,
        /** Deserialization. */
        Deserialize
    }
}

