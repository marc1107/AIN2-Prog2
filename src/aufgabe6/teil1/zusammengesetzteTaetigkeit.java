package aufgabe6.teil1;

import java.util.ArrayList;
import java.util.List;

public abstract class zusammengesetzteTaetigkeit implements Taetigkeit {
    protected List<Taetigkeit> meineTaetigkeiten = new ArrayList<Taetigkeit>();

    @Override
    public abstract double getTime();

    @Override
    public void add(Taetigkeit t) {
        meineTaetigkeiten.add(t);
    }

    @Override
    public void remove(Taetigkeit t) {
        meineTaetigkeiten.remove(t);
    }

    @Override
    public int getAnzahl() {
        int anzahl = 0;
        for (Taetigkeit t: meineTaetigkeiten) {
            anzahl += t.getAnzahl();
        }
        return anzahl;
    }
}
