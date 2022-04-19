package aufgabe4;

/**
 *
 * @author oliverbittel
 * @since 12.2.2020
 */
public interface FrequencyTable<T> extends Iterable<Element<T>> {
    /**
     * Liefert die Anzahl der Wörter in dieser Tabelle zurück.
     * @return Anzahl der Häufigkeitseinträge.
     */
    int size();

    /**
     * Prüft, ob die Tabelle leer ist.
     * @return true, falls diese Tabelle leer ist, sonst false.
     */
    boolean isEmpty();

    /**
     * Löscht die Tabelle.
     */
    void clear();

    /**
     * Fügt das Wort w mit der Häufigkeit f zu dieser Tabelle dazu.
     * Falls w bereits in der Tabelle enthalten ist,
     * wird die Häufigkeit um f erhöht.
     * @param w Wort.
     * @param f Häufigkeit.
     */
    void add(T w, int f);

    /**
     * Fügt das Wort w mit der Häufigkeit 1 zu dieser Tabelle dazu.
     * Falls w bereits in der Tabelle enthalten ist,
     * wird die Häufigkeit um 1 erhöht.
     * @param w Wort.
     */
    void add(T w);

    /**
     * Fügt alle Wörter mit ihren Häufigkeiten aus fq zu dieser Tabelle dazu.
     * Häufigkeiten für gleiche Wörter werden addiert.
     * fq bleibt unverändert.
     * @param fq Häufigkeitstabelle.
     */
    void addAll(FrequencyTable<? extends T> fq);

    /**
     * Liefert das Wort mit seiner Häufigkeit zurück, das mit seiner Häufigkeit an Position pos steht.
     * get(0) liefert das häufigste Wort zurück,
     * get(1) liefert das zweithäufigste Wort zurück, usw.
     * @param pos Position.
     * @return Wort mit Häufigkeit oder null,
     * falls die Tabelle weniger als pos-1 Elemente  enthält.
     */
    Element get(int pos);

    /**
     * Liefert die Häufigkeit des Worts w zurück.
     * Falls das Wort nicht vorkommt, wird 0 zurückgeliefert.
     * @param w Wort
     * @return Häufigkeit.
     */
    int get(T w);

    /**
     * Sammelt alle Wörter mit der gr&ouml;ssten Häufigkeit und speichert sie in fq.
     * Beispiel:
     * Falls tab1 = {"ein":3, "das":3, "ist":2, "der:1", "die":1}, dann
     * gilt nach Aufruf von tab1.collectMostFrequent(tab2):
     * tab2 = {"ein":3, "das":3}.
     * @param fq Häufigkeitstabelle.
     */
    void collectMostFrequent(FrequencyTable<? super T> fq);

    /**
     * Sammelt alle Wörter mit der Häufigkeit 1 und speichert sie in fq.
     * @param fq Häufigkeitstabelle.
     */
    void collectLeastFrequent(FrequencyTable<? super T> fq);
}