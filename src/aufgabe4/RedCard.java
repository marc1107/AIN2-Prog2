package aufgabe4;

public class RedCard extends Card
{

    public RedCard(Suit suit, Rank rank)
    {
        super(suit, rank);

        if (suit == Card.Suit.Kreuz || suit == Card.Suit.Pik)
            throw new IllegalArgumentException("Falsche farbe!");
    }

}