package aufgabe4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private Node<T> begin;
    private Node<T> end;
    private int size;
    private int modCount;

    public LinkedListFrequencyTable() {
        this.modCount = 0;
        clear();
    }

    private static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private Element<T> element;

        public Node(Element<T> w, Node<T> n, Node<T> p) {
            element = w;
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
        this.modCount++;
    }

    @Override
    public void add(T w, int f) {
        Node<T> n = this.begin;
        for (int i = 0; i < this.size; i++) {
            n = n.next;
            if (n.element.getData().equals(w)) {
                n.element.addFrequency(f);
                moveToLeft(n);
                return;
            }
        }
        n.next = new Node(new Element(w, f), n.next, n);
        this.end.prev = n.next;

        // Muss nur sortiert werden, wenn der zweite oder mehr Einträge eingefügt wird
        //if (this.size > 0) {
            moveToLeft(n.next);
        //}

        this.size++;
        this.modCount++;
    }

    @Override
    public Element<T> get(int pos) {
        if (pos <= (this.size - 1)) {
            Node<T> n = this.begin;

            for (int i = 0; i <= pos; i++) {
                n = n.next;
            }
            return n.element;
        }
        return null;
    }

    @Override
    public int get(T w) {
        Node<T> n = this.begin;
        while (n.next != null) {
            n = n.next;

            if (n.element != null && n.element.getData().equals(w)) {
                return n.element.getFrequency();
            }
        }
        return 0;
    }

    // verschiebt das Objekt an der übergebenen Position an die richtige Position
    // von groß nach klein sortiert
    private void moveToLeft(Node<T> n) {
        // das letzte (neu hinzugefügte) Wort zwischen speichern
        Element<T> w = n.element;
        while (n.prev.prev != null && this.size > 0 && n.element.getFrequency() > n.prev.element.getFrequency()) {
            // Nur die Wörter tauschen und nicht die Referenzen (prev, next) auf die Wörter
            n.element = n.prev.element;
            n.prev.element = w;
            n = n.prev;
        }
    }

    @Override
    public Iterator<Element<T>> iterator() {
        return new LinkedListFrequencyTableIterator();
    }

    private class LinkedListFrequencyTableIterator implements Iterator<Element<T>>
    {
        private Node<T> current = begin;
        private int expectedMod = modCount;

        @Override
        public boolean hasNext()
        {
            return current.next != end;
        }

        @Override
        public Element<T> next()
        {
            if (expectedMod != modCount)
                throw new ConcurrentModificationException();

            current = current.next;
            return current.element;
        }

    }
}
