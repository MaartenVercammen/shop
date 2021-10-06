package domain;

import java.util.Comparator;

public class OrderListByClass implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1.getClass() == o2.getClass()) {
            return 0;
        }
        if (o1.getClass() == Movie.class) {
            return 1;
        }
        if (o2.getClass() == Movie.class) {
            return -1;
        }
        if (o1.getClass() == Game.class) {
            return 1;
        }
        if (o2.getClass() == Game.class) {
            return -1;
        }
        return 1;
    }
}
