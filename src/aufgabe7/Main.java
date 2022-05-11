package aufgabe7;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // Test 1 (200 Zahlen sortieren???)
        Integer[] test1 = {174, 130, 29, 182, 53, 162, 157, 154, 22, 59, 55, 28, 27,
                129, 59, 63, 2, 182, 149, 197, 180, 187, 41, 22, 161, 67, 103, 17, 145,
                36, 199, 157, 153, 113, 159, 191, 138, 85, 170, 91, 148, 190, 3, 133, 52,
                167, 67, 27, 78, 105, 174, 49, 192, 52, 189, 22, 185, 85, 167, 124, 144,
                54, 72, 131, 100, 97, 88, 1, 131, 99, 94, 129, 133, 118, 25, 198, 73, 60,
                106, 7, 105, 52, 115, 175, 188, 25, 196, 43, 100, 123, 151, 186, 44, 2,
                167, 129, 162, 134, 27, 111, 31, 25, 124, 80, 27, 118, 148, 134, 26, 64,
                64, 97, 2, 84, 12, 142, 135, 18, 156, 191, 184, 68, 195, 6, 197, 72, 105,
                75, 42, 104, 36, 145, 14, 10, 192, 3, 45, 12, 157, 3, 103, 64, 76, 168,
                55, 141, 19, 158, 33, 184, 59, 56, 77, 35, 148, 196, 43, 26, 196, 39, 187,
                79, 121, 156, 96, 18, 49, 130, 117, 196, 63, 184, 180, 120, 167, 69, 29,
                131, 34, 106, 98, 135, 198, 163, 52, 116, 160, 58, 66, 78, 3, 157, 22, 137,
                188, 176, 56, 175, 194, 56,};

        System.out.println("Test 1:");
        System.out.println("Unsortiert:");
        for (Integer integer : test1) {
            System.out.print(integer + "; ");
        }

        long start = System.nanoTime(); // aktuelle Zeit in nsec
        // Sortieren
        HybridQS.hybridQuickSort(test1);
        long end = System.nanoTime();
        double elapsedTime = (double) (end - start) / 1.0e06; // Zeit in msec

        // Zum Zeigenb, dass sortiert wurde
        System.out.println("\nSortiert:");
        for (Integer integer : test1) {
            System.out.print(integer + "; ");
        }

        System.out.printf("\nZeit Test 1: %s msec\n", elapsedTime);

        // Test 2 (Zufällige Zahlen sortieren)
        System.out.println("\nTest 2:");
        Integer[] test2 = new Integer[200];

        System.out.println("Unsortiert:");
        for (int i = 0; i < test2.length; i++) {
            test2[i] = (int) (Math.random() * 200);
            System.out.print(test2[i] + ", ");
        }
        start = System.nanoTime(); // aktuelle Zeit in nsec
        // Sortieren
        HybridQS.hybridQuickSort(test2);
        end = System.nanoTime();
        elapsedTime = (double) (end - start) / 1.0e06; // Zeit in msec

        // Zum Zeigen, dass sortiert wurde
        System.out.println("\nSortiert:");
        for (Integer integer : test2) {
            System.out.print(integer + "; ");
        }
        System.out.printf("\nZeit Test 2: %s msec\n", elapsedTime);

        // Test 3 (Wörter in Kafka_der_Prozess sortieren)
        String[] test3 = new String[1000];
        int index = 0;

        LineNumberReader in;
        in = new LineNumberReader(new FileReader("Kafka_Der_Prozess.txt"));
        String line;

        // Text einlesen und Häufigkeiten aller Wörter bestimmen:
        while ((line = in.readLine()) != null) {
            String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");
            for (String w : wf) {
                if (w.length() == 0 || w.length() == 1)
                    continue;
                //System.out.println(w);
                if (index >= test3.length) {
                    test3 = Arrays.copyOf(test3, test3.length + 1000);
                }
                test3[index] = w;
                index++;
            }
        }

        test3 = Arrays.copyOf(test3, index);
        String[] test3_copy = Arrays.copyOf(test3, test3.length);

        // Zum Zeigen, dass sortiert wurde
        /*System.out.println("Sortiert:");
        for (String w: test3) {
            System.out.print(w + ", ");
        }*/

        hybridQuickSort(test3, "Kafka");
        hybridQuickSortMedian(test3_copy, "Kafka");

        // Test 4 (Spielkarten sortieren)
        Card[] cardTest100 = new Card[100000];
        Card[] cardTest200 = new Card[200000];

        // 100 zufällige Karten erzeugen
        for (int i = 0; i < cardTest100.length; i++) {
            if ((int) (Math.random() * 2) == 0) {
                cardTest100[i] = new BlackCard();
            } else {
                cardTest100[i] = new RedCard();
            }
            // System.out.printf("%s, ", cardTest100[i]);
        }
        Card[] card100_copy = Arrays.copyOf(cardTest100, cardTest100.length);
        Card[] card100_copy1 = Arrays.copyOf(cardTest100, cardTest100.length);

        // Zum Zeigen, dass sortiert wurde
        /*System.out.println("Sortiert:");
        for (int i = 0; i < cardTest100.length; i++) {
            System.out.printf("%s, ", cardTest100[i]);
        }*/

        hybridQuickSort(cardTest100, "100.000 Spielkarten");
        hybridQuickSortMedian(card100_copy, "100.000 Spielkarten");
        arraySort(card100_copy1, "100.000 Spielkarten");

        hybridQuickSort(cardTest100, "100.000 sortierte Karten");
        hybridQuickSortMedian(cardTest100, "100.000 sortierte Karten");
        arraySort(cardTest100, "100.000 sortierte Karten");


        // 200 zufällige Karten erzeugen
        for (int i = 0; i < cardTest200.length; i++) {
            if ((int) (Math.random() * 2) == 0) {
                cardTest200[i] = new BlackCard();
            } else {
                cardTest200[i] = new RedCard();
            }
            // System.out.printf("%s, ", cardTest200[i]);
        }
        Card[] card200_copy = Arrays.copyOf(cardTest200, cardTest200.length);
        Card[] card200_copy1 = Arrays.copyOf(cardTest200, cardTest200.length);

        // Zum Zeigen, dass sortiert wurde
        /* Systen.out.println("Sortiert:");
        for (int i = 0; i < cardTest200.length; i++) {
            System.out.printf("%s, ", cardTest200[i]);
        }*/

        hybridQuickSort(cardTest200, "200.000 Spielkarten");
        // Zum Zeigen, dass sortiert wurde
        /*System.out.println("Sortiert:");
        for (int i = 0; i < cardTest200.length; i++) {
            System.out.printf("%s, ", cardTest200[i]);
        }*/
        hybridQuickSortMedian(card200_copy, "200.000 Spielkarten");
        arraySort(card200_copy1, "200.000 Spielkarten");

        //hybridQuickSort(cardTest200, "200.000 sortierte Karten");
        hybridQuickSortMedian(cardTest200, "200.000 sortierte Karten");
        arraySort(cardTest200, "200.000 sortierte Karten");
    }

    private static <T extends Comparable<T>> void hybridQuickSort(T[] a, String text) {
        System.out.printf("\nZeit %s mit HybridQuicksort: ", text);
        long start = System.nanoTime(); // aktuelle Zeit in nsec
        // Sortieren HybridQuicksort
        HybridQS.hybridQuickSort(a);
        long end = System.nanoTime();
        double elapsedTime = (double)(end-start)/1.0e06; // Zeit in msec

        System.out.printf("%s msec\n", elapsedTime);
    }

    private static <T extends Comparable<T>> void hybridQuickSortMedian(T[] a, String text) {
        System.out.printf("\nZeit %s mit HybridQuicksortMedian: ", text);
        long start = System.nanoTime(); // aktuelle Zeit in nsec
        // Sortieren HybridQuicksortMedian
        HybridQS.hybridQuickSortMedian(a);
        long end = System.nanoTime();
        double elapsedTime = (double)(end-start)/1.0e06; // Zeit in msec

        System.out.printf("%s msec\n", elapsedTime);
    }

    private static <T extends Comparable<T>> void arraySort(T[] a, String text) {
        System.out.printf("\nZeit %s mit Arrays.sort: ", text);
        long start = System.nanoTime(); // aktuelle Zeit in nsec
        // Sortieren Arrays.sort
        Arrays.sort(a);
        long end = System.nanoTime();
        double elapsedTime = (double)(end-start)/1.0e06; // Zeit in msec

        System.out.printf("%s msec\n", elapsedTime);
    }
}
