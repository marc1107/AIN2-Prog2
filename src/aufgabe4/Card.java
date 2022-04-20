package aufgabe4;

public abstract class Card
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Card c) {
            return (this.suit == c.suit && this.rank == c.rank);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.suit + " " + this.rank;
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