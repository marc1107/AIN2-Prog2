package aufgabe6.teil1;

public interface Taetigkeit {
    double getTime();
    void add(Taetigkeit t);
    void remove(Taetigkeit t) throws Exception;
    int getAnzahl();
}
