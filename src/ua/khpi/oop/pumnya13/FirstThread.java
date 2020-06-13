package labs.pumnya13;

import labs.pumnya09.GenericList;

public class FirstThread extends Thread {
    /** Принимает список в виде массива. */
    private int[] listToArr;
    /**
     * Значение таймера.
     * Поток работает, пока это значение больше 0-я.
     */
    private double timeOut;
    /** Простой конструктор. */
    public FirstThread() {
    }
    /**
     * Конструктор с параметрами.
     * Устанавливает список значений, а также таймер.
     * @param list данные для обработки
     * @param timeOut устанавливает значение таймера
     */
    public FirstThread(GenericList<Integer> list, double timeOut) {
        this.timeOut = timeOut;
        Object[] temp = list.toArray();
        this.listToArr = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            this.listToArr[i] = (int) temp[i];
        }
    }
    /**
     * Переопределение метода запуска потока.
     * Поиск кол-ва четных и нечетных значений в массиве чисел.
     */
    @Override
    public void run() {
        long startTime = System.nanoTime();
        int even = 0, odd = 0;
        for (int i = 0; i < listToArr.length; i++) {
            if (listToArr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            long timeTotal = System.nanoTime() - startTime;
            try {
                double convert = timeTotal*10e-9;
                if(convert > timeOut) {
                    throw new Exception();
                }
            } catch (Exception e) {
                this.interrupt();
                System.out.println("FirstThread был прерван!");
                return;
            }
        }
        System.out.println("Четные: " + even + " | Нечетные: " + odd);
    }
}
