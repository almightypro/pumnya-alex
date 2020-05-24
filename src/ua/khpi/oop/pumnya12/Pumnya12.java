package labs.pumnya12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import labs.pumnya07.SchedulerEvent;
import labs.pumnya09.GenericList;
import labs.pumnya10.Dialog;

public class Pumnya12 {
    private Pumnya12(){
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean isExit = false;
        List<String> list = Arrays.asList(args);
        boolean isAuto = list.contains("-auto");

        if (isAuto) {
            GenericList<SchedulerEvent> events = new GenericList<>();
            events.pushFront(SchedulerEvent.generate(false));
            SchedulerEvent event = new SchedulerEvent();
            event.setDate("20.05.2019");
            event.setDescription("Конференция.");
            event.setDuration(26);
            event.setTime("20:20");
            event.setVenue("Харьков.");
            event.setParticipants(new ArrayList<>(Arrays.asList("Алекс", "Другие")));
            events.pushFront(event);
            System.out.print("Данные:");
            System.out.println(events.toString());
            System.out.println("Поиск:");
            System.out.print(EventSearcher.searchEvents(events));
        } else {
            while (!isExit) {
                isExit = Dialog.run(false);
            }
        }
    }
}
