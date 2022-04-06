package aufgabe2;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable implements FrequencyTable {
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void add(String w) {
        add(w, 1);
    }

    @Override
    public void addAll(FrequencyTable fq) {
        for (int i = 0; i < fq.size(); i++) {
            add(fq.get(i).getWord(), fq.get(i).getFrequency());
        }
    }

    @Override
    public void collectMostFrequent(FrequencyTable fq) {
        fq.clear();

        for (int i = 0; i < this.size(); i++) {
            if (this.get(0).getFrequency() > this.get(i).getFrequency()) {
                return;
            }
            fq.add(this.get(i).getWord(), this.get(i).getFrequency());
        }
    }

    @Override
    public void collectLeastFrequent(FrequencyTable fq) {
        fq.clear();

        for (int i = 0; i < this.size(); i++) {
            if (this.get(size() - 1).getFrequency() == this.get(i).getFrequency()) {
                fq.add(this.get(i).getWord(), this.get(i).getFrequency());
            }
        }
    }

    /**
     * Liefert eine String-Darstellung zurück.
     * @return String-Darstellung.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");

        s.append("{");
        for (int i = 0; i < size(); i++) {
            s.append(this.get(i)).append(", ");
        }
        s.append("} size = ").append(size());

        return s.toString();
    }
}