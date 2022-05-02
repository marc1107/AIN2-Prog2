package aufgabe6.teil1;

public class elementareTaetigkeit implements Taetigkeit {
    private double time;
    private String beschr;

    public elementareTaetigkeit(String beschr, double time) {
        this.time = time;
        this.beschr = beschr;
    }

    @Override
    public double getTime() {
        return this.time;
    }

    @Override
    public void add(Taetigkeit t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Taetigkeit t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getAnzahl() {
        return 1;
    }
}
