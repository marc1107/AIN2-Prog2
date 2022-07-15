package pruefungsvorbereitung.klausurws20.aufgabe4;

public class QueueInstr extends Queue {
    int count;

    public QueueInstr() {
        super();
    }

    @Override
    public void offer(int x) {
        super.offer(x);
        count++;
    }

    public int get() {
        return count;
    }
}
