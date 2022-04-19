package aufgabe4;

public class Card
{
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank)
    {
        this.setSuit(suit);
        this.setRank(rank);
    }

    public Suit getSuit()
    {
        return suit;
    }

    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }

    public Rank getRank()
    {
        return rank;
    }

    public void setRank(Rank rank)
    {
        this.rank = rank;
    }

    public boolean equals(Card c) {
        return (this.suit == c.suit && this.rank == this.rank);
    }

    public String toString() {
        return this.suit + ":" + this.rank;
    }

    public enum Suit
    {
        Karo, Herz, Pik, Kreuz
    }

    public enum Rank
    {
        Sieben, Acht, Neun, Zehn, Bube, Dame, Koenig, Ass
    }
}