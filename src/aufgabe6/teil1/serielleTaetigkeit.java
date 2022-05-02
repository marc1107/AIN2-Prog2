package aufgabe6.teil1;

public class serielleTaetigkeit extends zusammengesetzteTaetigkeit {
    public double getTime() {
        double time = 0.0;
        for (Taetigkeit t: meineTaetigkeiten) {
            time += t.getTime();
        }
        return time;
    }
}
