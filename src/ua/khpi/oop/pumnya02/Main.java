package ua.khpi.oop.pumnya02;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(Integer.MAX_VALUE);
        ArrayList<Integer> minNums = new ArrayList<Integer>();
        findMinNums(number, minNums);
        printInfo(number, minNums);
    }

    private static void findMinNums(int number, ArrayList<Integer> array) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (number > 0) {
            arr.add(0, number % 10);
            number /= 10;
        }
        int min = Collections.min(arr);
        for(int i = 0; i < arr.size(); i++)
            if(arr.get(i) == min) array.add(i);
    }

    private static void printInfo(int number, ArrayList<Integer> array) {
        System.out.format("Input: %d%n", number);
        System.out.print("Output: ");
        for(int i : array) {
            System.out.format("%d ", i);
        }
    }
}
