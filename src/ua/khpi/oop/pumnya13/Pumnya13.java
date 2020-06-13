package labs.pumnya13;

import labs.pumnya09.GenericList;
import java.util.Random;

public class Pumnya13 {
    private Pumnya13(){
    }

    public static void main(String[] args) {
        GenericList<Integer> numbers = new GenericList<>();

        for (int i = 0; i < 100000; i++) {
            numbers.pushBack(new Random().nextInt(100000));
        }
        Thread thr1 = new FirstThread(numbers, 0.2);
        Thread thr2 = new SecondThread(numbers, 0.2);
        Thread thr3 = new ThirdThread(numbers, 0.2);

        thr1.start();
        thr2.start();
        thr3.start();
    }
}
