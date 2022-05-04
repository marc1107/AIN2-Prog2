package aufgabe6.teil2;

public class Buch {
    private final String name;
    private Person entleiher;

    public Buch (String name) {
        this.name = name;
        this.entleiher = null;
    }

    public String getName() {
        return this.name;
    }

    public Person getEntleiher() {
        return this.entleiher;
    }

    public boolean wirdAusgeliehen(Person p) {
        if (this.entleiher == null) {
            this.entleiher = p;
            p.leihtAus(this);
            return true;
        }
        return false;
    }

    public boolean wirdZurueckGegeben() {
        if (this.entleiher != null) {
            Person p = this.entleiher;
            this.entleiher = null;
            p.gibtZurueck(this);
            return true;
        }
        return false;
    }

    public void print() {
        if (this.entleiher != null) {
            System.out.printf("Buch: %s, Entleiher: %s\n", this.name, getEntleiher().getName());
        } else {
            System.out.printf("Buch: %s, Entleiher: Niemand\n", this.name);
        }
    }
}
