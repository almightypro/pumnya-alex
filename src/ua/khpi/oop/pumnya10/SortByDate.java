package labs.pumnya10;

import labs.pumnya07.SchedulerEvent;
import java.util.Comparator;

public class SortByDate extends SortFilter<SchedulerEvent> {
    public SortByDate(Comparator<SchedulerEvent> comp) {
        super(comp);
    }

    @Override
    public int compare(SchedulerEvent o1, SchedulerEvent o2) {
        String[] ymd1 = o1.getDate().split("\\.");
        String[] ymd2 = o2.getDate().split("\\.");
        int result = ymd1[2].compareTo(ymd2[2]);
        if (result == 0) {
            result = ymd1[1].compareTo(ymd2[1]);
            if (result == 0) {
                result = ymd1[0].compareTo(ymd2[0]);
            }
        } else if (super.filter != null) {
            return filter.compare(o1, o2);
        }
        return result;
    }
}
