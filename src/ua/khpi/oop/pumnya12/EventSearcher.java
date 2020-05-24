package labs.pumnya12;

import labs.pumnya07.SchedulerEvent;
import labs.pumnya09.GenericList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Знайти всі конференції, що пройшли за останні три роки в Харкові та області з тривалістю не менше доби. */

public class EventSearcher {
    private EventSearcher(){
    }

    public static String searchEvents(final GenericList<SchedulerEvent> list) {
        SchedulerEvent[] events = dayOrMore(list);
        StringBuilder found = new StringBuilder();
        for (SchedulerEvent event : events) {
            if (event != null) {
                found.append(event.toString()).append("\n");
            }
        }
        if (found.length() == 0) {
            return "Ничего не найлено!\n";
        }
        return found.toString();
    }

    private static SchedulerEvent[] dayOrMore(final GenericList<SchedulerEvent> list) {
        SchedulerEvent[] inKharkov = inKharkov(list);
        SchedulerEvent[] events = new SchedulerEvent[inKharkov.length];
        for (int i = 0, j = 0; i < inKharkov.length; i++) {
            if (inKharkov[i] != null) {
                events[j++] = inKharkov[i];
            }
        }
        for (int i = 0; i < events.length; i++) {
            if (events[i] != null) {
                if (events[i].getDuration() < 24) {
                    events[i] = null;
                }
            }
        }
        return events;
    }

    private static SchedulerEvent[] inKharkov(final GenericList<SchedulerEvent> list) {
        SchedulerEvent[] lastYears = lastYears(list);
        SchedulerEvent[] events = new SchedulerEvent[lastYears.length];
        for (int i = 0, j = 0; i < lastYears.length; i++) {
            if (lastYears[i] != null) {
                events[j++] = lastYears[i];
            }
        }
        Pattern pattern;
        Matcher matcher;
        final String REGEX = "(^Х)арьков(ская область)?(\\.|$)";
        pattern = Pattern.compile(REGEX);
        for (int i = 0; i < events.length; i++) {
            if (events[i] != null) {
                matcher = pattern.matcher(events[i].getVenue());
                if (!matcher.matches()) {
                    events[i] = null;
                }
            }
        }
        return events;
    }

    private static SchedulerEvent[] lastYears(final GenericList<SchedulerEvent> list) {
        Object[] arr = list.toArray();
        SchedulerEvent[] events = new SchedulerEvent[arr.length];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                events[j++] = (SchedulerEvent) arr[i];
            }
        }
        Pattern pattern;
        Matcher matcher;
        final String REGEX_BOUNDS = "^[201]{3}[7-9]";
        pattern = Pattern.compile(REGEX_BOUNDS);
        for (int i = 0; i < events.length; i++) {
            matcher = pattern.matcher(events[i].getDate().substring(6, 10));
            if (!matcher.matches()) {
                events[i] = null;
            }
        }
        return events;
    }
}
