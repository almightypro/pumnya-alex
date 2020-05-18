package labs.pumnya10;

import labs.pumnya07.SchedulerEvent;
import java.util.Comparator;

public class SortByPartAmount extends SortFilter<SchedulerEvent> {
    public SortByPartAmount(Comparator<SchedulerEvent> comp) {
        super(comp);
    }

    @Override
    public int compare(SchedulerEvent o1, SchedulerEvent o2) {
        int result = o1.getParticipants().size() - o2.getParticipants().size();
        if (super.filter != null) {
            return filter.compare(o1, o2);
        }
        return result;
    }
}
