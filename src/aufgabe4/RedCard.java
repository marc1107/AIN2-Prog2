package aufgabe4;

import java.util.Random;

public class RedCard extends Card {

    public RedCard(Suit suit, Rank rank) {
        this.setSuit(suit);
        this.setRank(rank);

        if (suit == Card.Suit.Kreuz || suit == Card.Suit.Pik)
            throw new IllegalArgumentException("Falsche farbe!");
    }

    public RedCard() {
        int value = (int) (Math.random() * 2);;

        if (value == 0) {
            suit = Suit.Herz;
        } else {
            suit = Suit.Karo;
        }
        rank = ranks[(int) (Math.random() * 8)];
    }

}