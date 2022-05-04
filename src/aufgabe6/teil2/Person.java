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
        if (this.ausgelieheneBuecher.contains(b))
            return false;

        if(b.getEntleiher() != null && b.getEntleiher() != this)
            return false;

        b.wirdAusgeliehen(this);
        ausgelieheneBuecher.add(b);
        return true;
    }

    public boolean gibtZurueck(Buch b) {
        if (!this.ausgelieheneBuecher.contains(b))
            return false;

        this.ausgelieheneBuecher.remove(b);
        b.wirdZurueckGegeben();
        return true;
    }

    public void print() {
        System.out.printf("Name: %s ------- Ausgeliehene Bücher: ", this.name);
        for (Buch b: ausgelieheneBuecher) {
            System.out.printf("%s, ", b.getName());
        }
        System.out.println();
    }
}
