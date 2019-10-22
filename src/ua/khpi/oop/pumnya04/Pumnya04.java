package labs.pumnya04;

public final class Pumnya04 {
    private Pumnya04() {
    }
    /**
     * An entry point - main method.
     * @param args - arguments of main method
     */
    public static void main(final String[] args) {
        ArgsHandler handler = new ArgsHandler(args);
        if (!handler.empty()) {
            handler.execute();
        }
        String text = null;
        String word = null;
        String sentence = null;
        String result = null;
        StrBuilderD builder = new StrBuilderD();
        final int exit = 0;
        final int setValues = 1;
        final int getValues = 2;
        final int execute = 3;
        final int printResult = 4;
        do {
            UI.mainMenu();
            UI.enterChoice();
            switch (UI.getChoice()) {
                case exit:
                    if (ArgsHandler.isDebug()) {
                        System.out.println("\nYou chosen 0. Exiting...");
                    }
                    break;
                case setValues:
                    if (ArgsHandler.isDebug()) {
                        System.out.println("\nYou chosen 1. Setting values...");
                    }
                    text = UI.getText();
                    word = UI.getWord();
                    sentence = UI.getSentence();
                    builder.setValues(text, word, sentence);
                    break;
                case getValues:
                    if (ArgsHandler.isDebug()) {
                        System.out.println("\nYou chosen 2. Getting values...");
                    }
                    if (text != null && word != null && sentence != null) {
                        UI.printInfo(text, word, sentence);
                    } else {
                        System.out.format("%nFirst you need to add values.");
                    }
                    break;
                case execute:
                    if (ArgsHandler.isDebug()) {
                        System.out.println("\nYou chosen 3. Executing task...");
                    }
                    if (text != null && word != null && sentence != null) {
                        result = builder.execute();
                    } else {
                        System.out.format("%nFirst you need to add values.");
                    }
                    break;
                case printResult:
                    if (ArgsHandler.isDebug()) {
                        System.out.format("%nYou chosen 4. "
                                        + "Printing out result...%n");
                    }
                    if (text != null && word != null && sentence != null) {
                        UI.printResult(text, result);
                    } else {
                        System.out.format("%nFirst you need to add values.");
                    }
                    break;
                default:
                    System.out.println("\nEnter correct number.");
            }
        } while (UI.getChoice() != 0);
    }
}
