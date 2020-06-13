package labs.pumnya13;

import labs.pumnya09.GenericList;

public class ThirdThread extends Thread {
    /** Принимает список в виде массива. */
    private int[] listToArr;
    /**
     * Значение таймера.
     * Поток работает, пока это значение больше 0-я.
     */
    private double timeOut;
    /** Простой конструктор. */
    public ThirdThread() {
    }
    /**
     * Конструктор с параметрами.
     * Устанавливает список значений, а также таймер.
     * @param list данные для обработки
     * @param timeOut устанавливает значение таймера
     */
    public ThirdThread(GenericList<Integer> list, double timeOut) {
        this.timeOut = timeOut;
        Object[] temp = list.toArray();
        this.listToArr = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            this.listToArr[i] = (int) temp[i];
        }
    }
    /**
     * Переопределение метода запуска потока.
     * Поиск минимального и максимального значения.
     */
    @Override
    public void run() {
        long startTime = System.nanoTime();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < listToArr.length; i++) {
            if (min > listToArr[i]) {
                min = listToArr[i];
            } else if (max < listToArr[i]) {
                max = listToArr[i];
            }
            long timeTotal = System.nanoTime() - startTime;
            try {
                double convert = timeTotal*10e-9;
                if(convert > timeOut) {
                    throw new Exception();
                }
            } catch (Exception e) {
                this.interrupt();
                System.out.println("ThirdThread был прерван!");
                return;
            }
        }
        System.out.println("Min: " + min + " | Max: " + max);
    }
}
