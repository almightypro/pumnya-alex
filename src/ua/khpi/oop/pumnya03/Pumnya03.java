package labs.pumnya03;
import java.util.Scanner;

public final class Pumnya03 {
    private Pumnya03() {
    }
    /**
     * An entry point - main method.
     *
     * @param args - arguments of main method
     */
    public static void main(final String[] args) {
        String text;
        String word;
        String sentence;
        String result;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        text = in.nextLine();
        System.out.print("Enter word: ");
        word = in.nextLine();
        System.out.print("Enter sentence: ");
        sentence = in.nextLine();
        StrBuilder builder = new StrBuilder(text, word, sentence);
        result = builder.execute();
        System.out.println("\nSource:\n" + text);
        System.out.println("\nResult:\n" + result);
    }
}
