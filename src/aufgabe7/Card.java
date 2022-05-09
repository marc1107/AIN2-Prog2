package aufgabe7;

public abstract class Card implements Comparable<Card>
{
    protected Suit suit;
    protected Rank rank;
    protected Rank[] ranks = rank.values();

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

    @Override
    public int compareTo(Card c) {
        if (this.rank.compareTo(c.getRank()) == 0) {
            return Integer.compare(this.suit.compareTo(c.getSuit()), 0);
        } else if (this.rank.compareTo(c.getRank()) < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}