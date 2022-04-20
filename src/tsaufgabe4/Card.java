package tsaufgabe4;

public class Card
{
	private Farbe farbe;
	private Wert wert;

	public Card(Farbe farbe, Wert wert)
	{
		this.setFarbe(farbe);
		this.setWert(wert);
	}

	public Farbe getFarbe()
	{
		return farbe;
	}

	public void setFarbe(Farbe farbe)
	{
		this.farbe = farbe;
	}

	public Wert getWert()
	{
		return wert;
	}

	public void setWert(Wert wert)
	{
		this.wert = wert;
	}

	public enum Farbe
	{
		Karo, Herz, Pique, Kreuz
	}

	public enum Wert
	{
		Sieben, Acht, Neun, Zehn, Bube, Dame, Koenig, Ass
	}
}
