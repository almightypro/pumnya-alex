package labs.pumnya05;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class MyContainer.
 * Contains the range of methods to manipulate a container.
 * Class is iterable - can be iterated element by element.
 *
 * @author Pumnya Alexander
 */
public class MyContainer implements Iterable<String> {
    /** Holds the elements of a container. */
    private String[] buffer = null;

    /**
     * Method concatenates all container elements into a string.
     * @return container in a string
     */
    @Override
    public String toString() {
        if (buffer == null || buffer.length == 0) {
            return null;
        } else {
            StringBuilder builder = new StringBuilder();
            for (String i : buffer) {
                builder.append(i).append(' ');
            }
            return builder.toString();
        }
    }
    /**
     *  Method for adding elements to a container.
     *  @param str - string to initialize a new container element
     */
    public void add(final String str) {
        if (buffer == null) {
            buffer = new String[1];
            buffer[0] = str;
        } else {
            buffer = Arrays.copyOf(buffer, buffer.length + 1);
            buffer[buffer.length - 1] = str;
        }
    }
    /**
     * Method for resetting a container.
     */
    public void clear() {
        buffer = new String[0];
    }
    /**
     * Method for removing an exact element by string criteria.
     * @return false if removing cannot be done(no elements in container)
     *         true if element has been found and successfully deleted
     * @param str - string to specify the element to remove
     */
    public boolean remove(final String str) {
        if (buffer == null || buffer.length == 0) {
            return false;
        }
        String[] newBuffer = new String[buffer.length - 1];
        int index;
        for (index = 0; index < buffer.length; index++) {

            if (buffer[index].equals(str)) {
                break;
            } else if (index == buffer.length - 1) {
                return false;
            }
        }
        int j = 0;
        for (int k = 0; k < buffer.length; k++) {
            if (k == index) {
                continue;
            }
            newBuffer[j++] = buffer[k];
        }
        buffer = Arrays.copyOf(newBuffer, newBuffer.length);
        return true;
    }
    /**
     * Method for converting container to an array.
     * @return an array of container elements
     */
    public String[] toArray() {
        if (buffer == null) {
            return null;
        }
        return Arrays.copyOf(buffer, buffer.length);
    }
    /**
     * Method for receiving the size of container.
     * @return current container size
     */
    public int size() {
        if (buffer == null) {
            return 0;
        }
        return buffer.length;
    }
    /**
     * Method for checking a container elements with a specified string.
     * @param str - string to find in a container
     * @return true if contains, false if does not contain
     */
    public boolean contains(final String str) {
        if (buffer == null || buffer.length == 0) {
            return false;
        }
        for (String i : buffer) {
            if (i.equals(str)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Method for checking the equality of two containers.
     * @param container - for comparing with another container
     * @return true if both containers are the same
     * false if they are different
     */
    public boolean containsAll(final MyContainer container) {
        if (buffer == null || buffer.length == 0) {
            return false;
        }
        int equation = 0;
        String[] toCompare;
        toCompare = container.toArray();
        for (int i = 0; i < container.size(); i++) {
            if (this.contains(toCompare[i])) {
                equation++;
            }
        }
        return equation == container.size();
    }
    /**
     * Method for creating a correct iterator.
     * @return a new iterator to a Container object
     */
    @Override
    public MyIterator iterator() {
        return new MyIterator(buffer);
    }
    /**
     * Class MyIterator.
     * Contains two fields of lower and higher bound of a container.
     * Constructor gets a storage field from Container and defines
     * both bounds.
     * Contains methods for iterating over a container,
     * checking the existence of the next element and removing.
     * @author Pumnya Alexander
     */
    public class MyIterator implements Iterator<String> {
        /** Lower bound of a container. */
        private int lowerBound;
        /** Higher bound of a container. */
        private int higherBound;
        /**
         * Constructor for processing the container data.
         * Defines values of lower and higher bound.
         * @param buf - array of container elements
         */
        MyIterator(final String[] buf) {
            lowerBound = -1;
            higherBound = buf.length-1;
        }
        /**
         * Method checks the existence of the next element.
         * @return true if the next element exists
         * false if it doesn't exist
         */
        @Override
        public boolean hasNext() {
            return lowerBound < higherBound;
        }
        /**
         * Method for moving further through the container.
         * @return current iterated element
         */
        @Override
        public String next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                lowerBound++;
                return buffer[lowerBound];
            }
        }
        /**
         * Method for removing the current element from iteration.
         */
        @Override
        public void remove() {
            String[] copyBuffer = Arrays.copyOf(buffer,
                                                buffer.length);
            buffer = new String[buffer.length - 1];
            int j = 0;
            for (int i = 0; i < copyBuffer.length; i++) {
                if (i != lowerBound) {
                    buffer[j++] = copyBuffer[i];
                }
            }
            higherBound--;
        }
    }
}

