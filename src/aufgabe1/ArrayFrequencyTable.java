package aufgabe1;

import java.util.Arrays;

/**
 *
 * @author oliverbittel
 * @since 25.03.2021
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {
    private int size;
    private Word fqTable[];
    private final int DEFAULT_SIZE = 100;

    public ArrayFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public final void clear() {
        this.fqTable = new Word[this.DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public void add(String w, int f) {
        for (int i = 0; i < this.size; i++) {
            if (this.fqTable[i].getWord().equals(w)) {
                this.fqTable[i].addFrequency(f);
                moveToLeft(i);
                return;
            }
        }
        if (this.size >= this.fqTable.length) {
            /*Word temp[] = new Word[this.size + DEFAULT_SIZE];
            System.arraycopy(fqTable, 0, temp, 0, this.size);
            this.fqTable = temp;*/
            fqTable = Arrays.copyOf(this.fqTable, this.size + DEFAULT_SIZE);
        }
        fqTable[this.size] = new Word(w, f);
        moveToLeft(this.size);
        this.size++;
    }

    @Override
    public Word get(int pos) {
        if (pos < size && pos >= 0)
            return this.fqTable[pos];

        return null;
    }

    @Override
    public int get(String w) {
        for (int i = 0; i < this.size; i++) {
            if (this.fqTable[i].getWord().equals(w)) {
                return this.fqTable[i].getFrequency();
            }
        }
        return 0;
    }

    // verschiebt das Objekt an der übergebenen Position an die richtige Position
    // von groß nach klein sortiert
    private void moveToLeft(int pos) {
        Word w = fqTable[pos];
        int i = pos-1;

        while (i >= 0 && w.getFrequency() > fqTable[i].getFrequency()) {
            fqTable[i + 1] = fqTable[i];
            i--;
        }
        fqTable[i + 1] = w;
    }
}