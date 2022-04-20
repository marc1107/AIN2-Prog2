package tsaufgabe4;

import java.util.Random;

/**
 *
 * @author oliverbittel
 * @since 12.2.2020
 */
public class CardFrequencyTable_Test {

	public static void main(String[] args) {

		FrequencyTable<Card> cardTab1 = new ArrayFrequencyTable<>();
		FrequencyTable<Card> cardTab2 = new ArrayFrequencyTable<>();
		FrequencyTable<RedCard> redCardTab = new ArrayFrequencyTable<>();
		FrequencyTable<BlackCard> blackCardTab = new ArrayFrequencyTable<>();

		// Beachte:
		// Evtl. wird bei Ihnen die rite Karte "sieben Herz" anders definiert.
		redCardTab.add(new RedCard(Card.Farbe.Herz, Card.Wert.Sieben));
		System.out.println(redCardTab.get(new RedCard(Card.Farbe.Herz, Card.Wert.Sieben))); // sollte die Häufigkeit 1 ergeben
		
		Random rand = new Random();
		for (int i = 0; i < 400; i++) {
			if (rand.nextInt() % 2 == 0) {
				RedCard c = new RedCard(Card.Farbe.Herz, Card.Wert.Bube);
				cardTab1.add(c);
				redCardTab.add(c);
			} else {
				BlackCard c = new BlackCard(Card.Farbe.Kreuz, Card.Wert.Koenig);
				cardTab1.add(c);
				blackCardTab.add(c);
			}
		}

		System.out.println(cardTab1);
		System.out.println(redCardTab);
		System.out.println(blackCardTab);

		//redCardTab.addAll(cardTab1); // nicht OK
		cardTab1.addAll(redCardTab);
		redCardTab.addAll(redCardTab);
		System.out.println(redCardTab);
		cardTab1.copyMostFrequent(cardTab2);
		//cardTab1.collectMostFrequent(redCardTab); // nicht OK	
		redCardTab.copyMostFrequent(cardTab1);
	}
}
