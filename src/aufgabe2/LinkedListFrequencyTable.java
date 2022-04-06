package aufgabe2;

public class LinkedListFrequencyTable extends AbstractFrequencyTable {
    private Node begin;
    private Node end;
    private int size;

    public LinkedListFrequencyTable() {
        clear();
    }

    private static class Node {
        private Node next;
        private Node prev;
        private Word word;

        public Node(Word w, Node n, Node p) {
            word = w;
            next = n;
            prev = p;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.end = new Node(null, null, null);
        this.begin = new Node(null, this.end, null);
        this.end.prev = this.begin;
        this.size = 0;
    }

    @Override
    public void add(String w, int f) {
        Node n = this.begin;
        for (int i = 0; i < this.size; i++) {
            n = n.next;
            if (n.word.getWord().equals(w)) {
                n.word.addFrequency(f);
                moveToLeft(n);
                return;
            }
        }
        n.next = new Node(new Word(w, f), n.next, n);
        this.end.prev = n.next;

        // Muss nur sortiert werden, wenn der zweite oder mehr Einträge eingefügt wird
        //if (this.size > 0) {
            moveToLeft(n.next);
        //}

        this.size++;
    }

    @Override
    public Word get(int pos) {
        if (pos <= (this.size - 1)) {
            Node n = this.begin;

            for (int i = 0; i <= pos; i++) {
                n = n.next;
            }
            return n.word;
        }
        return null;
    }

    @Override
    public int get(String w) {
        Node n = this.begin;
        while (n.next != null) {
            n = n.next;

            if (n.word != null && n.word.getWord().equals(w)) {
                return n.word.getFrequency();
            }
        }
        return 0;
    }

    // verschiebt das Objekt an der übergebenen Position an die richtige Position
    // von groß nach klein sortiert
    private void moveToLeft(Node n) {
        // das letzte (neu hinzugefügte) Wort zwischen speichern
        Word w = n.word;
        while (n.prev.prev != null && this.size > 0 && n.word.getFrequency() > n.prev.word.getFrequency()) {
            // Nur die Wörter tauschen und nicht die Referenzen (prev, next) auf die Wörter
            n.word = n.prev.word;
            n.prev.word = w;
            n = n.prev;
        }
    }
}
