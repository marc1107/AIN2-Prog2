package pruefungsvorbereitung.klausurws20.aufgabe9;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;

class Stadt {
    public String name; // Name der Stadt
    public int ewz; // Einwohnerzahl
    public String land;

    public Stadt(String name, String land, int ewz) {
        this.name = name;
        this.land = land;
        this.ewz = ewz;
    }

    public String getName() {
        return this.name;
    }

    public int getEwz() {
        return this.ewz;
    }

    public String getLand() {
        return this.land;
    }

    public String toString() {
        return "name=" + name + ", ewz=" + ewz + ", land=" + land;
    }

    public static void main(String[] args) {
        List<Stadt> sLst = new LinkedList<>();
        sLst.add(new Stadt("Muenchen", "Deutschland", 1_484_226));
        sLst.add(new Stadt("Paris", "Frankreich", 2_175_601));
        sLst.add(new Stadt("Berlin", "Deutschland", 3_669_491));
        sLst.add(new Stadt("Mailand", "Italien", 1_396_059));
        sLst.add(new Stadt("Como", "Italien", 85_915));
        sLst.add(new Stadt("Konstanz", "Deutschland", 84_911));

        System.out.println("a)");
        sLst.stream()
                .sorted(Comparator.comparing((Stadt s) -> s.land)
                        .thenComparing((Stadt s) -> s.ewz).reversed())
                .forEach(System.out::println);

        System.out.println("b)");
        System.out.println(sLst.stream()
                .filter(s -> s.land.equals("Italien") && s.ewz < 100_000)
                        .count());

        System.out.println("c)");
        System.out.println(sLst.stream().max(Comparator.comparing(s -> s.ewz))
                        .get());
        System.out.println("d)");
        BinaryOperator<Integer> fun = (x, y) -> x >= y ? x : y;
        System.out.println(sLst.stream()
                .map(s -> s.ewz)
                .reduce(Integer.MIN_VALUE, fun));
    }
}
