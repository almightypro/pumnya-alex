package pumnya04;

public class Pumnya04 {

    public static void main(final String[] args) {
        ArgsHandler handler = new ArgsHandler(args);
        if (!handler.empty()) {
            handler.execute();
        }
        String text = null, word = null, sentence = null, result = null;
        do {
            UI.mainMenu();
            UI.getChoice();
            switch (UI.choice) {
                case 0:
                    if(ArgsHandler.debug) {
                        System.out.println("\nYou chosen 0. Exiting...");
                    }
                    break;
                case 1:
                    if(ArgsHandler.debug) {
                        System.out.println("\nYou chosen 1. Setting values...");
                    }
                    text = UI.getText();
                    word = UI.getWord();
                    sentence = UI.getSentence();
                    break;
                case 2:
                    if(ArgsHandler.debug) {
                        System.out.println("\nYou chosen 2. Getting values...");
                    }
                    if (text != null && word != null && sentence != null) {
                        UI.printInfo(text, word, sentence);
                    }
                    else {
                        System.out.format("%nFirst you need to add values.");
                    }
                    break;
                case 3:
                    if(ArgsHandler.debug) {
                        System.out.println("\nYou chosen 3. Executing task...");
                    }
                    if (text != null && word != null && sentence != null) {
                        result = StrBuilder.execute(text, word, sentence);
                    }
                    else {
                        System.out.format("%nFirst you need to add values.");
                    }
                    break;
                case 4:
                    if(ArgsHandler.debug) {
                        System.out.println("\nYou chosen 4. Printing out result...");
                    }
                    if (text != null && word != null && sentence != null) {
                        UI.printResult(text, result);
                    }
                    else {
                        System.out.format("%nFirst you need to add values.");
                    }
                    break;
                default:
                    System.out.println("\nEnter correct number.");
            }
        } while (UI.choice != 0);
    }
}
