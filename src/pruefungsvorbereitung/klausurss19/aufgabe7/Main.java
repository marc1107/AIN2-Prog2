package pruefungsvorbereitung.klausurss19.aufgabe7;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Pruefung> prList = new LinkedList<>();
        prList.add(new Pruefung("Mueller", "Prog2", 1.3));
        prList.add(new Pruefung("Maier", "Prog2", 2.3));
        prList.add(new Pruefung("Mueller", "Symo", 2.0));
        prList.add(new Pruefung("Mueller", "Rarc", 1.0));
        prList.add(new Pruefung("Baier", "Rarc", 4.0));

        Map<String, Double> fTs = new TreeMap<>();
        Map<String, Set<String>> fTp = new TreeMap<>();

        for (Pruefung p: prList) {
            if (fTp.get(p.fach) == null) {
                fTp.put(p.fach, new TreeSet<>());
                fTs.put(p.fach, 0.0);
            }

            int n = fTp.get(p.fach).size();
            fTp.get(p.fach).add(p.name);
            fTs.put(p.fach, ((fTs.get(p.fach) * n + p.note) / (n + 1)));
        }

        System.out.println(fTs);
        System.out.println(fTp);
    }
}
