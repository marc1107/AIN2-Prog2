package aufgabe6.teil1;

public class paralleleTaetigkeit extends zusammengesetzteTaetigkeit {
    public double getTime() {
        double time = 0.0;
        for (Taetigkeit t: meineTaetigkeiten) {
            if (t.getTime() > time) {
                time = t.getTime();
            }
        }
        return time;
    }
}
