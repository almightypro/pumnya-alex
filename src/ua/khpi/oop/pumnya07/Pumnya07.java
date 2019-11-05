package labs.pumnya07;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public final class Pumnya07 {
    private Pumnya07() {
    }
    /**
     * Точка входа.
     * @param args - аргументы функции
     * @throws ParseException если не удалось
     * спарсить дату или время
     * @throws IOException - при
     * некорректном считывании
     */
    public static void main(final String[] args)
            throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Сколько мероприятий"
                       + " добавить? ");
        int size = scan.nextInt();
        scan.nextLine();
        SchedulerEvent[] events = new SchedulerEvent[size];
        for (int i = 0; i < events.length; i++) {
            System.out.format("МЕРОПРИЯТИЕ %d:%n", i + 1);
            events[i] = SchedulerEvent.generate();
        }
        System.out.println();
        for (int i = 0; i < events.length; i++) {
            System.out.format("МЕРОПРИЯТИЕ %d:%n", i + 1);
            events[i].printInfo();
            System.out.println();
        }
    }
}
