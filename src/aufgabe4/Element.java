package aufgabe4;

/**
 * Klasse fÃ¼r WÃ¶rter mit ihren HÃ¤ufigkeiten.
 * @author oliverbittel
 * @since 22.3.2019
 */
public class Element<T> {
    final private T data;
    private int frequency;

    /**
     * Konstruktor.
     * @param data Data
     * @param f H&auml;ufgkeit
     */
    public Element(T data, int f) {
        this.data = data;
        this.frequency = f;
    }

    /**
     * Liefert Wort zur&uuml;ck.
     * @return Wort
     */
    public T getData() {
        return data;
    }

    /**
     * Liefert H&auml;ufgkeit zur&uuml;ck.
     * @return H&auml;ufgkeit
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Addiert zur H&auml;ufgkeit f dazu.
     * @param f H&auml;ufgkeits&auml;nderung.
     */
    public void addFrequency(int f) {
        frequency += f;
    }

    /**
     * Liefert eine String-Darstellung zur&uuml;ck.
     * @return String-Darstellung.
     */
    @Override
    public String toString() {
        return data + ":" + frequency;
    }
}