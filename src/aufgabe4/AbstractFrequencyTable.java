package aufgabe4;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void add(T w) {
        add(w, 1);
    }

    @Override
    public void addAll(FrequencyTable<? extends T> fq) {
        for (Element<? extends T> element : fq) {
            add(element.getData(), element.getFrequency());
        }
    }

    @Override
    public void collectMostFrequent(FrequencyTable<? super T> fq) {
        fq.clear();

        for (Element<T> element : this) {
            if (this.get(0).getFrequency() > element.getFrequency()) {
                return;
            }
            fq.add(element.getData(), element.getFrequency());
        }
    }

    @Override
    public void collectLeastFrequent(FrequencyTable<? super T> fq) {
        fq.clear();

        for (Element<T> element : this) {
            if (this.get(size() - 1).getFrequency() == element.getFrequency()) {
                fq.add(element.getData(), element.getFrequency());
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