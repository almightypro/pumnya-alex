package labs.pumnya08;

import labs.pumnya07.SchedulerEvent;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UI {
    private UI() {
    }
    /** Для чтения данных с клавиатуры. */
    private static BufferedReader buffer = new BufferedReader(
            new InputStreamReader(System.in));
    /**
     * Главное меню.
     */
    public static void mainMenu() {
        System.out.println("1. Добавление мероприятия.");
        System.out.println("2. Удаление мероприятия.");
        System.out.println("3. Вывод информации.");
        System.out.println("4. Сохранить в файл.");
        System.out.println("5. Загрузить из файла.");
        System.out.println("0. Выход.");
        System.out.print("Введите ваш ответ сюда: ");
    }
    /**
     * Получение ответа диалогового меню.
     * @return ответ
     * @throws IOException при неудачном считывании
     */
    public static String getChoice() throws IOException {
        return buffer.readLine();
    }
    /**
     * Добавление мероприятия.
     * @param events - исходный набор мероприятий
     * @return новый набор мероприятий
     * @throws IOException при неудачном считывании
     * @throws ParseException при неудачном парсинге
     */
    public static SchedulerEvent[] addEvent(final SchedulerEvent[] events)
            throws IOException, ParseException {
        SchedulerEvent[] newEvents = new SchedulerEvent[events.length + 1];
        System.arraycopy(events, 0, newEvents, 0, events.length);
        newEvents[events.length] = SchedulerEvent.generate();
        return newEvents;
    }
    /**
     * Удаление мероприятия.
     * @param events - исходный набор мероприятий
     * @param pos - позиция удаляемого мероприятия
     * @return новый набор мероприятий
     */
    public static SchedulerEvent[] dropEvent(final SchedulerEvent[] events,
                                             final int pos) {
        if (pos >= events.length) {
            System.out.println("Error. Out of bounds.");
            return events;
        } else {
            SchedulerEvent[] newEvents = new SchedulerEvent[events.length - 1];
            int i = 0;
            for (int j = 0; j < events.length; j++) {
                if (j == pos) {
                    continue;
                } else {
                    newEvents[i] = events[j];
                    i++;
                }
            }
            return newEvents;
        }
    }
    /**
     * Вывод информации о мероприятиях.
     * @param events - набор мероприятий
     */
    public static void printInfo(final SchedulerEvent[] events) {
        for (int i = 0; i < events.length; i++) {
            System.out.format("%nМЕРОПРИЯТИЕ %d:%n", i + 1);
            System.out.println(events[i].printInfo());
        }
    }
    /**
     * Сохранение объекта в файл.
     * @param events - набор мероприятий
     * @throws IOException при неудачном
     * считывании или записи.
     */
    public static void saveToFile(final SchedulerEvent[] events)
            throws IOException {
        final String semi = ";";
        Pattern pattern = Pattern.compile(semi);
        Matcher matcher;
        String path;
        StringBuilder direct = new StringBuilder();
        System.out.print("Введите имя директории: ");
        while (true) {
            System.out.print(direct.toString());
            path = buffer.readLine();
            direct.append(path).append("\\");
            matcher = pattern.matcher(direct.toString());
            if (matcher.find()) {
                break;
            }
            File directory = new File(direct.toString());
            File[] list = directory.listFiles();
            if (list == null) {
                System.out.println("Неверное"
                        + " имя директории!");
                if (direct.length() != 0) {
                    direct.delete(
                            direct.length() - path.length() - 1,
                            direct.length());
                }
                continue;
            }
            System.out.println("---------------");
            for (File it : list) {
                if (it.isDirectory()) {
                    System.out.print(it.getName());
                    System.out.println(" (...)");
                    continue;
                }
                System.out.println(it.getName());
            }
            System.out.println("---------------");
        }
        String currentDir = direct.toString();
        currentDir = currentDir.replaceAll(semi, "");
        FileOutputStream fos = new FileOutputStream(
                currentDir + "\\Encoded.xml");
        XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(fos));
        xmlEncoder.writeObject(events);
        xmlEncoder.close();
    }
    /**
     * Загрузка объекта из файла.
     * @return массив объектов
     * @throws IOException при неудачном
     * считывании или записи.
     */
    public static SchedulerEvent[] loadFromFile() throws IOException {
        System.out.print("Введите имя директории: ");
        String dirToExtract = buffer.readLine();
        FileInputStream fis = new FileInputStream(dirToExtract);
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(fis));
        SchedulerEvent[] getEvents = (SchedulerEvent[]) xmlDecoder.readObject();
        xmlDecoder.close();
        return getEvents;
    }
}
