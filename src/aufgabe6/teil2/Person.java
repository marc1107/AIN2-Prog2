package aufgabe6.teil2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final List<Buch> ausgelieheneBuecher = new ArrayList<>();

    public Person (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean leihtAus(Buch b) {
        if (b.wirdAusgeliehen(this)) {
            ausgelieheneBuecher.add(b);
            return true;
        }
        return false;
    }

    public boolean gibtZurueck(Buch b) {
        for (Buch b2: ausgelieheneBuecher) {
            if (b.equals(b2) && b.wirdZurueckGegeben()) {
                ausgelieheneBuecher.remove(b);
                return true;
            }
        }
        return false;
    }

    public void print() {
        System.out.printf("Name: %s\tAusgeliehene Bücher: ", this.name);
        for (Buch b: ausgelieheneBuecher) {
            System.out.printf("%s, ", b.getName());
        }
        System.out.println();
    }
}
