package labs.pumnya04;
import labs.pumnya03.StrBuilder;

class StrBuilderD extends StrBuilder {
    StrBuilderD() {
        super();
    }
    @Override
    public String execute() {
        StrBuilder builder = new StrBuilder(getText(),
                                            getWord(),
                                            getSentence());
        if (ArgsHandler.isDebug()) {
            System.out.println("\nText: " + getText());
            System.out.println("Word: " + getWord());
            System.out.println("Sentence: " + getWord());
        }
        return builder.execute();
    }
}
