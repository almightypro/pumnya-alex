package pumnya03;
import java.util.Scanner;

public class Pumnya03 {

    public static void main(String[] args) {
        String text, word, sentence, result;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text: ");
        text = in.nextLine();
        System.out.print("Enter word: ");
        word = in.nextLine();
        System.out.print("Enter sentence: ");
        sentence = in.nextLine();
        result = StrBuilder.execute(text, word, sentence);
        System.out.println("\nSource:\n" + text);
        System.out.println("\nResult:\n" + result);
    }
}

class StrBuilder {
    static String execute(String text, String word, String sentence) {
        StringBuilder builder = new StringBuilder(text);
        int index = 0;
        while (true) {
            index = builder.indexOf(word, index);
            if (index < 0)
                break;
            builder.insert(index + word.length(), sentence);
            index += word.length();
        }
        return builder.toString();
    }
}