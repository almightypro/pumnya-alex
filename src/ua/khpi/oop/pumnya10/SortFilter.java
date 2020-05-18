package labs.pumnya10;

import java.util.Comparator;

public abstract class SortFilter<T> implements Comparator<T> {
    /** Фильтр компаратора. */
    Comparator <T> filter;
    public SortFilter(Comparator <T> comp) {
        filter = comp;
    }
}
