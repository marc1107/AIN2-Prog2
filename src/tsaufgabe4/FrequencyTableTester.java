package tsaufgabe4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 *
 * @author Tim Koehler
 * @since 23.3.2019
 */
public class FrequencyTableTester
{

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		test1();
		test2();

		FrequencyTable<Card> cardTab1 = new LinkedListFrequencyTable<Card>();
		FrequencyTable<Card> cardTab2 = new ArrayFrequencyTable<Card>();
		FrequencyTable<RedCard> redCardTab = new LinkedListFrequencyTable<RedCard>();
		FrequencyTable<BlackCard> blackCardTab = new ArrayFrequencyTable<BlackCard>();
		// redCardTab.addAll(blackCardTab); // nicht OK
		cardTab1.addAll(redCardTab);// OK
		cardTab1.copyMostFrequent(cardTab2);// OK
		// cardTab1.copyMostFrequent(redCardTab); // nicht OK
		redCardTab.copyMostFrequent(cardTab1);// OK

	}

	private static void test1()
	{
		// Test von add:
		FrequencyTable<String> tab1 = new LinkedListFrequencyTable<>();

		tab1.add("das");
		tab1.add("ist");
		tab1.add("ein");
		tab1.add("Test");
		tab1.add("das", 2);
		tab1.add("ein", 3);

		System.out.println(tab1);

		System.out.println("Soll: ein:4");
		System.out.println("Ist:  " + tab1.get(0) + "\n");

		System.out.println("Soll: das:3");
		System.out.println("Ist:  " + tab1.get(1) + "\n");

		System.out.println("Soll: 3");
		System.out.println("Ist:  " + tab1.get("das") + "\n");

		System.out.println("Soll: 1");
		System.out.println("Ist:  " + tab1.get("ist") + "\n");

		System.out.println("Soll: 4");
		System.out.println("Ist:  " + tab1.get("ein") + "\n");

		System.out.println("Soll: 0");
		System.out.println("Ist:  " + tab1.get("Text") + "\n");

		System.out.println("Soll: {ein:4, das:3, ist:1, Test:1, } size = 4");
		System.out.println("Ist:  " + tab1 + "\n");

		// Test von addAll:
		FrequencyTable<String> tab2 = new LinkedListFrequencyTable<>();
		tab2.add("das");
		tab2.add("ist");
		tab2.add("kurzer");
		tab2.add("Text");
		tab1.addAll(tab2);
		System.out.println("Soll: {ein:4, das:4, ist:2, Test:1, kurzer:1, Text:1, } size = 6");
		System.out.println("Ist:  " + tab1 + "\n");

		// Test von clear, copyMostFrequent und copyLeastFrequent:
		tab2.clear();
		tab1.copyMostFrequent(tab2);
		System.out.println("Soll: {ein:4, das:4, } size = 2");
		System.out.println("Ist:  " + tab2 + "\n");

		tab2.clear();
		tab1.copyLeastFrequent(tab2);
		System.out.println("Soll: {Test:1, kurzer:1, Text:1, } size = 3");
		System.out.println("Ist:  " + tab2 + "\n");
	}

	private static void test2() throws FileNotFoundException, IOException
	{
		FrequencyTable<String> tab = new ArrayFrequencyTable<>();

		long start = System.nanoTime(); // aktuelle Zeit in nsec
		LineNumberReader in;
		in = new LineNumberReader(new FileReader("Kafka_Der_Prozess.txt"));
		String line;

		// Text einlesen und Häfigkeiten aller Wörter bestimmen:
		while ((line = in.readLine()) != null)
		{
			String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");
			for (String w : wf)
			{
				if (w.length() == 0 || w.length() == 1)
					continue;
				// System.out.println(w);
				tab.add(w);
			}
		}

		long end = System.nanoTime();
		double elapsedTime = (double) (end - start) / 1.0e06; // Zeit in msec

		// Ausgabe der 100 häufigsten Wörter:
		FrequencyTable<String> mostFrequentTbl = new LinkedListFrequencyTable<>();
		for (int i = 0; i < 100; i++)
		{
			mostFrequentTbl.add((String) tab.get(i).getContent(), tab.get(i).getFrequency());
		}
		System.out.println(mostFrequentTbl);

		System.out.println("");
		System.out.println("Benötigte Zeit in msec: " + elapsedTime);
	}
}
