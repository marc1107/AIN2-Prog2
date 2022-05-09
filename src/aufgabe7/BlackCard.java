package aufgabe7;

public class BlackCard extends Card {

    public BlackCard(Suit suit, Rank rank) {
        this.setSuit(suit);
        this.setRank(rank);

        if (suit == Suit.Herz || suit == Suit.Karo)
            throw new IllegalArgumentException("Falsche farbe!");
    }

    public BlackCard() {
        int value = (int) (Math.random() * 2);

        if (value == 0) {
            suit = Suit.Pik;
        } else {
            suit = Suit.Kreuz;
        }
        rank = ranks[(int) (Math.random() * 8)];
    }

}