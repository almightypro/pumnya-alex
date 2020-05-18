package labs.pumnya10;

import labs.pumnya07.SchedulerEvent;
import java.util.Comparator;

public class SortByDuration extends SortFilter<SchedulerEvent> {
    public SortByDuration(Comparator<SchedulerEvent> comp) {
        super(comp);
    }

    @Override
    public int compare(SchedulerEvent o1, SchedulerEvent o2) {
        float result = o1.getDuration() - o2.getDuration();
        if (super.filter != null) {
            return filter.compare(o1, o2);
        }
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
