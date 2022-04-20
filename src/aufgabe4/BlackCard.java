package aufgabe4;

public class BlackCard extends Card {

    public BlackCard(Suit suit, Rank rank) {
        super(suit, rank);

        if (suit == Card.Suit.Herz || suit == Card.Suit.Karo)
            throw new IllegalArgumentException("Falsche farbe!");
    }

    public BlackCard() {
        super(Suit.Pik, Rank.Bube);
    }

}