package pumnya04;

class StrBuilder {
    static String execute(String text, String word, String sentence) {
        if (ArgsHandler.debug) {
            System.out.println("\nText: " + text);
            System.out.println("Word: " + word);
            System.out.println("Sentence: " + sentence);
        }

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
