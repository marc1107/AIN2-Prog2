package aufgabe11.aufg2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Person {
    private String vorname;
    private String nachname;
    private LocalDate geb;

    public Person(String vn, String nn, LocalDate geb) {
        this.vorname = vn;
        this.nachname = nn;
        this.geb = geb;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public LocalDate getGeb() {
        return geb;
    }

    public void setGeb(LocalDate geb) {
        this.geb = geb;
    }

    @Override
    public String toString() {
        return vorname + " " + nachname + ": " + geb.toString();
    }

    public static void main(String[] args) {
        List<Person> persList = new LinkedList<>();
        persList.add(new Person("Marc", "Bohner", LocalDate.of(1999, 7, 11)));
        persList.add(new Person("Jürgen", "Müller", LocalDate.of(2005, 11, 22)));
        persList.add(new Person("Kim", "Weiler", LocalDate.of(2000, 8, 30)));
        persList.add(new Person("Mia", "Toretto", LocalDate.of(2001, 1, 1)));
        persList.add(new Person("Armin", "Richter", LocalDate.of(1996, 5, 5)));
        persList.add(new Person("Erik", "Feuser", LocalDate.of(1990, 6, 7)));
        persList.add(new Person("Marco", "Sugg", LocalDate.of(2007, 2, 26)));
        persList.add(new Person("Alex", "Holdt", LocalDate.of(2000, 12, 19)));
        persList.add(new Person("Axel", "Straub", LocalDate.of(2001, 8, 8)));
        persList.add(new Person("Alicia", "Kessler", LocalDate.of(1994, 5, 7)));

        Predicate<Person> istErwachsen = p -> (p.getGeb().isBefore(LocalDate.now().minusYears(18)));

        System.out.println("Alle volljährig: " + alleErwachsen(persList, istErwachsen));

        System.out.println(persList);

        persList.sort((Person p1, Person p2) -> p1.getGeb().compareTo(p2.getGeb()));
        System.out.println(persList);

        // ist das Gleiche (wird von IntelliJ vorgeschlagen): persList.sort(Comparator.comparing(Person::getGeb));
        persList.sort(Comparator.comparing(Person::getGeb).reversed());
        System.out.println(persList);

        persList.stream().filter(istErwachsen).sorted((Person p1, Person p2) -> p1.getGeb().compareTo(p2.getGeb()))
                .forEach((Person person) -> System.out.println(person.getGeb()));

        persList.stream().filter(p -> p.getVorname().startsWith("A"))
                .sorted(Comparator.comparing(Person::getGeb)).limit(3).forEach(System.out::println);
    }

    private static boolean alleErwachsen(List<Person> persList, Predicate<Person> istErwachsen) {
        for (Person p : persList) {
            if (!istErwachsen.test(p)) {
                return false;
            }
        }
        return true;
    }
}
