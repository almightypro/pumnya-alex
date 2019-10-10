package pumnya04;

class ArgsHandler {
    private String[] args;
    static boolean debug = false;
    ArgsHandler(String[] args) { this.args = args; }

    boolean empty() { return args.length == 0; }

    void execute() {
        for (String i : args) {
            switch (i) {
                case "-h":
                    System.out.println("\nAuthor: Pumnya Alexander, KIT101.8B");
                    System.out.println("Task: Enter text. Insert the specified word after each " +
                            "specified word. Output the initial text and result.");
                    System.out.println("-h (-help) : Print info about the work and console commands.");
                    System.out.println("-d (-debug) : Displays additional data.");
                    break;
                case "-help":
                    System.out.println("\nAuthor: Pumnya Alexander, KIT101.8B.");
                    System.out.println("Task: Enter text. Insert the specified word after each " +
                            "specified word. Output the initial text and result.");
                    System.out.println("-h (-help) : Print info about the work and console commands.");
                    System.out.println("-d (-debug) : Displays additional data.");
                    break;
                case "-d":
                    debug = true;
                    break;
                case "-debug":
                    debug = true;
                    break;
                default:
                    System.out.format("%n Incorrect command %s.%n", i);
                    System.out.println("-h, -help, -d, -debug is only allowed.");
            }
        }
    }
}
