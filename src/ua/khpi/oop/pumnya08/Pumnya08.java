package labs.pumnya08;

import labs.pumnya07.SchedulerEvent;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public final class Pumnya08 {
    private Pumnya08() {
    }
    /**
     * Точка входа, главный метод.
     * @param args - аргументы главного метода
     * @throws IOException - при неудачной
     * работе с файлами
     * @throws ParseException - при неудачном
     * парса
     */
    public static void main(final String[] args)
            throws IOException, ParseException {
        SchedulerEvent[] events = new SchedulerEvent[0];
        Scanner in = new Scanner(System.in);
        String choice;
        do {
            UI.mainMenu();
            choice = UI.getChoice();
            switch (choice) {
                case "1":
                    events = UI.addEvent(events);
                    break;
                case "2":
                    System.out.print("Введите индекс"
                            + " удаляемого мероприятия: ");
                    int index = in.nextInt();
                    events = UI.dropEvent(events, index);
                    break;
                case "3":
                    UI.printInfo(events);
                    System.out.println();
                    break;
                case "4":
                    UI.saveToFile(events);
                    break;
                case "5":
                    try {
                        SchedulerEvent[] newEvents = UI.loadFromFile();
                        UI.printInfo(newEvents);
                    } catch (IOException e) {
                        System.out.println(e.toString());
                    }
                    break;
                case "0":
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Введите номер"
                            + " одного из пунктов!\n");
            }
        } while (!choice.equals("0"));
    }
}
