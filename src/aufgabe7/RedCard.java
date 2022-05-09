package aufgabe7;

public class RedCard extends Card {

    public RedCard(Suit suit, Rank rank) {
        this.setSuit(suit);
        this.setRank(rank);

        if (suit == Suit.Kreuz || suit == Suit.Pik)
            throw new IllegalArgumentException("Falsche farbe!");
    }

    public RedCard() {
        int value = (int) (Math.random() * 2);

        if (value == 0) {
            suit = Suit.Herz;
        } else {
            suit = Suit.Karo;
        }
        rank = ranks[(int) (Math.random() * 8)];
    }
}