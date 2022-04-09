/* Wortweises Einlesen eines deutschen Textes von einer Datei.
 * Ermittlung der Haefigkeiten der Woerter und Ausgabe der  
 * 100 haeufigsten Woerter.
 *
 * Oliver Bittel; 10.03.2019
 */
package aufgabe11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Map;
import java.util.TreeMap;

public class HaeufigkeitsanalyseEinesDeutschenTextes {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Map<String,Integer> haeufigkeit = ermittleHaufigekeiten("xxx.txt");
		printTop100(haeufigkeit);
	}
	
	public static Map<String,Integer> ermittleHaufigekeiten(String fileName) throws FileNotFoundException, IOException {
		
		LineNumberReader in = new LineNumberReader(new FileReader(fileName));
		String line;
		
		Map<String,Integer> haeufigkeit = new TreeMap<>(); 	// enthaelt zu jedem Wort seine Haefigkeit
				
		while ((line = in.readLine()) != null) {
			String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");
			for (String w: wf) {
				if (w.length() == 0 || w.length() == 1) 
					continue;
				System.out.println(w);
				// Ihr Code:
				// ...
			}
		}
		
		return haeufigkeit;
	}
	
	public static void printTop100(Map<String,Integer> h) {
		// Ihr Code:
		// ...
	}
	
}
