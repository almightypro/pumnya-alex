package labs.pumnya06;

import labs.pumnya05.MyContainer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MyContainerMod extends MyContainer {
    /** Identifying key for serialization. */
    private static final long serialVersionUID = 6126733392129125019L;
    /**
     * Compare elements for equality.
     * Prints elements and their number.
     */
    public void compare() {
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int countOfEqual = 0;
        int temp = 0;
        for (String s : buffer) {
            if (!arr.contains(s)) {
                arr.add(s);
                arr2.add(++countOfEqual);
            } else {
                arr2.set(arr.indexOf(s),
                         arr2.get(arr.indexOf(s)) + 1);
            }
            countOfEqual = temp;
        }
        if (arr.size() == 0) {
            System.out.println("There are no equal elements");
        } else {
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i) + ": " + arr2.get(i));
            }
        }
    }
    /**
     * Sorts elements of container.
     * @param comparator - type of sort
     */
    public void sort(final Comparator<String> comparator) {
        Arrays.sort(buffer, comparator);
    }
    /**
     * Search by given element.
     * @param string - searched string
     * @return an array of indexes of searched elements
     */
    public int[] search(final String string) {
        if (!this.contains(string)) {
            return null;
        }
        int size = 0;
        for (String s : buffer) {
            if (string.equals(s)) {
                size++;
            }
        }
        int[] searched = new int[size];
        int index = 0;
        for (int i = 0; i < buffer.length; i++) {
            if (string.equals(buffer[i])) {
                searched[index++] = i;
            }
        }
        return searched;
    }
    /**
     * Search by length of element.
     * @param length - length of element
     * @return an array of indexes of searched elements
     */
    public int[] search(final int length) {
        int size = 0;
        for (String s : buffer) {
            if (s.length() <= length) {
                size++;
            }
        }
        if (size == 0) {
            return null;
        }
        int[] searched = new int[size];
        int index = 0;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i].length() <= length) {
                searched[index++] = i;
            }
        }
        return searched;
    }
}
