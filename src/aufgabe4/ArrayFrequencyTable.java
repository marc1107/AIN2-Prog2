package aufgabe4;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *
 * @author oliverbittel
 * @since 25.03.2021
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private int size;
    private Element<T> fqTable[];
    private final int DEFAULT_SIZE = 100;
    private int modCount;

    public ArrayFrequencyTable() {
        this.modCount = 0;
        clear();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public final void clear() {
        this.fqTable = new Element[this.DEFAULT_SIZE];
        this.size = 0;
        this.modCount++;
    }

    @Override
    public void add(T w, int f) {
        for (int i = 0; i < this.size; i++) {
            if (this.fqTable[i].getData().equals(w)) {
                this.fqTable[i].addFrequency(f);
                moveToLeft(i);
                return;
            }
        }
        if (this.size >= this.fqTable.length) {
            fqTable = Arrays.copyOf(this.fqTable, this.size + DEFAULT_SIZE);
        }
        fqTable[this.size] = new Element(w, f);
        moveToLeft(this.size);
        this.size++;
        this.modCount++;
    }

    @Override
    public Element<T> get(int pos) {
        if (pos < size && pos >= 0)
            return this.fqTable[pos];

        return null;
    }

    @Override
    public int get(T w) {
        for (int i = 0; i < this.size; i++) {
            if (this.fqTable[i].getData().equals(w)) {
                return this.fqTable[i].getFrequency();
            }
        }
        return 0;
    }

    // verschiebt das Objekt an der übergebenen Position an die richtige Position
    // von groß nach klein sortiert
    private void moveToLeft(int pos) {
        Element w = fqTable[pos];
        int i = pos-1;

        while (i >= 0 && w.getFrequency() > fqTable[i].getFrequency()) {
            fqTable[i + 1] = fqTable[i];
            i--;
        }
        fqTable[i + 1] = w;
    }

    @Override
    public Iterator<Element<T>> iterator()
    {
        return new ArrayFrequencyTableIterator();
    }

    private class ArrayFrequencyTableIterator implements Iterator<Element<T>>
    {
        private int index = 0;
        private int expecxtedMod = modCount;

        @Override
        public boolean hasNext()
        {
            return index < size();
        }

        @Override
        public Element<T> next()
        {
            if (expecxtedMod != modCount)
                throw new ConcurrentModificationException();

            return fqTable[index++];
        }
    }
}