package labs.pumnya03;

public class StrBuilder implements StrBuilderSuper {
    /** text variable. */
    private String text;
    /** word variable. */
    private String word;
    /** sentence variable. */
    private String sentence;

    /**
     * Getter for text.
     * @return text
     */
    protected String getText() {
        return text;
    }
    /**
     * Getter for word.
     * @return word
     */
    protected String getWord() {
        return word;
    }
    /**
     * Getter for sentence.
     * @return sentence
     */
    protected String getSentence() {
        return sentence;
    }

    /** Default constructor. */
    public StrBuilder() {
        text = null;
        word = null;
        sentence = null;
    }

    /**
     * Constructor with parameters.
     * @param t - source text
     * @param w - search word
     * @param s - inserted sentence
     */
    public StrBuilder(final String t,
                      final String w,
                      final String s) {
        this.text = t;
        this.word = w;
        this.sentence = s;
    }

    /**
     * Setter for variables.
     * @param t - source text
     * @param w - search word
     * @param s - inserted sentence
     */
    public void setValues(final String t,
                          final String w,
                          final String s) {
        this.text = t;
        this.word = w;
        this.sentence = s;
    }

    /**
     * Finds all searched words and insert sentence after them.
     * @return string with inserted sentence
     */
    public String execute() {
        StringBuilder builder = new StringBuilder(text);
        int index = 0;
        while (true) {
            index = builder.indexOf(word, index);
            if (index < 0) {
                break;
            }
            builder.insert(index + word.length(), sentence);
            index += word.length();
        }
        return builder.toString();
    }
}
