package labs.pumnya06;

import labs.pumnya03.StrBuilder;
import labs.pumnya06.UI.UserChoice;
import labs.vasilchenko03.Helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import java.util.Comparator;

public final class Pumnya06 {
    private Pumnya06() {
    }
    /**
     * An entry point - main method.
     * @param args - arguments of main method
     * @throws IOException - input/output exceptions
     * @throws ClassNotFoundException - if class doesn't found
     */
    public static void main(final String[] args) throws IOException,
                                                        ClassNotFoundException {
        MyContainerMod container = new MyContainerMod();
        UserChoice choice;
        do {
            UI.mainMenu();
            choice = UI.enterChoice();
            System.out.println();
            if (choice == null) {
                System.out.println("An error has occurred.");
                continue;
            }
            switch (choice) {
                case AddValue:
                    System.out.println("Adding new value...");
                    System.out.print("Enter value: ");
                    container.add(UI.getString());
                    System.out.println();
                    break;
                case RemoveValue:
                    System.out.println("Removing value...");
                    System.out.print("Enter value: ");
                    if (container.remove(UI.getString())) {
                        System.out.println("Success.\n");
                    } else {
                        System.out.println("Value not found.\n");
                    }
                    break;
                case Clear:
                    System.out.println("Clearing...");
                    container.clear();
                    System.out.println("Done!\n");
                    break;
                case ShowAll:
                    System.out.println("All elements: ");
                    System.out.println(container.toString() + "\n");
                    break;
                case ContainCheck:
                    System.out.println("Checking for contain...");
                    System.out.print("Enter value: ");
                    if (container.contains(UI.getString())) {
                        System.out.println("Value contains in container.\n");
                    } else {
                        System.out.println("Value does not exist.\n");
                    }
                    break;
                case RunMyHelper:
                    System.out.print("Enter text: ");
                    String text = UI.getString();
                    System.out.print("Enter word: ");
                    String word = UI.getString();
                    System.out.print("Enter sentence: ");
                    String sentence = UI.getString();
                    StrBuilder builder = new StrBuilder(text, word, sentence);
                    container.add(text);
                    container.add(word);
                    container.add(sentence);
                    container.add(builder.execute());
                    System.out.println("Result: " + container.last() + "\n");
                    break;
                case RunAnotherHelper:
                    System.out.println("Enter string: ");
                    String string = UI.getString();
                    string = Helper.sortAlphabetical(string);
                    System.out.println("Result: " + string + "\n");
                    break;
                case Compare:
                    System.out.println("Compare: ");
                    container.compare();
                    System.out.println();
                    break;
                case SortAlphabetical:
                    System.out.println("Sorting...");
                    container.sort(String::compareTo);
                    System.out.println("Result: "
                                       + container.toString() + "\n");
                    break;
                case SortByLength:
                    System.out.println("Sorting...");
                    container.sort(Comparator.comparingInt(String::length));
                    System.out.println("Result: "
                                       + container.toString() + "\n");
                    break;
                case Search:
                    System.out.print("Enter searched string: ");
                    String searchedStr = UI.getString();
                    System.out.println("Searching...");
                    int[] strIndexes = container.search(searchedStr);
                    for (int i : strIndexes) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                case SearchByLength:
                    System.out.print("Enter searched length: ");
                    int searchedLen = UI.getInt();
                    System.out.println("Searching...");
                    int[] intIndexes = container.search(searchedLen);
                    for (int i : intIndexes) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                case Serialize:
                    System.out.println("Serialization...");
                    ObjectOutputStream oos = new ObjectOutputStream(
                                       new FileOutputStream("DataFile.dat"));
                    oos.writeObject(container);
                    oos.close();
                    System.out.println("Done!\n");
                    break;
                case Deserialize:
                    System.out.println("Deserialization...");
                    ObjectInputStream ois = new ObjectInputStream(
                                      new FileInputStream("DataFile.dat"));
                    MyContainerMod getContainer =
                                   (MyContainerMod) ois.readObject();
                    ois.close();
                    System.out.println(getContainer.toString() + "\n");
                    break;
                case Exit:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("An error has occurred.");
            }
        } while (UI.getChoice() != UserChoice.Exit);
    }
}
