package pruefungsvorbereitung.klausurss19.aufgabe4;

import java.util.LinkedList;
import java.util.List;

public class NestedList {
    public static void main(String[] args) {
        List<Object> nestedList = new LinkedList<>();
        nestedList.add(5);
        nestedList.add(2.3);
        List<Number> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2.1);
        List<Number> l2 = new LinkedList<>();
        l2.add(3.1);
        l2.add(5.2);
        List<Object> l12 = new LinkedList<>();
        l12.add(l1);
        l12.add(l2);
        nestedList.add(l12);

        List<Number> dst = new LinkedList<>();

        flatten(nestedList, dst);
    }

    static void flatten(List<?> src, List<? super Number> dst) { // Warum "? super"
        for (Object o: src) {
            if (o instanceof List) {
                flatten((List) o, dst);
            } else if (o instanceof Number) {
                dst.add((Number) o);
            }
        }
    }

}
