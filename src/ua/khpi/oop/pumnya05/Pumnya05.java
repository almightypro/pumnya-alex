package labs.pumnya05;
import labs.pumnya05.MyContainer.MyIterator;
import org.w3c.dom.ls.LSOutput;

public final class Pumnya05 {
    private Pumnya05() {
    }
    /**
     * An entry point - main method.
     * @param args - arguments of main method
     */
    public static void main(final String[] args) {
        // Creating container
        MyContainer container = new MyContainer();
        // Adding values
        container.add("Germany");
        container.add("France");
        container.add("Italy");
        container.add("Spain");
        container.add("Russia");
        // Creating iterator
        MyIterator iter = container.iterator();
        System.out.print("While:      ");
        // Printing values by a while loop
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        // Printing values by a for each loop
        System.out.print("For each:   ");
        for (String s : container) {
            System.out.print(s + " ");
        }
        System.out.println();
        // Using toString() method
        System.out.println("toString(): " + container.toString());
        // Creating second container
        MyContainer container2 = new MyContainer();
        // Add values into the second container
        container2.add("Germany");
        container2.add("France");
        container2.add("Italy");
        System.out.println("Testing boolean methods:");
        // Using contains() method
        System.out.println(container.contains("Ukraine"));
        // Using containsAll() method
        System.out.println(container.containsAll(container2));
        container2.add("Ukraine");
        System.out.println(container.containsAll(container2));
        // Using remove() method
        container2.remove("Ukraine");
        System.out.println(container.containsAll(container2) + "\n");
        // Creating second iterator
        MyIterator iter2 = container2.iterator();
        // Using iterator's methods
        for (String s : container2) {
            System.out.print(s + ' ');
        }
        System.out.println();
        if (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
        iter2.remove();
        for (String s : container2) {
            System.out.print(s + ' ');
        }
        System.out.println();
        if (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
        iter2.remove();
        for (String s : container2) {
            System.out.print(s + ' ');
        }
    }
}
