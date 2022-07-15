package pruefungsvorbereitung.klausurws17.aufgabe9;

import java.util.LinkedList;
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        LinkedList<LV> lvList = new LinkedList<>();
        lvList.add(new LV("Prog2", 2, 30));
        lvList.add(new LV("Prog1", 1, 50));

        BiPredicate<LV, Integer> findetStatt = (lv, sem) -> lv.sem == sem;

        System.out.println(lvList);

        //lvList.removeIf(lv -> !findetStatt.test(lv, 2));
        //lvList.removeIf(lv -> findetStatt.negate().test(lv, 2));
        //lvList.removeIf(lv -> findetStatt.test(lv, 2));

        lvList.stream().mapToInt(lv -> lv.anzStud).max();

        System.out.println(lvList);
    }
}
