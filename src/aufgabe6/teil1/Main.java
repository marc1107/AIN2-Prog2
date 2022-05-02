package aufgabe6.teil1;

public class Main {
    public static void main(String[] args) {
        // Tätigkeiten
        Taetigkeit tk1 = new paralleleTaetigkeit();
        tk1.add(new elementareTaetigkeit("Linke Seitenwand montieren", 5.0));
        tk1.add(new elementareTaetigkeit("Rechte Seitenwand montieren", 5.0));
        Taetigkeit tk2 = new paralleleTaetigkeit();
        tk2.add(new elementareTaetigkeit("Linke Türe montieren", 7.0));
        tk2.add(new elementareTaetigkeit("Rechte Türe mit Griff montieren", 9.0));
        Taetigkeit schrankMontage = new serielleTaetigkeit();
        schrankMontage.add(new elementareTaetigkeit("Füße an Boden montieren", 6.0));
        schrankMontage.add(tk1);
        schrankMontage.add(new elementareTaetigkeit("Decke montieren", 8.0));
        schrankMontage.add(tk2);
        System.out.println(schrankMontage.getTime() + " min"); // 28.0 min
        System.out.println(schrankMontage.getAnzahl()); // 6
    }
}
