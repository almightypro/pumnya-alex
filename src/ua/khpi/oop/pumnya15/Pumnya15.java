package labs.pumnya15;

import labs.pumnya07.SchedulerEvent;
import labs.pumnya10.SortByPartAmount;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Pumnya15 {
    private Pumnya15() {
        // Пустое тело
    }

    public static void main (String[] args) throws IOException, ClassNotFoundException {
        boolean isExit = false;
        List<String> paramList = Arrays.asList(args);
        boolean isAuto = paramList.contains("-auto");
        if (isAuto) {
            LinkedList<SchedulerEvent> list = new LinkedList<>();
            list.add(SchedulerEvent.generate(false));
            SchedulerEvent event = new SchedulerEvent();
            event.setDate("20.05.2019");
            event.setDescription("Конференция.");
            event.setDuration(26);
            event.setTime("20:20");
            event.setVenue("Харьков.");
            event.setParticipants(new ArrayList<>(Arrays.asList("Алекс", "Другие")));
            list.add(event);
            System.out.println("Данные:");
            System.out.println(list.toString());
            System.out.println("Сортировка по количеству участников:");
            list.sort(new SortByPartAmount(null));
            System.out.println(list.toString());
            System.out.println("Serialization...");
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("DataFile.dat"));
            oos.writeObject(list);
            oos.close();
            System.out.println("Done!\n");
            System.out.println("Deserialization...");
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("DataFile.dat"));
            LinkedList list_copy =
                    (LinkedList) ois.readObject();
            ois.close();
            System.out.println("Прочитанные данные: ");
            System.out.println(list_copy.toString());
        } else {
            while (!isExit) {
                isExit = Dialog.run();
            }
        }
    }
}
