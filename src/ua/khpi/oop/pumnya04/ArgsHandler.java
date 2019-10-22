package labs.pumnya04;

class ArgsHandler {
    /** An arguments of command line. */
    private String[] arguments;
    /** Is debug mode on? */
    private static boolean debug = false;

    static boolean isDebug() {
        return debug;
    }

    ArgsHandler(final String[] args) {
        this.arguments = args;
    }

    boolean empty() {
        return arguments.length == 0;
    }

    void execute() {
        for (String i : arguments) {
            switch (i) {
                case "-h":
                    System.out.println("\nAuthor: Pumnya Alexander, KIT101.8B");
                    System.out.println("Task: Enter text. "
                                     + "Insert the specified sentence "
                                     + "after each specified word."
                                     + " Output the initial text and result.");
                    System.out.println("-h (-help) : Print info about "
                                     + "the work and console commands.");
                    System.out.println("-d (-debug) : "
                                     + "Displays additional data.");
                    break;
                case "-help":
                    System.out.println("\nAuthor: "
                                     + "Pumnya Alexander, KIT101.8B.");
                    System.out.println("Task: Enter text. "
                                     + "Insert the specified sentence "
                                     + "after each specified word. "
                                     + "Output the initial text and result.");
                    System.out.println("-h (-help) : Print info about "
                                     + "the work and console commands.");
                    System.out.println("-d (-debug) : "
                                     + "Displays additional data.");
                    break;
                case "-d":
                    debug = true;
                    break;
                case "-debug":
                    debug = true;
                    break;
                default:
                    System.out.format("%n Incorrect command %s.%n", i);
                    System.out.println("-h, -help, -d, -debug "
                                     + "is only allowed.");
            }
        }
    }
}
